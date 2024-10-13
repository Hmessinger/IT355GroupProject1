package Rules;

public class OBJ01 {
    private String name; //Restricted access using private 
    private int age; //Restricted access 

    public String getName(){
        return name; //Access through method
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
