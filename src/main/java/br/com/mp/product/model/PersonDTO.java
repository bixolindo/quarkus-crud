package br.com.mp.product.model;

public class PersonDTO {

	public String namepais;

	public String rg;

	public int type;

	public String password;

	public Long id;

	public String name;

	public String address;

	public String base64;

	public PersonDTO() {
		super();
	}

	public PersonDTO(String namepais, String rg, int type, String password, Long id, String name, String address,
			String base64) {
		super();
		this.namepais = namepais;
		this.rg = rg;
		this.type = type;
		this.password = password;
		this.id = id;
		this.name = name;
		this.address = address;
		this.base64 = base64;
	}

}
