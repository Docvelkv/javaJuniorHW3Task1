package objects;

import java.io.Serial;
import java.io.Serializable;

public final class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient double GPA;

    public Student(){}
    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public double GPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Студент: имя - " + name() +
                ", возраст - " + age() +
                ", средний бал - " + GPA() + ".";
    }
}
