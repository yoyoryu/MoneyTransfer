package Package;

import generated.tables.Customer;
import generated.tables.records.AccountRecord;
import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generated.tables.Account;

import javax.xml.bind.JAXB;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;

@RestController
public class AccountController extends DBConnection{

    public AccountController()
    {

    }

    @RequestMapping(value = "/TransferMoney",method = RequestMethod.GET)
    public String TransferMoney(@RequestParam(required = true) Integer AccountFrom,
                   @RequestParam(required = true) BigDecimal Amount,
                   @RequestParam(required = true) Integer AccountTo)
    {
        try {

            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            AccountRecord accountFrom = create.fetchOne(Account.ACCOUNT,Account.ACCOUNT.ID.eq(AccountFrom));
            AccountRecord accountTo = create.fetchOne(Account.ACCOUNT,Account.ACCOUNT.ID.eq(AccountTo));

            if (AccountFrom != null && accountTo != null) {
                if (WithdrawAmount(AccountFrom, Amount)) {
                    if (DepositAmount(AccountTo, Amount)) {
                        return "Success";
                    } else {
                        return "Could not transfer funds";
                    }
                } else
                    return "Error - Not Enough Funds";
            }
            else
                return "Receiving account does not exist";
        }
        catch (Exception ex)
        {
            return "Error";
        }
    }


    @RequestMapping(value = "/CreateAccount",method = RequestMethod.GET)
    public Integer CreateAccount(@RequestParam(required = true) Integer CustomerId,
                                 @RequestParam(required = true) BigDecimal InitialAmount)
    {
        try
        {

        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        AccountRecord result = create.insertInto(Account.ACCOUNT, Account.ACCOUNT.CUSTOMERID, Account.ACCOUNT.BALANCE)
                .values(CustomerId,InitialAmount)
                        .returning(Account.ACCOUNT.ID)
                        .fetchOne();
            return result.getId();
        }
        catch   (Exception ex)
        {
            return 0;
        }


    }


    @RequestMapping(value = "/DepositAmount",method = RequestMethod.GET)
    public Boolean DepositAmount(@RequestParam(required = true) Integer AccountID,
                                 @RequestParam(required = true) BigDecimal Amount)
    {

        try
        {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            int id = create.update(Account.ACCOUNT).set(Account.ACCOUNT.BALANCE,(Account.ACCOUNT.BALANCE.add(Amount)))
                    .where(Account.ACCOUNT.ID.eq(AccountID))
                    .returning(Account.ACCOUNT.ID)
                    .execute();
            return (id > 0) ? true : false;
        }
        catch   (Exception ex)
        {
            return false;
        }
    }

    @RequestMapping(value = "/WithdrawAmount",method = RequestMethod.GET)
    public Boolean WithdrawAmount(@RequestParam(required = true) Integer AccountID,
                                 @RequestParam(required = true) BigDecimal Amount)
    {

        try
        {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            AccountRecord account = create.fetchOne(Account.ACCOUNT,Account.ACCOUNT.ID.eq(AccountID));
            BigDecimal num = new BigDecimal(0);
            if (num.compareTo(account.getBalance().subtract(Amount)) <= 0)
            {
                account.setBalance(account.getBalance().subtract(Amount));
                account.store();
                return true;
            }
            else
                return false;

        }
        catch   (Exception ex)
        {
            return false;
        }
    }
}
