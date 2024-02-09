package objects;

import java.io.*;

public class Magister implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private double GPA;

    public Magister() {}

    public Magister(String name, int age, double GPA) {
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
        return "Магистр: имя - " + name() +
                ", возраст - " + age() +
                ", средний бал - " + GPA() + ".";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name());
        out.writeInt(age());
//        out.writeDouble(GPA());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        this.name = in.readUTF();
        this.age = in.readInt();
//        this.GPA = in.readDouble();
    }
}
