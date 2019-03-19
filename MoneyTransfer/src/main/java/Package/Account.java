package Package;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;


    private Double accountBalance;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;


    // (name="id",referencedColumnName="id",nullable=false,unique=true)
    public Customer getCustomer(){
        return  customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }




    public Integer getId(){
        return accountId;
    }

    public void setId(Integer id){
        this.accountId = id;
    }



    public Double getBalance(){
        return this.accountBalance;
    }

    public void setBalance(Double balance){
        this.accountBalance = balance;
    }





}
