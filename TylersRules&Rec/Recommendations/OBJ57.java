package Recommendations;

public class OBJ57 {
    public final class Base{
        public void performAction(){
            System.out.println("Base action");
        }
    }

    public class Application{
        public void execute(Base obj){
            obj.performAction(); //More safe because base cannot be overriden
        }
    }
}
