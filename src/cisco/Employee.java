package cisco;

import java.util.Date;

public final class Employee {
    private final String name;
    private final int age;
    private final Date dob;

    public Employee(String name, int age, Date dob) {
        this.name = name;
        this.age = age;
        this.dob = new Date(dob.getTime());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDob() {
        return new Date(dob.getTime());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
}
