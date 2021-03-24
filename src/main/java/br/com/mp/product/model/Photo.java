package br.com.mp.product.model;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class Photo extends PanacheEntity{
    
    @NotNull
    @NotBlank(message="photo may not be blank")
    private byte[] photo;

    @OneToOne()
    @JoinColumn(name = "user_id", nullable = false)
    protected Person user;
}
