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
 *
 * @author josed
 */
public class LibrosValidaciones implements Validator{
    private static final String ISBN_PATTERN = "^[0-9]*-"+"^[0-9]";
    private Pattern pattern;
    private Matcher matcher;
    @Override
    public boolean supports(Class<?> type) {
       return Libro.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
       Libro libro=(Libro)o;
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"isbn","required.isbn","El campo de ISBN es obligatorio");
      if(!(libro.getIsbn()!=null && libro.getIsbn().isEmpty())){
           this.pattern = Pattern.compile(ISBN_PATTERN);
           this.matcher =pattern.matcher(libro.getIsbn());
           if(!matcher.matches()){
               errors.rejectValue("isbn","isbn.incorrect","El isbn"+libro.getIsbn()+"no es valido");
           }    
       }
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","required.nombre","El campo de nombre es obligatorio");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"autor","required.autor","El campo de autor es obligatorio");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"version","required.version","El campo de version es obligatorio");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors,"editorial","required.editorial","El campo de editorial es obligatorio");
       
       
    }
    
}
