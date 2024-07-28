public class Person {
    private String FIO;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Person(String FIO, String position, String email, String phoneNumber, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    //Метод для вывода информации об объекте.
    public void info() {
        System.out.println("ФИО: " + FIO + "\n" +
                "Должность: " + position + "\n" +
                "email: " + email + "\n" +
                "Номер телефона: " + phoneNumber + "\n" +
                "Зарплата: " + salary + "\n" +
                "Возраст: " + age + "\n");
    }

    public static void main(String[] args) {

        //Массив объектов.
        Person[] personArray = new Person[5];

        //Задание ячейки массива объектами.
        personArray[0] = new Person("Petrenko Nikolaj Sergeevich", "Engineer", "john.doe@example.com", "+375293452867", 3000, 27);
        personArray[1] = new Person("Sidorov Sergej Vladimirovich", "Manager", "example1@gmail.com", "+3751245678", 2700, 25);
        personArray[2] = new Person("Malchev Nikolaj Valerevich", "QA Engineer", "emily.smith123@yahoo.com", "+3752358990", 2900, 29);
        personArray[3] = new Person("Dichenko Artur Pavlovich", "Engineer", "alexander_ivanov@hotmail.com", "+3754567894", 3000, 31);
        personArray[4] = new Person("Filchenko Vladislav Yurevich", "QA Engineer", "sarah.jones2022@outlook.com", "+3753458712", 3100, 30);

        //Вывод информации
        for (Person person : personArray) {
            person.info();
        }
    }
}
