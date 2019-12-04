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

    public Libro(String nombre, String autor, int version, String editorial) {
        this.nombre = nombre;
        this.autor = autor;
        this.version = version;
        this.editorial = editorial;
    }
     public Libro(String isbn, String nombre, String autor, int version, String editorial) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.version = version;
        this.editorial = editorial;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    
    
}
