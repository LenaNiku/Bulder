public class Main {

    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Anna")
                .setSurname("Wolf")
                .setAge(31)
                .setAddress("Sidney")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Anton")
                .build();
        System.out.println(mom + " has one son, " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
