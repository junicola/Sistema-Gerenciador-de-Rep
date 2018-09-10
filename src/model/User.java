package model;
/**
 *
 * @author JuliaNicolaGualeve
 */
public class User {
    private String name;
    private String email;
    private String phone;
    private String rg;
    private String Password;

    public User() {
    }
    
    public User(String email, String nome, String password, String rg, String tel) {
        this.email = email;
        this.name = nome;
        this.Password = password;
        this.rg = rg;
        this.phone = tel;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    } 
    
}
