package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class LoginController {
    String password;
    String user;
    File file = new File("C:\\Users\\JuliaNicolaGualeve\\Desktop\\UTFPR\\Semestre_5\\Desktop\\GerenciadorDeRep\\Users.txt");

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
        String str = readFile();
        if(str.contains(password) && str.contains(user))
            return true;
        else
            return false;
            
    }
    
    public String readFile(){
        StringBuilder str = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (br.ready()) {
                str.append(br.readLine()).append("\n");
            }
            br.close();
        } catch (IOException erro) {
            System.err.println("Erro na leitura do arquivo. " + erro);
        } finally {
            return str.toString();
        }
    }
        
}
