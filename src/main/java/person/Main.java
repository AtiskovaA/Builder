package person;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Диана")
                .setSurname("Ронд")
                .setAge(27)
                .setAddress("Лондон")
                .build();
        Person daughter = mom.newChildBuilder()
                .setName("Арина")
                .build();
        System.out.println("У " + mom + " есть дочь, " + daughter);

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
