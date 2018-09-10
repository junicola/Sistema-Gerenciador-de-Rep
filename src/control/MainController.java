package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.User;
import view.AddUser;
import view.Main;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class MainController {

    File file = new File("C:\\Users\\JuliaNicolaGualeve\\Desktop\\UTFPR\\Semestre_5\\Desktop\\GerenciadorDeRep\\Users.txt");

    public ArrayList<User> getData() {
        return readFile();
    }

    public ArrayList<User> readFile() {
        ArrayList<User> usuarios = new ArrayList();
        String linha = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((linha = br.readLine()) != null) {
                if ((!"".equals(linha))) {
                    String[] str = linha.split(";");
                    User u = new User(str[0], str[1], str[2], str[3], str[4]);
                    usuarios.add(u);
                }
            }
            br.close();
        } catch (IOException erro) {
            System.err.println("Erro na leitura do arquivo. " + erro);
        } finally {
            return usuarios;
        }
    }

    public void removeUser(String email) {
        ArrayList<User> usuarios = getData();
        ArrayList<User> newUsuarios = new ArrayList();
        for (User u : usuarios) {
            if (!u.getEmail().equals(email)) {
                newUsuarios.add(u);
            }
        }
        try{
        //zera arquivo .txt
        BufferedWriter eb = new BufferedWriter(new FileWriter(file, false));
        eb.write("");
        eb.close();
        } catch(Exception e) {
            e.getMessage();
        }        
        
        AddUserController addUC = new AddUserController();
        for (User u : newUsuarios) {
            addUC.add(u);
        }

    }
    
    public void editUser(String email, Main main){
        ArrayList<User> usuarios = this.getData();
        for(User u : usuarios){
            if(u.getEmail().equals(email)){
                AddUser addUser = new AddUser(u.getEmail(), u.getName(), u.getPassword(), u.getRg(), u.getPhone(), main);
                addUser.setVisible(true);
            }
        }
        
        
    }

}
