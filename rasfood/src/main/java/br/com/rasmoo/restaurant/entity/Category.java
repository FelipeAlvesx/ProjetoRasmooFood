package br.com.rasmoo.restaurant.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.SplittableRandom;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    public Category(String name){
        this.name = name;
    }

    public Category(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
