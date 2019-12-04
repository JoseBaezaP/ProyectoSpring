/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *Clase LibrosValidaciones: La que hace esta clase es validar que los campos para poder ingresar un libro
 * no se encuentren vacios o nulos
 * @author josed
 */
public class LibrosValidaciones implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return Libro.class.isAssignableFrom(type);
    }
    /**
     * <p>
     * Verifica que los campos de las vistas add y edit no se encuentren en null o vacios
     * @param o recupera el objeto con los valores a probar
     * @param errors vuelve el error obtenido por la página
     */
    @Override
    public void validate(Object o, Errors errors) {
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"isbn","required.isbn","El campo de ISBN es obligatorio");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","required.nombre","El campo de nombre es obligatorio");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"autor","required.autor","El campo de autor es obligatorio");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"version","required.version","El campo de version es obligatorio");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"editorial","required.editorial","El campo de editorial es obligatorio");
       
       
    }
    
}
