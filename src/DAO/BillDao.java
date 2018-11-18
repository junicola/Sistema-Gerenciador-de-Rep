package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Bill;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class BillDao {
    // dados para acesso ao banco

    final String USUARIO = "root";
    final String SENHA = "root123";
    final String URL_BANCO = "jdbc:mysql://localhost:3306/gerencilar";

    // constantes de acesso
    final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";

    // comandos
    final String INSERIR = "INSERT INTO Bill(bill_name, bill_exp_date, bill_status, bill_value) VALUES(?, ?, ?, ?)";
    final String ATUALIZAR = "UPDATE Bill SET bill_name=?, bill_exp_date=?, bill_status=?, bill_value=?  WHERE bill_id = ?";
    final String BUSCAR = "SELECT bill_id, bill_name, bill_exp_date, bill_status, bill_value  FROM Bill WHERE bill_name = ?";
    final String BUSCAR_TODOS = "SELECT bill_id, bill_name, bill_exp_date, bill_status, bill_value FROM Bill";
    final String APAGAR = "DELETE FROM Bill WHERE bill_name = ?";
    final String BUSCAR_MAX_ID = "SELECT max(bill_id) from Bill";
    final String FORMATO_DATA = "yyyy/MM/dd";
    final SimpleDateFormat FORMATADOR = new SimpleDateFormat(FORMATO_DATA);

    public void save(Bill bill) {
        try {
            Connection con = connection();
            PreparedStatement salvar = con.prepareStatement(INSERIR);
            String dateStr = FORMATADOR.format(bill.getExpDate());
            salvar.setString(1, bill.getName());
            salvar.setString(2, dateStr);
            salvar.setInt(3, bill.getStatus());
            salvar.setFloat(4, bill.getValue());
            salvar.executeUpdate();
            salvar.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR SALVANDO CONTA");
            System.exit(0);
        }
    }

    public void edit(Bill bill) {
        try {
            Connection con = connection();
            PreparedStatement atualizar = con.prepareStatement(ATUALIZAR);
            atualizar.setString(1, bill.getName());
            atualizar.setString(2, (FORMATADOR.format(bill.getExpDate())));
            atualizar.setInt(3, bill.getStatus());
            atualizar.setFloat(4, bill.getValue());
            atualizar.setInt(5, bill.getId());
            atualizar.executeUpdate();
            atualizar.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR ATUALIZANDO CONTA COM ID " + bill.getId());
            System.exit(0);
        }

    }

    public void remove(String name) {
        try {
            Connection con = connection();
            PreparedStatement apagar = con.prepareStatement(APAGAR);
            apagar.setString(1, name);
            apagar.executeUpdate();
            apagar.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR APAGANDO CONTA: " + name);
            System.exit(0);
        }
    }

    public List<Bill> searchAll() {
        List<Bill> bills = new ArrayList<>();
        try {
            Connection con = connection();
            PreparedStatement buscarTodos = con.prepareStatement(BUSCAR_TODOS);
            ResultSet resultadoBusca = buscarTodos.executeQuery();
            while (resultadoBusca.next()) {
                Bill bill = extractsBill(resultadoBusca);
                bills.add(bill);
            }
            buscarTodos.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO TODAS AS CONTAS.");
            System.exit(0);
        }
        return bills;
    }

    public Bill searchByName(String name) {
        Bill bill = new Bill();
        try {
            Connection con = connection();
            PreparedStatement buscarPorNome = con.prepareStatement(BUSCAR);
            buscarPorNome.setString(1, name);
            ResultSet resultadoBusca = buscarPorNome.executeQuery();
            while(resultadoBusca.next())
                bill = extractsBill(resultadoBusca);
            buscarPorNome.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO TODAS AS CONTAS.");
            System.exit(0);
        }
        return bill;
    }

    public int searchById() {
        int id = 0;
        try {
            Connection con = connection();
            PreparedStatement buscarPorId = con.prepareStatement(BUSCAR_MAX_ID);
            ResultSet resultadoBusca = buscarPorId.executeQuery();
            while (resultadoBusca.next()) {
                id = resultadoBusca.getInt(1);
            }
            buscarPorId.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO TODAS AS CONTAS." + e);
            System.exit(0);
        }
        return id;
    }

    private Bill extractsBill(ResultSet resultadoBusca) throws SQLException, NumberFormatException {
        Bill bill = new Bill();
        bill.setId(resultadoBusca.getInt(1));
        bill.setName(resultadoBusca.getString(2));
        bill.setExpDate(resultadoBusca.getDate(3));
        bill.setStatus(resultadoBusca.getInt(4));
        bill.setValue(resultadoBusca.getFloat(5));

        return bill;
    }

    private Connection connection() {
        try {
            Class.forName(CLASSE_DRIVER);
            return DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof ClassNotFoundException) {
                System.err.println("VERIFIQUE SE O DRIVER DO BANCO DE DADOS ESTÁ NO CLASSPATH");
            } else {
                System.err.println("VERIFIQUE SE O BANCO ESTÁ RODANDO E SE OS DADOS DE CONEXÃO ESTÃO CORRETOS");
            }

            System.exit(0);
            // o sistema deverá sair antes de chegar aqui...
            return null;
        }
    }

}
