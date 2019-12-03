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
 *
 * @author josed
 */

public class Controller {
    private JdbcTemplate jdbcTemplate;
    
    public Controller(){
        Conexion con=new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("index.htm")
    public ModelAndView home(){
    ModelAndView mav = new ModelAndView();
    String sql="select * from libros";
    List datos=this.jdbcTemplate.queryForList(sql);
    mav.addObject("datos",datos);
    mav.setViewName("index");
    return mav;
    }
}
