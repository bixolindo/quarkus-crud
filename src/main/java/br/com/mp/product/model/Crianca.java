package br.com.mp.product.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;


@Entity
public class Crianca extends PanacheEntity {

	public String name;

	public String name_pais;

	public String rg;

	public int id_creche;

	public String endereco;

	public byte[] comprovante;
	
	public boolean valido;

}
