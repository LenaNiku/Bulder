import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    //...
    protected int age = -1;
    protected String address = "";

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setAddress(address)
                .setSurname(surname);
    }

    public boolean hasAge() {
        return this.age != -1;
    }
    public boolean hasAddress() {
        return !this.address.isBlank();
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public OptionalInt getAge() {
        if (age != -1) {
            return OptionalInt.of(this.age);
        } else {
            return OptionalInt.empty();
        }
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    @Override
    public String toString() {
        //return String.format("%s %s %d", this.getName(), this.getSurname(), this.getAge());
        return getName() + " " + getSurname();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public void setAge(int age) {
        this.age = age;
    }

}