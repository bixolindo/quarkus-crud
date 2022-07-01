package br.com.mp.product.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Person extends PanacheEntity {

    @NotNull
    @NotBlank(message = "Name may not be blank")
    public String name;

    public String namepais;

    public String rg;
    
    public int type;
    
    public String password;

    public String address;

    public byte[] base64;
    
    public static Person findByName(String name, String password){
        return find("name = ?1 AND password = ?2", name, password).firstResult();
    }
}
