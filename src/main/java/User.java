
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author litfr
 */
public class User {
    private String name;
    private String email;
    private boolean html, js, php;
    private static ArrayList<User> users = new ArrayList();
    
    public User(String name, String email, boolean html, boolean js, boolean php) throws UserException{
        if (name.length() == 0) throw new UserException(UserException.NO_NAME);
        if (email.length() == 0) throw new UserException(UserException.NO_EMAIL);
        this.name=name;
        this.email=email;
        this.html=html; this.js=js; this.php = php;
    }
    
    public static void add(User user){
        users.add(user);
    }
    
    public static void printAllUsers(){
        for (User u : users){
            System.out.println(u);
        }
    }
    
    @Override
    public String toString(){
        return "Name = "  + name + "; E-mail = " + email + "; Html = " + html + "; js = " + js
                + "; php = " + php;
    }
}
