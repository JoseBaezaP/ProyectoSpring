/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *Clase Libro: Este es el objeto libro que no adyudará para poder guardar los datos necesarios
 * @author josed
 */
public class Libro {
    private String isbn;
    private String nombre;
    private String autor;
    private int version;
    private String editorial;

    public Libro() {
    }
    /**
     * <p>
     * Constructor usado unicamente para poder actualizar datos de libro.
     */
    public Libro(String nombre, String autor, int version, String editorial) {
        this.nombre = nombre;
        this.autor = autor;
        this.version = version;
        this.editorial = editorial;
    }
    /**
     * <p>
     * Constructor usado para crear un libro.
     */
     public Libro(String isbn, String nombre, String autor, int version, String editorial) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.version = version;
        this.editorial = editorial;
    }

    /**
     * <p>
     * Regresa el valor del ISBN
     */
    public String getIsbn() {
        return isbn;
    }
/**
     * <p>
     * Funcion set para poder cambiar el valor del isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * <p>
     * Regresa el valor del Nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * <p>
     * Funcion set para poder cambiar el valor del nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * <p>
     * Regresa el valor del Autor
     */
    public String getAutor() {
        return autor;
    }
    /**
     * <p>
     * Funcion set para poder cambiar el valor del autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
     * <p>
     * Regresa el valor de version
     */
    public int getVersion() {
        return version;
    }
    /**
     * <p>
     * Funcion set para poder cambiar el valor de version
     */
    public void setVersion(int version) {
        this.version = version;
    }
    /**
     * <p>
     * Regresa el valor de la Editorial
     */
    public String getEditorial() {
        return editorial;
    }
    /**
     * <p>
     * Funcion set para poder cambiar el valor de la editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    
    
}
