package ua.com.hav.model;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;


public class Pet {


    private int id;


    @Size(min = 3, max = 7)
    private String name;

    @Range(min = 0, max = 22)
    private int age;

    public Pet() {
    }

    public Pet(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
