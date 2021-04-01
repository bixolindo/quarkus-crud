package br.com.mp.product.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Photo extends PanacheEntity {

    @NotNull
    public byte[] photo;

    @OneToOne()
    @JoinColumn(name = "user_id", nullable = false)
    public Person user;
}
