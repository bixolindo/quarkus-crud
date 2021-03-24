package br.com.mp.product.repository;

import br.com.mp.product.model.Person;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person>{
    public List<Person> list() {
        return listAll();
    }

    @Transactional
    public Person save(Person person){
        persist(person);
        return person;
    }

    @Transactional
    public Person update(Long id, Person person){
        Person personEntity = findById(id);

        personEntity.name = person.name;
        personEntity.sex = person.sex;
        personEntity.age = person.age;
        personEntity.address = person.address;
        persist(personEntity);
        return personEntity;
    }

    @Transactional
    public void remove(Long id) {
        Person personEntity = findById(id);

        delete(personEntity);
    }
}
