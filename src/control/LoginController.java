package control;

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
    File file = new File("C:\\Users\\JuliaNicolaGualeve\\Desktop\\ProjetoDesktop\\Users.txt");

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
        List<String> lista = readFile();
        for(String lst : lista){
            String[] sl = lst.split(";");
            if(sl[0].equals(user) && sl[2].equals(password))
                return true;
        }
        
        return false;
    }
    
    public List readFile(){
        List resultado = new ArrayList();
        String linha = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((linha = br.readLine()) != null ) {
                resultado.add(linha);
            }
            br.close();
        } catch (IOException erro) {
            System.err.println("Erro na leitura do arquivo. " + erro);
        } finally {
            return resultado;
        }
    }
        
}
