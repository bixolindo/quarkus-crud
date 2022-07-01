package br.com.mp.product.model;

public class CriancaDTO {

	public String name_pais;

	public String rg;

	public int id_creche;

	public Long id;

	public String name;

	public String endereco;

	public String comprovante;
	
	public boolean valido;

	public CriancaDTO() {
		super();
	}

	public CriancaDTO(String namepais, String rg, int type, Long id, String name, String address,
			String base64, boolean valido) {
		super();
		this.name_pais = namepais;
		this.rg = rg;
		this.id_creche = type;
		this.id = id;
		this.name = name;
		this.endereco = address;
		this.comprovante = base64;
		this.valido = valido;
	}

}
