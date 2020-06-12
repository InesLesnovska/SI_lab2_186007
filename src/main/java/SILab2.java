import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<String> allUsers) {
        if (user==null) { //A
            throw new RuntimeException("The user argument is not initialized!"); //B
        }
        else { //C
            if (user.getUsername()==null || allUsers.contains(user.getUsername())) { //C
                throw new RuntimeException("User already exists!"); //D
            }
            else { //E
                if (user.getEmail()==null) //E
                    return false; //F
                boolean atChar = false, dotChar = false; //G
                for (int i=0;i<user.getEmail().length();i++) { //H
                    if (user.getEmail().charAt(i)=='@') //I
                        atChar = true; //J
                    if (atChar && user.getEmail().charAt(i)=='.') { //K
                        dotChar = true; //L
                    }
                }
                if (!atChar || !dotChar) { //M
                    return false; //N
                }
            }
        }
        return true; //O
    }//P
}