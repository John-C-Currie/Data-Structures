public class Camel {

    private int age;
    private String name;
    
    public Camel(int age, String name) {
        this.age = age;
        System.out.println("A new Camel has been created!");
    }

    public void sayName() {
        System.out.println("My name is " + this.getName());
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }




}
