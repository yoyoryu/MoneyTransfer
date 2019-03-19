package Package;

public interface AccountService {
    public Account create(Account account);

    public Account findById(Integer accountId) throws  AccountNotFoundException;

    public Account deposit(Integer accountId, Double amount) throws  AccountNotFoundException;

    public Account withdraw(Integer accountId, Double amount) throws  AccountNotFoundException, InsufficientBalanceException;

    public Account moneyTransfer(Integer accountFrom, Integer accountTo, Double amount) throws AccountNotFoundException, InsufficientBalanceException;

}
