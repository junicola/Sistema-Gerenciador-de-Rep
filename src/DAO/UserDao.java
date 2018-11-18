package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class UserDao {

    public String logado;

    // dados para acesso ao banco
    final String USUARIO = "root";
    final String SENHA = "root123";
    final String URL_BANCO = "jdbc:mysql://localhost:3306/gerencilar";

    // constantes de acesso
    final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";

    // comandos
    final String INSERIR = "INSERT INTO User(user_name, user_password, user_rg, user_email, user_phone) VALUES(?, ?, ?, ?, ?)";
    final String ATUALIZAR = "UPDATE User SET user_name=?, user_password=?, user_rg=?, user_email=?, user_phone=? WHERE user_id = ?";
    final String BUSCAR = "SELECT user_name, user_email, user_phone, user_rg  FROM User WHERE user_id = ?";
    final String BUSCAR_TODOS = "SELECT user_id, user_name, user_email, user_phone, user_rg, user_password FROM User";
    final String APAGAR = "DELETE FROM User WHERE user_email = ?";
    final String BUSCAR_NOME = "SELECT user_id, user_name, user_email, user_phone, user_rg, user_password, user_type_id FROM User WHERE user_name=?";
    final String VALIDA_LOGIN = "SELECT user_email, user_password FROM User WHERE user_email=? and user_password=?";
    final String BUSCAR_USER = "SELECT user_id, user_name, user_email, user_phone, user_rg, user_password, user_type_id FROM User WHERE user_email=?";

    public void save(User usuario) {
        try {
            Connection con = conenction();
            PreparedStatement salvar = con.prepareStatement(INSERIR);
            salvar.setString(1, usuario.getName());
            salvar.setString(2, usuario.getPassword());
            salvar.setInt(3, usuario.getRg());
            salvar.setString(4, usuario.getEmail());
            salvar.setString(5, usuario.getPhone());
            salvar.executeUpdate();
            salvar.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR SALVANDO USUÁRIO");
            System.exit(0);
        }
    }

    public void edit(User usuario) {
        try {
            Connection con = conenction();
            PreparedStatement atualizar = con.prepareStatement(ATUALIZAR);
            atualizar.setString(1, usuario.getName());
            atualizar.setString(2, usuario.getPassword());
            atualizar.setInt(3, usuario.getRg());
            atualizar.setString(4, usuario.getEmail());
            atualizar.setString(5, usuario.getPhone());
            atualizar.setInt(6, usuario.getId());
            atualizar.executeUpdate();
            atualizar.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR ATUALIZANDO CONTA COM ID " + usuario.getId());
            System.exit(0);
        }

    }

    public void remove(String email) {
        try {
            Connection con = conenction();
            PreparedStatement apagar = con.prepareStatement(APAGAR);
            apagar.setString(1, email);
            apagar.executeUpdate();
            apagar.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR APAGANDO CONTA COM EMAIL: " + email);
            System.exit(0);
        }
    }

    public List<User> searchAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection con = conenction();
            PreparedStatement buscarTodos = con.prepareStatement(BUSCAR_TODOS);
            ResultSet resultadoBusca = buscarTodos.executeQuery();
            while (resultadoBusca.next()) {
                User user = extractsUser(resultadoBusca);
                users.add(user);
            }
            buscarTodos.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO TODAS AS CONTAS.");
            System.exit(0);
        }
        return users;
    }
    
    public User searchByEmail(String email) {
        User users = new User();
        try {
            Connection con = conenction();
            PreparedStatement buscarPorEmail = con.prepareStatement(BUSCAR_USER);
            buscarPorEmail.setString(1, email);
            ResultSet resultadoBusca = buscarPorEmail.executeQuery();
            while (resultadoBusca.next()) {
                users = extractsUser(resultadoBusca);
            }
            buscarPorEmail.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO TODAS AS CONTAS.");
            System.exit(0);
        }
        return users;
    }
    
     public User searchByName(String name) {
        User users = new User();
        try {
            Connection con = conenction();
            PreparedStatement buscarPorNome = con.prepareStatement(BUSCAR_NOME);
            buscarPorNome.setString(1, name);
            ResultSet resultadoBusca = buscarPorNome.executeQuery();
            while (resultadoBusca.next()) {
                users = extractsUser(resultadoBusca);
            }
            buscarPorNome.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO TODAS AS CONTAS.");
            System.exit(0);
        }
        return users;
    }
    

    private User extractsUser(ResultSet resultadoBusca) throws SQLException, NumberFormatException {
        User user = new User();
        user.setId(resultadoBusca.getInt(1));
        user.setName(resultadoBusca.getString(2));
        user.setEmail(resultadoBusca.getString(3));
        user.setPhone(resultadoBusca.getString(4));
        user.setRg(resultadoBusca.getInt(5));
        user.setPassword(resultadoBusca.getString(6));

        return user;
    }

    public boolean autenticLogin(String login, String senha) {
        boolean autenticado = false;

        try {
            Connection con = conenction();
            PreparedStatement ps = con.prepareStatement(VALIDA_LOGIN);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                autenticado = true;
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            return false;
        }

        return autenticado;
    }

    public String getLogado() {
        return logado;
    }

    public void setLogado(String logado) {
        this.logado = logado;
    }

    public User userLogado(String nm) throws SQLException {
        User user = new User();
        this.logado = nm;
        try {
            Connection con = conenction();
            PreparedStatement buscarUser = con.prepareStatement(BUSCAR_USER);
            buscarUser.setString(1, logado);
            ResultSet resultadoBusca = buscarUser.executeQuery();
            while (resultadoBusca.next()) {
                user = extractsUser(resultadoBusca);
            }

            buscarUser.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR BUSCANDO USUARIO LOGADO.");
            System.exit(0);
        }
        return user;
    }

    private Connection conenction() {
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
