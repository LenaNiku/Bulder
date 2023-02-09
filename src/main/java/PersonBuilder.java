public class PersonBuilder {
    protected String name;
    protected String surname;

    protected int age = -1;
    protected String address = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException(
                    "Age is not valid"
            );
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = (address);
        return this;
    }

    public Person build() {

        if (name == null) {
            throw new IllegalStateException("Name must be provided.");
        }
        if (surname == null) {
            throw new IllegalStateException("Surname must be provided.");
        }

        Person person;
        if (age != -1 ) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }

        if (address != null) {
            person.setAddress(address);
        }

        return person;
    }
}