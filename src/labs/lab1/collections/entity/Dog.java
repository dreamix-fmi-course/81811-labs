package labs.lab1.collections.entity;

public class Dog implements Comparable<Dog> {
    private String breed;
    private int age;
    private int weight;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String breed, int weight, int age) {
        this.breed = breed;
        this.weight = weight;
        this.age = age;
    }

    @Override
    public int compareTo(Dog dog) {
        return breed.compareTo(dog.breed) + weight - dog.weight + age - dog.age;
    }

    @Override
    public String toString() {
        return "Dog{" +
               "breed='" + breed + '\'' +
               ", age=" + age +
               ", weight=" + weight +
               '}';
    }
}
