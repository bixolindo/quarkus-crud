package br.com.mp.product.repository.converter;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.mp.product.model.Crianca;
import br.com.mp.product.model.CriancaDTO;


@ApplicationScoped
public class CriancaConverter {

	public CriancaDTO ormToDto(Crianca crianca) {
		String decoded = null;
		if (crianca.comprovante != null) {
			decoded = new String(Base64.getDecoder().decode(crianca.comprovante));
		}

		return new CriancaDTO(crianca.name_pais, crianca.rg, crianca.id_creche, crianca.id, crianca.name,
				crianca.endereco, decoded, crianca.valido);
	}

	public Crianca dtoToOrm(CriancaDTO criancaDTO) {
		byte[] base64Byte = null;
		if (criancaDTO.comprovante != null) {
			base64Byte = Base64.getEncoder().encode(criancaDTO.comprovante.getBytes());
		}

		Crianca newCrianca = new Crianca();

		newCrianca.name_pais = criancaDTO.name_pais;
		newCrianca.endereco = criancaDTO.endereco;
		newCrianca.rg = criancaDTO.rg;
		newCrianca.id_creche = criancaDTO.id_creche;
		newCrianca.name = criancaDTO.name;
		newCrianca.comprovante = base64Byte;
		newCrianca.valido = criancaDTO.valido;
		return newCrianca;
	}

	public List<CriancaDTO> ormListToDtoList(List<Crianca> ormList) {
		List<CriancaDTO> dtos = new ArrayList<CriancaDTO>();
		if (ormList != null) {
			ormList.stream().forEach(orm -> dtos.add(ormToDto(orm)));
			return dtos;
		}
		return dtos;
	}

}
