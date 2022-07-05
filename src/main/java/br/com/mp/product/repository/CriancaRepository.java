package br.com.mp.product.repository;

import br.com.mp.product.model.Crianca;
import br.com.mp.product.model.CriancaDTO;
import br.com.mp.product.repository.converter.CriancaConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;

@ApplicationScoped
public class CriancaRepository implements PanacheRepository<Crianca> {

	@Inject
	CriancaConverter criancaConverter;

	public List<CriancaDTO> list() {
		return criancaConverter.ormListToDtoList(listAll());
	}

	public CriancaDTO findId(Long id) {
		return criancaConverter.ormToDto(findById(id));
	}

	@Transactional
	public CriancaDTO save(CriancaDTO crianca) {
		Crianca newCrianca = criancaConverter.dtoToOrm(crianca);
		persist(newCrianca);
		crianca.id = newCrianca.id;
		return crianca;
	}

	@Transactional
	public CriancaDTO update(Long id, CriancaDTO crianca) {
		Crianca criancaEntity = findById(id);

		Crianca updatedPerson = criancaConverter.dtoToOrm(crianca);

		criancaEntity.name = crianca.name;
		criancaEntity.rg = crianca.rg;
		criancaEntity.id_creche = crianca.id_creche;
		criancaEntity.name_pais = crianca.name_pais;
		criancaEntity.endereco = crianca.endereco;
		criancaEntity.comprovante = updatedPerson.comprovante;
		criancaEntity.valido = crianca.valido;
		persist(criancaEntity);
		return criancaConverter.ormToDto(criancaEntity);
	}

	@Transactional
	public void remove(Long id) {
		Crianca criancaEntity = findById(id);
		delete(criancaEntity);
	}
}
