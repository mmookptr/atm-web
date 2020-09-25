package th.ac.ku.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BankAccount {

    private int id;
    private String customerId;
    private String type;
    private double balance;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCustomerId(){
        return customerId;
    }
    public void setCustomerId(String  customerId){
        this.customerId = customerId;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }


}

