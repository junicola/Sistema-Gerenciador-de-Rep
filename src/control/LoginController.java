package control;

import DAO.UserDao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class LoginController {
    String password;
    String user;
    File file = new File("C:\\Users\\JuliaNicolaGualeve\\Desktop\\repClone\\Sistema-Gerenciador-de-Rep\\Users.bi");

    public LoginController(String password, String user) {
        this.password = password;
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }
    
    public boolean validate(){
        UserDao userDao = new UserDao();
        if(userDao.autenticLogin(user, password))
            return true;
        else
            return false;
    }
        
}
