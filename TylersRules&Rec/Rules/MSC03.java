package Rules;

public class MSC03 {
    //Load sensitive info from evironment variables
    private String dbPassword = System.getenv("DB_PASSWORD");

    public void connectToDatabase(){
        if(dbPassword == null){
            throw new IllegalStateException("Database password is not set.");
        }
        //Proceed with database connection
    }
}
