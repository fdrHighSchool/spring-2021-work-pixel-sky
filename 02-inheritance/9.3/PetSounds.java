class Pet {
    private String name;
    private String type;

    public Pet(String n, String t) {
        this.name = n;
        this.type = t;
    }

    public String getType() {
        return this.type;
    }
    
    public String getName() {
        return this.name;
    }

    public void speak() {
        System.out.println("grr!");
    }
}

// Complete the Dog class
class Dog extends Pet{
    public Dog(String name) {
        super(name, "dog");
    }

    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

// Add a Cat class
class Cat extends Pet{
    public Cat(String name) {
        super(name, "cat");
    }

    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

public class PetSounds {
    public static void main(String[] args) {
        Pet p = new Pet("Sammy","hamster");
        System.out.println(p.getType());
        p.speak();

        Dog d = new Dog("Fido");
        System.out.println(d.getType());
        d.speak();
        Cat c = new Cat("Fluffy");
        System.out.println(c.getType());
        c.speak();
    }
}