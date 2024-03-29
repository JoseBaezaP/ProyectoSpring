/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.Libro;
import Model.LibrosValidaciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


/**
 *Clase EditBook: La acción que hace esta esta clase es recuperar los datos
 * de la base de datos, para mostrarlo en la vista y tambien recupera los 
 * datos que sufrieron un cambio para poder hacer la actualiazción.
 * @author josed
 */
@Controller
@RequestMapping("edit.htm")
public class EditBook {
       LibrosValidaciones librosValidar;
    private JdbcTemplate jdbctemplate;
     /**
     * <p>
     * Se establece la conexion a la base de datos.
     */
       public EditBook(){
    this.librosValidar=new LibrosValidaciones();
    Conexion con=new Conexion();
    this.jdbctemplate=new JdbcTemplate(con.conectar());
    }
         /**
     * <p>
     * Al ingresar a la página para poder editar un libro, se le pasa un objeto de tipo libro
     * para poder guardar los datos momentaneamente.
     * @return mav -Regresa la vista para el usuario
     */
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView mostrarDatos(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        String isbn=request.getParameter("isbn");
        Libro libro=this.selectLibro(isbn);
        mav.setViewName("edit");
        mav.addObject("libros",new Libro(request.getParameter("isbn"),libro.getNombre(),libro.getAutor(),libro.getVersion(),libro.getEditorial()));
        return mav;
    }
     /**
     * <p>
     * Actualiza los datos recuperados por el usuario.
     * @param u Son los datos que ingreso el usuario. 
     * @return mav,ModelAndView("redirect:/index.htm" -Si encuentra un problema de validacion, se regresa a la pagina
     * para ingresar  un libro con los errores, si no se hubieron errores se va a la vista principal para ver los libros
     */
     @RequestMapping(method=RequestMethod.POST)
    public ModelAndView actualizarDatos(@ModelAttribute("libros") Libro u,BindingResult result,
                                SessionStatus status, HttpServletRequest request){
      
        this.librosValidar.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            mav.setViewName("add");
            mav.addObject("libros",new Libro());
            return mav;
        }else{
            String isbn=request.getParameter("isbn");
           this.jdbctemplate.update("update libros "+"set nombre=?,"+" autor=?,"+" version=?,"+" editorial=? "+"where "+"isbn=?",
                                    u.getNombre(),u.getAutor(),u.getVersion(),u.getEditorial(),isbn);
           return new ModelAndView("redirect:/index.htm");
        }   
    }
     /**
     * <p>
     * Recupera los datos de la base de datos.
     * @param isbn El la llave primaria del libro. 
     * @return Regresa un objeto de tipo libro con los datos recueperados de la base de datos.
     */
    public Libro selectLibro(String isbn){
        final Libro libro= new Libro();
        String quer= "SELECT *FROM libros WHERE isbn='"+isbn+"'";
        return (Libro) jdbctemplate.query(quer, new ResultSetExtractor<Libro>(){

            public Libro extractData(ResultSet rs) throws SQLException, DataAccessException {
                 if(rs.next()){
                     libro.setNombre(rs.getString("nombre"));
                     libro.setAutor(rs.getString("autor"));
                     libro.setVersion(rs.getInt("version"));
                     libro.setEditorial(rs.getString("editorial"));
                    
                 }
                  return libro;
            }
        });
    }
}
