// Task 1: Figure Interface and Classes
public interface Figure {
    double getPerimeter();
    double getArea();
}

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Parallelogram implements Figure {
    private double base;
    private double height;
    private double side;

    public Parallelogram(double base, double height, double side) {
        this.base = base;
        this.height = height;
        this.side = side;
    }

    @Override
    public double getPerimeter() {
        return 2 * (base + side);
    }

    @Override
    public double getArea() {
        return base * height;
    }
}

public class Rectangle implements Figure {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

// Task 2: Moveable Interface and Animal Class
public interface Moveable {
    void start();
    void stop();
}

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String getType();

    public String getName() {
        return name;
    }
}

public class Cat extends Animal implements Moveable {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Cat";
    }

    @Override
    public void start() {
        System.out.println(name + " started moving.");
    }

    @Override
    public void stop() {
        System.out.println(name + " stopped moving.");
    }
}

// Task 3: Person, Employee, and Manager Classes
import java.time.Year;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected int birthdayYear;

    public Person(String firstName, String lastName, int birthdayYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayYear = birthdayYear;
    }

    public int getAge() {
        return Year.now().getValue() - birthdayYear;
    }
}

public class Employee extends Person {
    private int hireDate;
    private String companyName;
    private double salary;

    public Employee(String firstName, String lastName, int birthdayYear, int hireDate, String companyName, double salary) {
        super(firstName, lastName, birthdayYear);
        this.hireDate = hireDate;
        this.companyName = companyName;
        this.salary = salary;
    }

    public int getJobSeniority() {
        return Year.now().getValue() - hireDate;
    }

    public double getSalary() {
        return salary;
    }
}

public final class Manager extends Employee {
    private double bonus;

    public Manager(String firstName, String lastName, int birthdayYear, int hireDate, String companyName, double salary, double bonus) {
        super(firstName, lastName, birthdayYear, hireDate, companyName, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + firstName + ' ' + lastName + '\'' +
                ", age=" + getAge() +
                ", jobSeniority=" + getJobSeniority() +
                ", company='" + companyName + '\'' +
                ", salary=" + getSalary() +
                ", bonus=" + bonus +
                '}';
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        // Task 1: Test Figure interface and its implementations
        Figure circle = new Circle(5);
        Figure parallelogram = new Parallelogram(4, 3, 5);
        Figure rectangle = new Rectangle(4, 5);

        System.out.println("Circle perimeter: " + circle.getPerimeter());
        System.out.println("Circle area: " + circle.getArea());

        System.out.println("Parallelogram perimeter: " + parallelogram.getPerimeter());
        System.out.println("Parallelogram area: " + parallelogram.getArea());

        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());
        System.out.println("Rectangle area: " + rectangle.getArea());

        // Task 2: Test Moveable interface and Animal class
        Cat cat = new Cat("Whiskers");
        System.out.println("Animal type: " + cat.getType());
        System.out.println("Animal name: " + cat.getName());
        cat.start();
        cat.stop();

        // Task 3: Test Person, Employee, and Manager classes
        Manager manager = new Manager("John", "Doe", 1980, 2005, "TechCorp", 75000, 15000);
        System.out.println(manager);
    }
}