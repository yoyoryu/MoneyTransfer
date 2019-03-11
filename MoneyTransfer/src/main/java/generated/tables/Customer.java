/*
 * This file is generated by jOOQ.
 */
package generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import generated.Indexes;
import generated.Keys;
import generated.Moneytransfer;
import generated.tables.records.CustomerRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Customer extends TableImpl<CustomerRecord> {

    private static final long serialVersionUID = -808774541;

    /**
     * The reference instance of <code>moneytransfer.customer</code>
     */
    public static final Customer CUSTOMER = new Customer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CustomerRecord> getRecordType() {
        return CustomerRecord.class;
    }

    /**
     * The column <code>moneytransfer.customer.ID</code>.
     */
    public final TableField<CustomerRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>moneytransfer.customer.FirstName</code>.
     */
    public final TableField<CustomerRecord, String> FIRSTNAME = createField("FirstName", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>moneytransfer.customer.LastName</code>.
     */
    public final TableField<CustomerRecord, String> LASTNAME = createField("LastName", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>moneytransfer.customer.IdentificationTypeId</code>.
     */
    public final TableField<CustomerRecord, Short> IDENTIFICATIONTYPEID = createField("IdentificationTypeId", org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>moneytransfer.customer.IdentificationID</code>.
     */
    public final TableField<CustomerRecord, String> IDENTIFICATIONID = createField("IdentificationID", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * Create a <code>moneytransfer.customer</code> table reference
     */
    public Customer() {
        this(DSL.name("customer"), null);
    }

    /**
     * Create an aliased <code>moneytransfer.customer</code> table reference
     */
    public Customer(String alias) {
        this(DSL.name(alias), CUSTOMER);
    }

    /**
     * Create an aliased <code>moneytransfer.customer</code> table reference
     */
    public Customer(Name alias) {
        this(alias, CUSTOMER);
    }

    private Customer(Name alias, Table<CustomerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Customer(Name alias, Table<CustomerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Customer(Table<O> child, ForeignKey<O, CustomerRecord> key) {
        super(child, key, CUSTOMER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Moneytransfer.MONEYTRANSFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CUSTOMER_FK_ID_TYPE_ID, Indexes.CUSTOMER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CustomerRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CUSTOMER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CustomerRecord> getPrimaryKey() {
        return Keys.KEY_CUSTOMER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CustomerRecord>> getKeys() {
        return Arrays.<UniqueKey<CustomerRecord>>asList(Keys.KEY_CUSTOMER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<CustomerRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CustomerRecord, ?>>asList(Keys.FK_ID_TYPE_ID);
    }

    public Identificationtype identificationtype() {
        return new Identificationtype(this, Keys.FK_ID_TYPE_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer as(String alias) {
        return new Customer(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer as(Name alias) {
        return new Customer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Customer rename(String name) {
        return new Customer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Customer rename(Name name) {
        return new Customer(name, null);
    }
}
