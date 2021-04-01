package br.com.mp.product.model;

public class PersonDTO {

    public Long id;

    public String name;

    public int sex;

    public int age;

    public String address;

    public String base64;

    public PersonDTO() {
        super();
    }

    public PersonDTO(Long id, String name, int sex, int age, String address, String base64) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.base64 = base64;
    }

}
