
public class Main {
    public static void main(String[] args) {

        //Задание 1.
        System.out.println("Задание 1");
        Collections collections = new Collections();
        collections.list();

        //Задание 2.
        System.out.println("Задание 2");
        PhoneNumberGuide user = new PhoneNumberGuide();
        user.add("Васильков", "+375293456787");
        user.add("Кульков", "+375334567890");
        user.add("Петров", "+375445678723");
        user.add("Петров", "+375294568712");
        user.get("Куликов");
        user.get("Петров");
        user.add("Куликов", "+375293456789");
        user.get("Куликов");

    }
}