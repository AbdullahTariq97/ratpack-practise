package my.app.http;

public class Car {
    private String name;
    private String year;

    public Car(String name, String year){
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }
}
