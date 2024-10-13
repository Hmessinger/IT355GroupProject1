package Rules;

public class ENV02 {
    public void loadConfig(){
        String dbPassword = System.getenv("DB_PASSWORD");
        if(dbPassword == null || dbPassword.isEmpty()){
            throw new IllegalArgumentException("Invalid DB_PASSWORD");
        }
        //Safely use dbPassword after validation
    }
}
