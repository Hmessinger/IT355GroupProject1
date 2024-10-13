package Recommendations;

public class OBJ51 {
    private String username; // Private field
    private String password; // Private field

    public OBJ51(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getOBJ51() {
        return username; // Public getter for username
    }

    public boolean authenticate(String inputPassword) {
        return password.equals(inputPassword); // Controlled access to password
    }
}
