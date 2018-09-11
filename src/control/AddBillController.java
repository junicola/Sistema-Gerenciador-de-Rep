package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.Bill;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class AddBillController {

    File file = new File("C:\\Users\\JuliaNicolaGualeve\\Desktop\\ProjetoDesktop\\Bills.txt");
    String str;

    public boolean add(Bill b) {
        str = "\r\n";
        str += b.getName() + ";" + b.getValue() + ";" + b.getExpDate() + ";" + b.getUserName() + ";" + b.getStatus();

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

