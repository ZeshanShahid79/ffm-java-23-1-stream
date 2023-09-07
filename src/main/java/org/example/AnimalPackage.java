package org.example;

public class AnimalPackage {

    private Animal animal;

    public AnimalPackage(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "AnimalPackage{" +
                "animal=" + animal +
                '}';
    }
}
