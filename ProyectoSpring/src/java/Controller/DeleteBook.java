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
 *Clase DeleteBook: La acción que hace esta esta clase es recuperar el isbn
 * del libro para poder elimnarlo de la base de datos.
 * @author josed
 */
public class DeleteBook {
   private JdbcTemplate jdbctemplate;
      /**
     * <p>
     * Se establece la conexion a la base de datos.
     */
    public DeleteBook(){
    Conexion con=new Conexion();
    this.jdbctemplate=new JdbcTemplate(con.conectar());
    }
    /**
     * <p>
     * Se establece la conexion a la base de datos.
     */
    @RequestMapping("delete.htm")
    public ModelAndView borrarLibro(HttpServletRequest request){
        String isbn=request.getParameter("isbn");
        this.jdbctemplate.update("delete from libros "+"where "+"isbn=?",
                                    isbn);
          
        return new ModelAndView("redirect:/index.htm");
    }
     
}
