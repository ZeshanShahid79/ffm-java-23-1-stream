package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {


        List<Animal> animals = new ArrayList<>();
        animals.add(new Crab());
        animals.add(new JellyFish());
        animals.add(new Crab());
        animals.add(new Fish());
        animals.add(new Crab());
        animals.add(new Crab());
        animals.add(new JellyFish());
        animals.add(new JellyFish());
        animals.add(new Fish());
        animals.add(new Crab());
        animals.add(new Crab());
        animals.add(new Fish());

        System.out.println(animals);
        //imperativer Ansatz

        List<Animal> onlyFish = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getName().equals("fish")) {
                onlyFish.add(animal);
            }
        }
        System.out.println(onlyFish);

        // deklarativer Ansatz

        animals.stream()
                .filter(animal -> animal.getName().equals("fish"))
                .limit(2)
                .forEach(animal -> System.out.println(animal));

        List<AnimalPackage> crabInPackage = animals.stream()
                .filter(animal -> animal.getName().equals("crab"))
                .map(crab -> new AnimalPackage(crab))
                .collect(Collectors.toList());

        System.out.println(crabInPackage);


        Stream.of("Anton", "Berta", "Cäsar")
                .peek(name -> System.out.println(name))
                .forEach(name -> {
                });




        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5, 7, 6, 3, 2, 7, 8, 9);

        // Schritt 1 gerade Zahlen
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        System.out.println("---------------------------------------");


        // Schritt 2 verdopple jede zahl
        numbers.stream()
                .map(number ->  number * 2)
                .forEach(System.out::println);
        System.out.println("---------------------------------------");


        // Schritt 3 sort by order

        numbers.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("---------------------------------------");
        // Schritt 4 Summer aller Elemente

        Optional number = numbers.stream()
                .reduce((a,b) -> a+b);
        System.out.println(number.get());
        System.out.println("---------------------------------------");

        // Schritt 5
        numbers.stream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println("---------------------------------------");

        // Schritt 6
        List<Integer> noDoubles = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(noDoubles);
        System.out.println("---------------------------------------");








//        Mathe addieren = (int a, int b) -> a + b;
//        System.out.println(addieren.someFunction(6,5));
    }

}