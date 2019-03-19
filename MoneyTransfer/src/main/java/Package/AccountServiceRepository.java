package Package;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountServiceRepository implements AccountService {
    @Resource
    private AccountRepository accountRepository;

    public Account create(Account account){
        return accountRepository.save(account);
    }

    public Account findById(Integer accountId) throws AccountNotFoundException {
        try{
            Account account = accountRepository.findById(accountId).get();
            accountRepository.save(account);
            return account;
        }
        catch (Exception ex)
        {
            throw new AccountNotFoundException();
        }
    }

    public Account deposit(Integer accountId, Double amount) throws AccountNotFoundException{
        try{
            Account account = accountRepository.findById(accountId).get();
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        return account;
        }
        catch (Exception ex)
        {
            throw new AccountNotFoundException();
        }
    }

    public Account withdraw(Integer accountId, Double amount) throws InsufficientBalanceException, AccountNotFoundException {
        Account account = accountRepository.findById(accountId).get();
        if (account == null) {
            throw new AccountNotFoundException();
        }

        Double newBalance = account.getBalance() - amount;
        if (newBalance >= 0) {
            account.setBalance(newBalance);
            accountRepository.save(account);
            return account;
        } else{
            throw new InsufficientBalanceException();
        }

    }

    @Transactional
    public Account moneyTransfer(Integer accountFrom, Integer accountTo, Double amount) throws  AccountNotFoundException, InsufficientBalanceException{
        try{
        Account account = withdraw(accountFrom,amount);
        deposit(accountTo,amount);
        return account;
        }
        catch(AccountNotFoundException ex){
            throw ex;
        }
        catch(InsufficientBalanceException ex){
            throw ex;
        }
    }
}
