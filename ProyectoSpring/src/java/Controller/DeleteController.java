/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.Libro;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author josed
 */
public class DeleteController {
   private JdbcTemplate jdbctemplate;
    
    public DeleteController(){
    Conexion con=new Conexion();
    this.jdbctemplate=new JdbcTemplate(con.conectar());
    }
    @RequestMapping("delete.htm")
    public ModelAndView form(HttpServletRequest request){
        String isbn=request.getParameter("isbn");
        this.jdbctemplate.update("delete from libros "+"where "+"isbn=?",
                                    isbn);
          
        return new ModelAndView("redirect:/index.htm");
    }
     
}
