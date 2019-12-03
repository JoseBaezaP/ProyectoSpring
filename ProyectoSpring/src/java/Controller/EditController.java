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
/**
 *
 * @author josed
 */
@Controller
@RequestMapping("edit.htm")
public class EditController {
       LibrosValidaciones librosValidar;
    private JdbcTemplate jdbctemplate;
       public EditController(){
    this.librosValidar=new LibrosValidaciones();
    Conexion con=new Conexion();
    this.jdbctemplate=new JdbcTemplate(con.conectar());
    }
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        String isbn=request.getParameter("isbn");
        Libro libro=this.selectLibro(isbn);
        mav.setViewName("edit");
        mav.addObject("libros",new Libro(isbn,libro.getNombre(),libro.getAutor(),libro.getVersion(),libro.getEditorial()));
        return mav;
    }
     @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("libros") Libro u,BindingResult result,
                                SessionStatus status, HttpServletRequest request){
      
        this.librosValidar.validate(u, result);
   String isbn=request.getParameter("isbn");
           this.jdbctemplate.update("update libros "+"set nombre=?,"+" autor=?,"+" version=?,"+" editorial=? "+"where "+"isbn=?",
                                    u.getNombre(),u.getAutor(),u.getVersion(),u.getEditorial(),isbn);
           return new ModelAndView("redirect:/index.htm");
       
    }
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
