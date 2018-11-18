package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PayBill;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class PayBillDao {

    final String USUARIO = "root";
    final String SENHA = "root123";
    final String URL_BANCO = "jdbc:mysql://localhost:3306/gerencilar";

    // constantes de acesso
    final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";

    // comandos
    final String INSERIR = "INSERT INTO user_has_Bill(user_id, bill_id, user_has_bill_status) VALUES(?, ?, ?)";
    final String BUSCAR_TODOS = "select u.user_name, c.bill_name, user_has_bill_status from user_has_bill d, user u, bill c where d.user_id = u.user_id and d.bill_id = c.bill_id";
    final String APAGAR = "DELETE FROM user_has_bill WHERE bill_id = ?";
    final String ATUALIZAR = "UPDATE user_has_bill set user_id = ? where bill_id = ?";
    final String BUSCAR_ID = "SELECT * from user_has_bill where bill_id = ?";
    
    public void save(PayBill pb) {
        try {
            Connection con = connection();
            PreparedStatement salvar = con.prepareStatement(INSERIR);
            salvar.setInt(1, pb.getIdUser());
            salvar.setInt(2, pb.getIdBill());
            salvar.setInt(3, pb.getStatus());
            salvar.executeUpdate();
            salvar.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR SALVANDO CONTA");
            System.exit(0);
        }
    }

    public List<PayBill> search() {
        List<PayBill> pbs = new ArrayList<>();
        try {
            Connection con = connection();
            PreparedStatement buscarTodos = con.prepareStatement(BUSCAR_TODOS);
            ResultSet resultadoBusca = buscarTodos.executeQuery();
            while (resultadoBusca.next()) {
                PayBill pb = extractsBill(resultadoBusca);
                pbs.add(pb);
            }
            buscarTodos.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO TODAS AS CONTAS.");
            System.exit(0);
        }
        return pbs;
    }

    public void edit(PayBill pb) {
        try {
            Connection con = connection();
            PreparedStatement atualizar = con.prepareStatement(ATUALIZAR);
            atualizar.setInt(1, pb.getIdUser());
            atualizar.setInt(2, pb.getIdBill());
            atualizar.executeUpdate();
            atualizar.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR ATUALIZANDO PB COM ID " + pb.getId());
            System.exit(0);
        }
    }

    private PayBill extractsBill(ResultSet resultadoBusca) throws SQLException, NumberFormatException {
        PayBill pb = new PayBill();
        pb.setNameUser(resultadoBusca.getString(1));
        pb.setNameBill(resultadoBusca.getString(2));
        pb.setStatus(resultadoBusca.getInt(3));

        return pb;
    }

    public PayBill searchById(int id){
        PayBill pb = new PayBill();
        try {
            Connection con = connection();
            PreparedStatement buscarId = con.prepareStatement(BUSCAR_ID);
            buscarId.setInt(1, id);
            ResultSet resultadoBusca = buscarId.executeQuery();
            while (resultadoBusca.next()) {
                pb = extractsBill(resultadoBusca);
            }
            buscarId.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO CONTA NO PB.");
            System.exit(0);
        }
        return pb;
    }
    
    public void remove(int id) {
        try {
            Connection con = connection();
            PreparedStatement apagar = con.prepareStatement(APAGAR);
            apagar.setInt(1, id);
            apagar.executeUpdate();
            apagar.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR APAGANDO PB: " + id);
            System.exit(0);
        }
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
