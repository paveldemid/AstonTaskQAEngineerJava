public class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    // Метод для вывода названия парка.
    public void ParkInfo() {
        System.out.println("Название парка: " + name);
    }


    //Внутренний класс
    private class Attraction {
        private String name;
        private String workingHours;
        private double cost;


        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }


        // Метод для вывода информации об аттракционе
        public void AttractionInfo() {
            System.out.println("Название: " + name + ", Время работы: " + workingHours + ", Стоимость: " + cost + " рублей");
        }

    }

    public static void main(String[] args) {

        Park park = new Park("Парк Победы");
        Park.Attraction[] attractionArray = new Park.Attraction[5];

        // Создание аттракционов и добавление их в массив
        attractionArray[0] = park.new Attraction("Пираты Карибского моря", "10:00 - 18:00", 10.0);
        attractionArray[1] = park.new Attraction("Чёртово колесо", "11:00 - 19:00", 15.0);
        attractionArray[2] = park.new Attraction("Пандора", "09:00 - 17:00", 12.0);
        attractionArray[3] = park.new Attraction("Astro Orbiter", "10:30 - 18:30", 8.0);
        attractionArray[4] = park.new Attraction("Autopia", "09:30 - 17:30", 20.0);


        // Вывод название парка.
        park.ParkInfo();

        // Вывод информацию о каждом аттракционе
        for (Park.Attraction attraction : attractionArray) {
            attraction.AttractionInfo();
        }
    }
}
