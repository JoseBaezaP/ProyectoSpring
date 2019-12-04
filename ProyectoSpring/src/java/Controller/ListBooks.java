/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *Clase ListBook: La acción que hace esta esta clase es recuperar todos
 * datos que estan la base de datos para poder imprimirlos en la primera vista
 */

public class ListBooks {
    private JdbcTemplate jdbcTemplate;
    
    public ListBooks(){
        Conexion con=new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("index.htm")
    public ModelAndView mostrarLibros(){
    ModelAndView mav = new ModelAndView();
    String sql="select * from libros";
    List datos=this.jdbcTemplate.queryForList(sql);
    mav.addObject("datos",datos);
    mav.setViewName("index");
    return mav;
    }
}
