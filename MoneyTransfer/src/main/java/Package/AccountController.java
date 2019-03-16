package Package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@Transactional
@RequestMapping(path = "/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @GetMapping(path="{accountidfrom}/transfer/{accountidto}/{amount}")

    public @ResponseBody  Account TransferMoney(@PathVariable(value="accountidfrom") Integer accountidfrom,
                          @PathVariable(value="accountidto") Integer accountidto,
                          @PathVariable(value="amount") Integer amount){
        try{
            Account account = WithDrawMoney(accountidfrom,amount);
            DepositMoney(accountidto,amount);
            return account;
        }
        catch (InsufficientBalanceException ex){

        }
        catch (ResponseStatusException ex){

        }
        return null;
    }

    @GetMapping(path="/{accountId}")
    public @ResponseBody
    Account GetAccount(@PathVariable(value="accountId") Integer accountId){
        try {
            return accountRepository.findById(accountId).get();
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found",ex);
        }
    }


    @GetMapping(path="/deposit/{accountId}/{amount}")
    public @ResponseBody
    Account DepositMoney(@PathVariable(value="accountId") Integer accountId,
                          @PathVariable(value="amount") Integer amount)
    {
        try {
            Account account = accountRepository.findById(accountId).get();
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
            return account;
        }
        catch(ResponseStatusException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found",ex);
        }
    }

    @GetMapping(path="/withdraw/{accountId}/{amount}")
    public @ResponseBody
    Account WithDrawMoney(@PathVariable(value="accountId") Integer accountId,
                          @PathVariable(value="amount") Integer amount)
    throws InsufficientBalanceException
    {
        try {
            Account account = accountRepository.findById(accountId).get();
            Double newBalance = account.getBalance() - amount;
            if (newBalance >= 0){
                account.setBalance(newBalance);
                accountRepository.save(account);
                return account;
            }
            else
                throw new InsufficientBalanceException("AccountID " + accountId +" does not have enough funds");
        }
        catch(ResponseStatusException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found",ex);
        }
    }

    @ResponseStatus
    public class InsufficientBalanceException extends Exception
    {
        public InsufficientBalanceException(String message){
           super(message);
        }
    }

}
