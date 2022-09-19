package com.la.springboot.bean;

/**
 * @author LA
 * @date 2022-09-14-10:27
 */
public class Pet {
    private String name;
    private Double weight;

    public Pet() {
    }

    public Pet(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
