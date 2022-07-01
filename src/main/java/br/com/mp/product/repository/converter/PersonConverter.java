package br.com.mp.product.repository.converter;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.mp.product.model.Person;
import br.com.mp.product.model.PersonDTO;

@ApplicationScoped
public class PersonConverter {

	public PersonDTO ormToDto(Person person) {
		String decoded = null;
		if (person.base64 != null) {
			decoded = new String(Base64.getDecoder().decode(person.base64));
		}

		return new PersonDTO(person.namepais, person.rg, person.type, person.password, person.id, person.name,
				person.address, decoded);
	}

	public Person dtoToOrm(PersonDTO personDTO) {
		byte[] base64Byte = null;
		if (personDTO.base64 != null) {
			base64Byte = Base64.getEncoder().encode(personDTO.base64.getBytes());
		}

		Person newPerson = new Person();

		newPerson.namepais = personDTO.namepais;
		newPerson.password = personDTO.password;
		newPerson.address = personDTO.address;
		newPerson.rg = personDTO.rg;
		newPerson.type = personDTO.type;
		newPerson.name = personDTO.name;
		newPerson.base64 = base64Byte;
		return newPerson;
	}

	public List<PersonDTO> ormListToDtoList(List<Person> ormList) {
		List<PersonDTO> dtos = new ArrayList<PersonDTO>();
		if (ormList != null) {
			ormList.stream().forEach(orm -> dtos.add(ormToDto(orm)));
			return dtos;
		}
		return dtos;
	}

}
