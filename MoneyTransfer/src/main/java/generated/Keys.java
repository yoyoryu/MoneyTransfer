/*
 * This file is generated by jOOQ.
 */
package generated;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import generated.tables.Account;
import generated.tables.Accounttransactions;
import generated.tables.Customer;
import generated.tables.Identificationtype;
import generated.tables.records.AccountRecord;
import generated.tables.records.AccounttransactionsRecord;
import generated.tables.records.CustomerRecord;
import generated.tables.records.IdentificationtypeRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>moneytransfer</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = Identities0.IDENTITY_ACCOUNT;
    public static final Identity<AccounttransactionsRecord, Integer> IDENTITY_ACCOUNTTRANSACTIONS = Identities0.IDENTITY_ACCOUNTTRANSACTIONS;
    public static final Identity<CustomerRecord, Integer> IDENTITY_CUSTOMER = Identities0.IDENTITY_CUSTOMER;
    public static final Identity<IdentificationtypeRecord, Short> IDENTITY_IDENTIFICATIONTYPE = Identities0.IDENTITY_IDENTIFICATIONTYPE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = UniqueKeys0.KEY_ACCOUNT_PRIMARY;
    public static final UniqueKey<AccounttransactionsRecord> KEY_ACCOUNTTRANSACTIONS_PRIMARY = UniqueKeys0.KEY_ACCOUNTTRANSACTIONS_PRIMARY;
    public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = UniqueKeys0.KEY_CUSTOMER_PRIMARY;
    public static final UniqueKey<IdentificationtypeRecord> KEY_IDENTIFICATIONTYPE_PRIMARY = UniqueKeys0.KEY_IDENTIFICATIONTYPE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AccountRecord, CustomerRecord> FK_ACC_CUST_ID = ForeignKeys0.FK_ACC_CUST_ID;
    public static final ForeignKey<AccounttransactionsRecord, AccountRecord> FK_ACCTR_ACC_ID = ForeignKeys0.FK_ACCTR_ACC_ID;
    public static final ForeignKey<CustomerRecord, IdentificationtypeRecord> FK_ID_TYPE_ID = ForeignKeys0.FK_ID_TYPE_ID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = Internal.createIdentity(Account.ACCOUNT, Account.ACCOUNT.ID);
        public static Identity<AccounttransactionsRecord, Integer> IDENTITY_ACCOUNTTRANSACTIONS = Internal.createIdentity(Accounttransactions.ACCOUNTTRANSACTIONS, Accounttransactions.ACCOUNTTRANSACTIONS.ID);
        public static Identity<CustomerRecord, Integer> IDENTITY_CUSTOMER = Internal.createIdentity(Customer.CUSTOMER, Customer.CUSTOMER.ID);
        public static Identity<IdentificationtypeRecord, Short> IDENTITY_IDENTIFICATIONTYPE = Internal.createIdentity(Identificationtype.IDENTIFICATIONTYPE, Identificationtype.IDENTIFICATIONTYPE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = Internal.createUniqueKey(Account.ACCOUNT, "KEY_account_PRIMARY", Account.ACCOUNT.ID);
        public static final UniqueKey<AccounttransactionsRecord> KEY_ACCOUNTTRANSACTIONS_PRIMARY = Internal.createUniqueKey(Accounttransactions.ACCOUNTTRANSACTIONS, "KEY_accounttransactions_PRIMARY", Accounttransactions.ACCOUNTTRANSACTIONS.ID);
        public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = Internal.createUniqueKey(Customer.CUSTOMER, "KEY_customer_PRIMARY", Customer.CUSTOMER.ID);
        public static final UniqueKey<IdentificationtypeRecord> KEY_IDENTIFICATIONTYPE_PRIMARY = Internal.createUniqueKey(Identificationtype.IDENTIFICATIONTYPE, "KEY_identificationtype_PRIMARY", Identificationtype.IDENTIFICATIONTYPE.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<AccountRecord, CustomerRecord> FK_ACC_CUST_ID = Internal.createForeignKey(Keys.KEY_CUSTOMER_PRIMARY, Account.ACCOUNT, "FK_ACC_CUST_ID", Account.ACCOUNT.CUSTOMERID);
        public static final ForeignKey<AccounttransactionsRecord, AccountRecord> FK_ACCTR_ACC_ID = Internal.createForeignKey(Keys.KEY_ACCOUNT_PRIMARY, Accounttransactions.ACCOUNTTRANSACTIONS, "FK_ACCTR_ACC_ID", Accounttransactions.ACCOUNTTRANSACTIONS.ACCOUNTID);
        public static final ForeignKey<CustomerRecord, IdentificationtypeRecord> FK_ID_TYPE_ID = Internal.createForeignKey(Keys.KEY_IDENTIFICATIONTYPE_PRIMARY, Customer.CUSTOMER, "FK_ID_TYPE_ID", Customer.CUSTOMER.IDENTIFICATIONTYPEID);
    }
}
