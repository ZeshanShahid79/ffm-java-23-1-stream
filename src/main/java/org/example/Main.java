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



        // 1 Recherche ...
        // 2 Recherche TerminalOperation fehlt
        // 3 Recherche
        //Declarative Code: Mit Streams können Sie Ihre Absicht klar und deklarativ ausdrücken, was den Code oft leserlicher und verständlicher macht. Sie beschreiben, was Sie tun möchten (z. B. Filtern, Mapen oder Reduzieren), anstatt wie Sie es tun möchten (z. B. durch das Schreiben von Schleifen).
        //Kompakt und Ausdrucksstark: Stream-Operationen sind oft kürzer und ausdrucksstärker als gleichwertige Schleifen. Dies kann den Code reduzieren und die Fehleranfälligkeit verringern.
        //Parallelisierung: Streams bieten integrierte Unterstützung für Parallelverarbeitung. Sie können mit geringem Aufwand parallelisiert werden, um die Leistung auf Mehrkernprozessoren zu verbessern. In Schleifen müssten Sie die Parallelisierung selbst implementieren.
        //Reusability und Pipelining: Sie können Stream-Operationen wiederverwenden und zu komplexen Pipelines zusammenstellen. Dies erleichtert die Wartung und ermöglicht es, die Operationen klar zu trennen.
        //Lazy Evaluation: Streams führen Operationen nur aus, wenn tatsächlich ein Ergebnis angefordert wird. Dies ermöglicht die Optimierung und Vermeidung unnötiger Berechnungen.
        //Funktionale Programmierung: Streams unterstützen einen funktionalen Programmierstil, der die Verarbeitung von Daten in kleinen, unabhängigen Schritten fördert. Dies führt oft zu besser wartbarem und testbarem Code.
        //Reduzierte Mutabilität: Streams ermutigen dazu, unveränderliche Datenstrukturen zu verwenden und mutierbaren Code zu vermeiden. Dies kann dazu beitragen, Seiteneffekte und unerwünschte Veränderungen des Programmzustands zu reduzieren.
        //API mit hoher Abstraktion: Die Stream-API bietet viele eingebaute Funktionen, die häufig verwendete Operationen wie Filtern, Sortieren und Reduzieren vereinfachen. Dies erspart Ihnen die Implementierung dieser Operationen von Grund auf.
        //Bessere Fehlererkennung: In Streams werden Fehler in der Regel während der Pipeline-Ausführung erkannt und behandelt. In Schleifen sind Fehler möglicherweise schwieriger zu finden und zu isolieren.
        //Dennoch gibt es Situationen, in denen Schleifen immer noch sinnvoll und notwendig sind, insbesondere wenn Sie auf spezifische Indizes oder komplexe Kontrollstrukturen zugreifen müssen. Streams sind ein nützliches Tool in Ihrer Java-Toolbox, aber sie sind nicht immer die beste Wahl für jede Aufgabe. Die Wahl zwischen Schleifen und Streams hängt oft von den Anforderungen und der Lesbarkeit des Codes ab.


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