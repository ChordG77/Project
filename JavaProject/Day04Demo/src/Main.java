import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Test, Double> maps = new TreeMap<>();
        Test n1 = new Test("pig", 25, 100.0);
        Test n2 = new Test("pig", 25, 200.0);
        maps.put(n1, 1.0);
        maps.put(n2, 2.0);
        maps.put(new Test("pig", 26, 100.0), 2.0);
        maps.put(new Test("pig", 26, 100.0), 2.0);
        maps.forEach((k, v) -> System.out.println(k.getName() + " " + k.getAge() + " " + k.getWeight() + " " + v));
        TreeSet<Test> set = new TreeSet<>();
        set.add(n1);
        set.add(n2);
        set.add(new Test("pig", 26, 100.0));
        set.forEach(System.out::println);
    }
}

class Test implements Comparable<Test>{
    private String name;
    private int age;
    private double weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return age == test.age && Double.compare(weight, test.weight) == 0 && Objects.equals(name, test.name);
    }

    @Override
    public int compareTo(Test o) {
        return this.getAge()- o.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight);
    }
}