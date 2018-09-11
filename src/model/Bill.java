package model;

import java.util.Date;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class Bill {
     private String name;
    private String value;
    private String expDate;
    private String status;
    private String userName;

    public Bill(){
        
    }

    public Bill(String name, String value, String expDate, String userName, String status) {
        this.name = name;
        this.value = value;
        this.expDate = expDate;
        this.status = status;
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
