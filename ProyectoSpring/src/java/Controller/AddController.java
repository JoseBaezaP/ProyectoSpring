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
 *
 * @author josed
 */
@Controller
@RequestMapping("add.htm")
public class AddController {
    LibrosValidaciones librosValidar;
    private JdbcTemplate jdbctemplate;
    
    public AddController(){
    this.librosValidar=new LibrosValidaciones();
    Conexion con=new Conexion();
    this.jdbctemplate=new JdbcTemplate(con.conectar());
    }
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add");
        mav.addObject("libros",new Libro());
        return mav;
    }
     @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("libros") Libro u,BindingResult result,
                                SessionStatus status){
       this.librosValidar.validate(u, result);
   
           this.jdbctemplate.update("insert into libros (isbn,nombre,autor,version,editorial) values(?,?,?,?,?)",
                                    u.getIsbn(),u.getNombre(),u.getAutor(),u.getVersion(),u.getEditorial());
           return new ModelAndView("redirect:/index.htm");
       
    }
}
