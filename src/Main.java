import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Задание 1.
        System.out.println("Задание 1");

        Cat.catList.add(new Cat("Кот", "Вася", false));
        Cat.catList.add(new Cat("Кот", "Мурзик", false));
        Cat.catList.add(new Cat("Кот","Маузер",false));
        Cat.catList.add(new Cat("Кот","Кузя",false));
        Cat.catList.add(new Cat("Кот","Мартин",false));

        //Вызов методов run() и swim() для объектов массива.
        Cat.catList.get(0).run(100);
        Cat.catList.get(0).swim(123);
        Cat.catList.get(1).run(202);
        Cat.catList.get(1).swim(23);
        Cat.catList.get(2).run(2);
        Cat.catList.get(2).swim(5);
        Cat.catList.get(3).run(3);
        Cat.catList.get(3).swim(34);
        Cat.catList.get(4).run(1456);
        Cat.catList.get(4).swim(467);
        System.out.println("");


        System.out.println("Покормите котов. Пополните миску. Один кот-10 единиц еды: ");
        int meal = scanner.nextInt();
        Cat.addMeal(meal);
        //Вызов метода для кормления котов.
        Cat.eat();
        System.out.println("");

        //Создание объектов класса Dog
        Dog dog1 = new Dog("Пёс", "Шарик");
        Dog dog2=new Dog("Пес","Альма");

        dog1.run(500);
        dog1.swim(11);
        dog2.run(1000);
        dog2.swim(456);
        System.out.println(" ");

        System.out.println("Общее количество животных: " + Animal.getAnimalCounter());
        System.out.println("Общее количество котов: " + Cat.getCatCounter());
        System.out.println("Общее количество собак: " + Dog.getDogCounter());


        //Задание 2.
        System.out.println("Задание 2");

        Circle circle = new Circle("Круг", "Фиолетовый", "Серый", 7);
        circle.displayInfo();

        Rectangle rectangle = new Rectangle("Прямоугольник", "Синий", "Пурпурный", 5, 10);
        rectangle.displayInfo();

        Triangle triangle = new Triangle("Треугольник", "Зеленый", "Красный", 4, 6, 4);
        triangle.displayInfo();

    }
}