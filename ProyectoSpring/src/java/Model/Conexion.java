/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *Clase Conexion: Lo unico que hace esta clase es conectarse a la base de datos.
 * @author josed
 */
public class Conexion {
     /**
     * <p>
     * Hace la conexcion a la base de datos y crea un objeto para poder validar los campo
     */
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/biblioteca");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}
