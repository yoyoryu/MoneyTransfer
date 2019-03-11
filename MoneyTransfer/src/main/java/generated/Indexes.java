/*
 * This file is generated by jOOQ.
 */
package generated;


import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;

import generated.tables.Account;
import generated.tables.Accounttransactions;
import generated.tables.Customer;
import generated.tables.Identificationtype;


/**
 * A class modelling indexes of tables of the <code>moneytransfer</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ACCOUNT_FK_ACC_CUST_ID = Indexes0.ACCOUNT_FK_ACC_CUST_ID;
    public static final Index ACCOUNT_PRIMARY = Indexes0.ACCOUNT_PRIMARY;
    public static final Index ACCOUNTTRANSACTIONS_FK_ACCTR_ACC_ID = Indexes0.ACCOUNTTRANSACTIONS_FK_ACCTR_ACC_ID;
    public static final Index ACCOUNTTRANSACTIONS_PRIMARY = Indexes0.ACCOUNTTRANSACTIONS_PRIMARY;
    public static final Index CUSTOMER_FK_ID_TYPE_ID = Indexes0.CUSTOMER_FK_ID_TYPE_ID;
    public static final Index CUSTOMER_PRIMARY = Indexes0.CUSTOMER_PRIMARY;
    public static final Index IDENTIFICATIONTYPE_PRIMARY = Indexes0.IDENTIFICATIONTYPE_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ACCOUNT_FK_ACC_CUST_ID = Internal.createIndex("FK_ACC_CUST_ID", Account.ACCOUNT, new OrderField[] { Account.ACCOUNT.CUSTOMERID }, false);
        public static Index ACCOUNT_PRIMARY = Internal.createIndex("PRIMARY", Account.ACCOUNT, new OrderField[] { Account.ACCOUNT.ID }, true);
        public static Index ACCOUNTTRANSACTIONS_FK_ACCTR_ACC_ID = Internal.createIndex("FK_ACCTR_ACC_ID", Accounttransactions.ACCOUNTTRANSACTIONS, new OrderField[] { Accounttransactions.ACCOUNTTRANSACTIONS.ACCOUNTID }, false);
        public static Index ACCOUNTTRANSACTIONS_PRIMARY = Internal.createIndex("PRIMARY", Accounttransactions.ACCOUNTTRANSACTIONS, new OrderField[] { Accounttransactions.ACCOUNTTRANSACTIONS.ID }, true);
        public static Index CUSTOMER_FK_ID_TYPE_ID = Internal.createIndex("FK_ID_TYPE_ID", Customer.CUSTOMER, new OrderField[] { Customer.CUSTOMER.IDENTIFICATIONTYPEID }, false);
        public static Index CUSTOMER_PRIMARY = Internal.createIndex("PRIMARY", Customer.CUSTOMER, new OrderField[] { Customer.CUSTOMER.ID }, true);
        public static Index IDENTIFICATIONTYPE_PRIMARY = Internal.createIndex("PRIMARY", Identificationtype.IDENTIFICATIONTYPE, new OrderField[] { Identificationtype.IDENTIFICATIONTYPE.ID }, true);
    }
}
