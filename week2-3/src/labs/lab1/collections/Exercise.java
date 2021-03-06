package labs.lab1.collections;

import labs.lab1.collections.entity.Dog;
import labs.lab1.collections.entity.Leg;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise {
    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();

        elements.add("first");
        elements.add(0, "second");
        elements.add("third");
        elements.forEach(System.out::println);

        System.out.println(elements.get(0));
        System.out.println(elements.get(1));

        elements.remove(2);

        Collections.sort(elements);

        List<Dog> dogs = new ArrayList<>();
        Dog dog1 = new Dog("breed1", 10, 5);
        Dog dog2 = new Dog("breed2", 6, 4);
        Dog dog3 = new Dog("breed3", 11, 9);
        Dog dog4 = new Dog("breed1", 3, 10);

        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);

        /*Collections.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog d1, Dog d2) {
                return Integer.compare(d1.getWeight(), d2.getWeight());
            }
        });
        System.out.println(dogs);*/

        Collections.sort(dogs, (d1, d2) -> Integer.compare(d1.getWeight(), d2.getWeight()));
        System.out.println(dogs);

        Collections.sort(dogs, Comparator.comparingInt(Dog::getWeight).thenComparing(Dog::getAge));
        System.out.println(dogs);

        Collections.sort(dogs);
        System.out.println(dogs);

        dogs.remove(1);
        dogs.add(1, new Dog("new breed", 11, 3));
        dogs.forEach(System.out::println);

        Map<String, Integer> map = new HashMap<>();
        map.put("entry1", 1);
        map.put("entry2", 2);

        int count = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            count++;
        }
        System.out.println("The number of key-value mappings is: " + count);

        long count1 = map.entrySet().stream().count();
        System.out.println("The number of key-value mappings is: " + count1);

        System.out.println("The number of key-value mappings is: " + map.size());

        // T7) Write the following structure against aircraft tail number associate
        // list of leg information (fromAirport, toAirport, date).
        // Fill test information
        // Extract legs inside list/set that have from/to airport for a specific airport
        // (Example: All legs for airport LBSF)

        List<Leg> legs = List.of(
            new Leg("Sofia", "Varna", LocalDate.of(2019, 1, 1)),
            new Leg("New York", "Miami", LocalDate.of(2022, 1, 1)),
            new Leg("Prague", "Sofia", LocalDate.of(2015, 3, 3)),
            new Leg("Rome", "Athens", LocalDate.now()));

        List<Leg> sofiaLegs = legs.stream()
            .filter(leg -> leg.getFromAirport().equals("Sofia") || leg.getToAirport().equals("Sofia"))
            .collect(Collectors.toList());

        System.out.println(sofiaLegs);
    }
}
