package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.User;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class AddUserController {
    File file = new File("C:\\Users\\JuliaNicolaGualeve\\Desktop\\UTFPR\\Semestre_5\\Desktop\\GerenciadorDeRep\\Users.txt");
    String str;

    public boolean add(User u) {
        str = "\r\n";
        str += u.getEmail() + ";" + u.getName() + ";" + u.getPassword() + ";" + u.getRg() + ";" + u.getPhone();

        if (writeText(file, str)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean writeText(File file, String str) {
        try {
            BufferedWriter eb = new BufferedWriter(new FileWriter(file, true));
            eb.write(str);
            eb.close();
            return true;
        } catch (IOException erro) {
            System.err.println("Erro no cadastro do usuário" + erro);
            return false;
        }
    }
}

