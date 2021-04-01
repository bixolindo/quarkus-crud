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

    public int sex;

    public int age;

    @NotBlank(message = "adress may not be blank")
    public String address;

    public byte[] base64;

}
