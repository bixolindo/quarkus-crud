package br.com.mp.product.repository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import br.com.mp.product.model.Creche;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CrecheRepository implements PanacheRepository<Creche> {

	public List<Creche> list() {
		return listAll();
	}

	public Creche findId(Long id) {
		return findById(id);
	}

	@Transactional
	public Creche save(Creche creche) {
		persist(creche);
		return creche;
	}
	
	@Transactional
	public Creche update(Long id, Creche creche) {
		Creche crecheBanco = findById(id);
		crecheBanco.setBairro(creche.getBairro());
		crecheBanco.setLimite(creche.getLimite());
		crecheBanco.setName(creche.getName());
		persist(crecheBanco);
		return crecheBanco;
	}

	@Transactional
	public void remove(Long id) {
		Creche crecheEntity = findById(id);
		delete(crecheEntity);
	}
}
