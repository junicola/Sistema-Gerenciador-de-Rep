package model;

import java.io.Serializable;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class User {

    private String name;
    private String email;
    private String phone;
    private int rg;
    private String Password;
    private int id;

    public User() {
    }

    public User(String email, String nome, String password, int rg, String tel) {
        this.email = email;
        this.name = nome;
        this.Password = password;
        this.rg = rg;
        this.phone = tel;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
