import java.util.*;

interface Payable {
    double getPaymentAmount();
}

abstract class Person implements Payable, Comparable<Person> {
    protected static int count = 0;
    protected int id;
    protected String name;
    protected String surname;

    public Person() {
        this.id = ++count;
    }

    public Person(String name, String surname) {
        this();
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname;
    }

    public abstract String getPosition();

    @Override
    public int compareTo(Person p) {
        return Double.compare(this.getPaymentAmount(), p.getPaymentAmount());
    }
}

class Employee extends Person {
    private String position;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(String name, String surname, String position, double salary) {
        super(name, surname);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee: " + super.toString();
    }

    @Override
    public double getPaymentAmount() {
        return salary;
    }
}

class Student extends Person {
    private double gpa;

    public Student() {
        super();
    }

    public Student(String name, String surname, double gpa) {
        super(name, surname);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

    @Override
    public String getPosition() {
        return "Student";
    }

    @Override
    public double getPaymentAmount() {
        return gpa > 2.67 ? 36660.00 : 0.0;
    }
}

public class Main {
    public static void printData(Iterable<Person> persons) {
        for (Person p : persons) {
            System.out.println(p + " earns " + p.getPaymentAmount() + " tenge");
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Employee("John", "Lennon", "Manager", 27045.78));
        persons.add(new Employee("George", "Harrison", "Developer", 50000.00));
        persons.add(new Student("Ringo", "Starr", 2.5));
        persons.add(new Student("Paul", "McCartney", 3.0));

        Collections.sort(persons);
        printData(persons);
    }
}
