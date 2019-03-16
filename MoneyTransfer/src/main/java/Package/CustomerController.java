package Package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path="/add")
    public @ResponseBody String AddNewCustomer(@RequestParam String name){
        Customer c = new Customer();
        c.setName(name);
        customerRepository.save(c);
        return "Saved";
    }


    @GetMapping(path="/accounts")
    public @ResponseBody
    List<Account> GetAccounts(@RequestParam Integer customerId){

        Customer c = customerRepository.findByCustomerId(customerId);
        return c.getAccounts();
    }

}
