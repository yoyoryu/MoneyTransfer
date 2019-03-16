package Package;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    private String customerName;

    @JsonIgnore
    @OneToMany(targetEntity = Account.class, mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Account> accounts;


    public List<Account> getAccounts(){
        return accounts;
    }

    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }

    public Customer(){

    }

    public Customer(String name, Account accounts)
    {
        this.customerName = name;
        //this.accounts = Stream.of(accounts).collect(Collectors.toSet());
    }

    public Integer getId(){
        return this.customerId;
    }

    public void setId(Integer customerId){
        this.customerId = customerId;
    }

    public String getName(){
        return this.customerName;
    }

    public void setName(String name) {
        this.customerName = name;
    }


}
