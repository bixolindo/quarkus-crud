package br.com.mp.product.repository;

import br.com.mp.product.model.Person;
import br.com.mp.product.model.PersonDTO;
import br.com.mp.product.repository.converter.PersonConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Inject
    PersonConverter personConverter;

    public List<PersonDTO> list() {
        return personConverter.ormListToDtoList(listAll());
    }

    public PersonDTO findId(Long id) {
        return personConverter.ormToDto(findById(id));
    }

    @Transactional
    public PersonDTO save(PersonDTO person) {
        Person newPerson = personConverter.dtoToOrm(person);
        persist(newPerson);
        person.id = newPerson.id;
        return person;
    }
    
    public Person autenticar(Person person) {
    	Person pessoaBanco = Person.findByName(person.name, person.password);
    	return pessoaBanco;
    }

    @Transactional
    public PersonDTO update(Long id, PersonDTO person) {
        Person personEntity = findById(id);

        Person updatedPerson = personConverter.dtoToOrm(person);

        personEntity.name = person.name;
        personEntity.rg = person.rg;
        personEntity.type = person.type;
        personEntity.namepais = person.namepais;
        personEntity.password = person.password;
        personEntity.address = person.address;
        personEntity.base64 = updatedPerson.base64;
        persist(personEntity);
        return personConverter.ormToDto(personEntity);
    }

    @Transactional
    public void remove(Long id) {
        Person personEntity = findById(id);
        delete(personEntity);
    }
}
