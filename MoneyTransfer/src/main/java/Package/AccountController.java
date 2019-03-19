package Package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
@Transactional
@RequestMapping(path = "/account")
public class AccountController {
    //@Autowired
    //private AccountRepository accountRepository;

    @Resource
    private AccountService accountService;


    @Transactional(propagation = Propagation.REQUIRED)
    @GetMapping(path="{accountidfrom}/transfer/{accountidto}/{amount}")

    public @ResponseBody  Account TransferMoney(@PathVariable(value="accountidfrom") Integer accountidfrom,
                          @PathVariable(value="accountidto") Integer accountidto,
                          @PathVariable(value="amount") Double amount){
        try{
            Account account = accountService.moneyTransfer(accountidfrom,accountidto,amount);
            return account;
        }
        catch (AccountNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found",ex);
        }
        catch (InsufficientBalanceException ex){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Not Enough Funds",ex);
        }
    }

    @GetMapping(path="/{accountId}")
    public @ResponseBody
    Account GetAccount(@PathVariable(value="accountId") Integer accountId){
        try {
            return accountService.findById(accountId);
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found",ex);
        }
    }


    /*@GetMapping(path="/deposit/{accountId}/{amount}")
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
    }*/

    @GetMapping(path="/deposit/{accountId}/{amount}")
    public @ResponseBody
    Account DepositMoney(@PathVariable(value="accountId") Integer accountId,
                         @PathVariable(value="amount") Double amount)
    {
        try {
           Account account = accountService.deposit(accountId,amount);
           return account;

        }
        catch(ResponseStatusException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found",ex);
        }
        catch(AccountNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found",ex);
        }
    }

    @GetMapping(path="/withdraw/{accountId}/{amount}")
    public @ResponseBody
    Account WithDrawMoney(@PathVariable(value="accountId") Integer accountId,
                          @PathVariable(value="amount") Double amount)
    throws InsufficientBalanceException, AccountNotFoundException
    {
        try {
                Account account = accountService.withdraw(accountId,amount);
                return account;
            }
        catch (AccountNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account Not Found",ex);
        }
        catch (InsufficientBalanceException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not Enough Money in Account",ex);
        }
    }
}
