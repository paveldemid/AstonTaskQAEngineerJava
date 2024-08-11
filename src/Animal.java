import java.util.ArrayList;

public class Animal {

    //Переменная для подсчёта количества животных;
    private static int animalCounter = 0;

    public Animal() {
        //С каждым вызовом конструктора происходит подсчёт количества животных.
        animalCounter++;
    }

    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м.");
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }

}

class Cat extends Animal {

    private String type;
    private String name;

    //Переменная для хранения количества порций.
    private static int portion = 0;

    //Переменная-флвг для определения сытости кота.
    private boolean isHungry;

    //Переменная для подсчёта количества котов;
    private static int catCounter = 0;

    //Массив объектов
    static ArrayList<Cat> catList = new ArrayList<>();

    public Cat(String type, String name, boolean isHungry) {
        super();
        this.type = type;
        this.name = name;
        this.isHungry = isHungry;
        //С каждым вызовом конструктора происходит подсчёт количества созданных объектов.
        catCounter++;
    }
    //Переопределение методов класса Animal
    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(type + " " + name + " пробежал " + distance + " м.");
        } else {
            System.out.println(type + " " + name + " не может пробежать " + distance + " м. У него лапки");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(type + " " + name + " не умеет плавать");
    }

    //Метод для пополнения миски.
    public static void addMeal(int meal) {
        if (meal <= 0) {
            System.out.println("Вы ввели " + meal + " единиц еды. Коты будут голодать");
        } else {
            portion = meal;
        }
    }

    //Метод для кормления котов.
    public static void eat() {
        int meal = portion;

        if (meal <= 0) {
            System.out.println("Миска пустая. Добавьте в миску еды");
        } else {
            // Подсчет созданных котов.
            int catCounter = getCatCounter();
            // Если в миске меньше 10 единиц, никто не поест.

            if (meal < 10) {
                System.out.println("В миске " + meal + " единиц еды. Коты остались голодными.");
                for (Cat cat : Cat.catList) {
                    System.out.println(cat.getType() + " " + cat.getName() + " остался голодным.");
                }
            } else {
                // Количество котов, которые смогут поесть
                int catsFed = Math.min(catCounter, meal / 10);
                meal -= catsFed * 10; // Уменьшаем количество еды в миске

                // Кормим котов
                for (int i = 0; i < catsFed; i++) {
                    Cat cat = Cat.catList.get(i);
                    cat.setHungry(true); // Кот накормлен
                }

                // Выводим информацию о оставшейся еде
                if (meal > 0) {
                    System.out.println("В миске осталось " + meal + " единиц еды.");
                } else {
                    System.out.println("Миска пуста после кормления.");
                }

                // Выводим состояние голода всех котов
                for (Cat cat : Cat.catList) {
                    System.out.println(cat.getType() + " " + cat.getName() + " " + (cat.isHungry() ? "Поел" : "Голоден"));
                }
            }
        }
    }


    //Геттеры и сеттеры класса Cat.
    public static int getCatCounter() {
        return catCounter;
    }

    public String getType() {
        return type;
    }


    public String getName() {
        return name;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
}

class Dog extends Animal {
    private String type;
    private String name;

    //Переменная для подсчёта количества собак;
    private static int dogCounter = 0;

    public Dog(String type, String name) {
        super();
        this.type = type;
        this.name = name;
        //С каждым вызовом конструктора происходит подсчёт количества созданных объектов.
        dogCounter++;
    }

    //Переопределение методов класса Animal
    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(type + " " + name + " пробежал " + distance + " м.");
        } else {
            System.out.println(type + " " + name + " не может пробежать " + distance + " м. У него лапки");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 10) {
            System.out.println(type + " " + name + " проплыл " + distance + " м.");
        } else {
            System.out.println(type + " " + name + " не может проплыть " + distance + " м. Он устал");
        }
    }

    public static int getDogCounter() {
        return dogCounter;
    }
}