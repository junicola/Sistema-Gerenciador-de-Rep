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
import model.Bill;
import model.User;
import view.AddBill;
import view.AddUser;
import view.Main;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class MainController {
    //DAO users

    File file = new File("C:\\Users\\JuliaNicolaGualeve\\Desktop\\ProjetoDesktop\\Users.txt");

    public ArrayList<User> getDataUsers() {
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
        ArrayList<User> usuarios = getDataUsers();
        ArrayList<User> newUsuarios = new ArrayList();
        for (User u : usuarios) {
            if (!u.getEmail().equals(email)) {
                newUsuarios.add(u);
            }
        }
        try {
            //zera arquivo .txt
            BufferedWriter eb = new BufferedWriter(new FileWriter(file, false));
            eb.write("");
            eb.close();
        } catch (Exception e) {
            e.getMessage();
        }

        AddUserController addUC = new AddUserController();
        for (User u : newUsuarios) {
            addUC.add(u);
        }

    }

    public void editUser(String email, Main main) {
        ArrayList<User> usuarios = this.getDataUsers();
        for (User u : usuarios) {
            if (u.getEmail().equals(email)) {
                AddUser addUser = new AddUser(u.getEmail(), u.getName(), u.getPassword(), u.getRg(), u.getPhone(), main);
                addUser.setVisible(true);
            }
        }
    }

    //DAO bill
    File fileBill = new File("C:\\Users\\JuliaNicolaGualeve\\Desktop\\ProjetoDesktop\\Bills.txt");

    public ArrayList<Bill> getDataBills() {
        return readFileBill();
    }

    public ArrayList<Bill> readFileBill() {
        ArrayList<Bill> contas = new ArrayList();
        String linha = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileBill));
            while ((linha = br.readLine()) != null) {
                if ((!"".equals(linha))) {
                    String[] str = linha.split(";");
                    Bill b = new Bill(str[0], str[1], str[2], str[3], str[4]);
                    contas.add(b);
                }
            }
            br.close();
        } catch (IOException erro) {
            System.err.println("Erro na leitura do arquivo. " + erro);
        } finally {
            return contas;
        }
    }

    public void removeBill(String name) {
        ArrayList<Bill> contas = getDataBills();
        ArrayList<Bill> newContas = new ArrayList();
        for (Bill b : contas) {
            if (!b.getName().equals(name)) {
                newContas.add(b);
            }
        }
        try {
            //zera arquivo .txt
            BufferedWriter eb = new BufferedWriter(new FileWriter(fileBill, false));
            eb.write("");
            eb.close();
        } catch (Exception e) {
            e.getMessage();
        }

        AddBillController addBC = new AddBillController();
        for (Bill b : newContas) {
            addBC.add(b);
        }

    }

    public void editBill(String name, Main main) {
        ArrayList<Bill> contas = this.getDataBills();
        for (Bill b : contas) {
            if (b.getName().equals(name)) {
                AddBill addBill = new AddBill(b.getName(), b.getValue(), b.getExpDate(), b.getUserName(), b.getStatus(), main);
                addBill.setVisible(true);
            }
        }
    }

}
