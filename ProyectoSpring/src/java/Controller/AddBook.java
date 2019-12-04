/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.Libro;
import Model.LibrosValidaciones;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *Clase AddBook: La acción que hace esta esta clase es recuperar los datos
 * obtenidos de la vista para poder ingresarlos a la base de datos.
 * @author josed
 */
@Controller
@RequestMapping("add.htm")
public class AddBook {
    LibrosValidaciones librosValidar;
    private JdbcTemplate jdbctemplate;
      /**
     * <p>
     * Hace la conexcion a la base de datos y crea un objeto para poder validar los campo
     */
    public AddBook(){
    this.librosValidar=new LibrosValidaciones();
    Conexion con=new Conexion();
    this.jdbctemplate=new JdbcTemplate(con.conectar());
    }
      /**
     * <p>
     * Al ingresar a la página para poder agregar un libro, se le pasa un objeto de tipo libro
     * para poder guardar los datos momentaneamente.
     * @return mav -Regresa la vista para el usuario
     */
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView mostarDatos(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add");
        mav.addObject("libros",new Libro());
        return mav;
    }
      /**
     * <p>
     * Guarda los datos recuperados por el usuario.
     * @param u Son los datos recuperados por el usuario. 
     * @return mav -Regresa la vista para el usuario
     */
     @RequestMapping(method=RequestMethod.POST)
    public ModelAndView guardarDatos(@ModelAttribute("libros") Libro u,BindingResult result,
                                SessionStatus status){
       this.librosValidar.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            mav.setViewName("add");
            mav.addObject("libros",new Libro());
            return mav;
        }else{
         this.jdbctemplate.update("insert into libros (isbn,nombre,autor,version,editorial) values(?,?,?,?,?)",
                                    u.getIsbn(),u.getNombre(),u.getAutor(),u.getVersion(),u.getEditorial());
           return new ModelAndView("redirect:/index.htm");
        }  
    }
}
