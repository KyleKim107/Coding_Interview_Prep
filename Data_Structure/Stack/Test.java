package Data_Structure.Stack;
class Pet {
    String name;
    int age;
    public Pet(){

    }
    Pet(String name, int age){
    this.name = name;
    this.age = age; }
    }

public class Test extends Pet {
    public void speak(){
         System.out.println("왈왈");
    }
}