package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class Bill {
    private String name;
    private Float value;
    private Date expDate;
    private int status;
    private int id;

    public Bill(){
        
    }

    public Bill(String name, float value, Date expDate, int status) {
        this.name = name;
        this.value = value;
        this.expDate = expDate;
        this.status = status;
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

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
      
}
