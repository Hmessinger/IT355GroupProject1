package Rules;

public class MET03 {

    // Private method performing a security check
    private void performSecurityCheck() {
        // Security logic here
        if (!isUserAuthenticated()) {
         throw new SecurityException("User is not authenticated");
            }
        }
    
        // Public method that calls the private security method
    public void executeAction() {
            performSecurityCheck();
            // Action logic here...
        }
        
    private boolean isUserAuthenticated() {
        // Check authentication logic
        return true; // Example
        }
    }
