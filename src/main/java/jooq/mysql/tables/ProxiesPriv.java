/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooq.mysql.Indexes;
import jooq.mysql.Keys;
import jooq.mysql.Mysql;
import jooq.mysql.tables.records.ProxiesPrivRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * User proxy privileges
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProxiesPriv extends TableImpl<ProxiesPrivRecord> {

    private static final long serialVersionUID = -1898390397;

    /**
     * The reference instance of <code>mysql.proxies_priv</code>
     */
    public static final ProxiesPriv PROXIES_PRIV = new ProxiesPriv();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProxiesPrivRecord> getRecordType() {
        return ProxiesPrivRecord.class;
    }

    /**
     * The column <code>mysql.proxies_priv.Host</code>.
     */
    public final TableField<ProxiesPrivRecord, String> HOST = createField("Host", org.jooq.impl.SQLDataType.CHAR(60).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>mysql.proxies_priv.User</code>.
     */
    public final TableField<ProxiesPrivRecord, String> USER = createField("User", org.jooq.impl.SQLDataType.CHAR(32).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>mysql.proxies_priv.Proxied_host</code>.
     */
    public final TableField<ProxiesPrivRecord, String> PROXIED_HOST = createField("Proxied_host", org.jooq.impl.SQLDataType.CHAR(60).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>mysql.proxies_priv.Proxied_user</code>.
     */
    public final TableField<ProxiesPrivRecord, String> PROXIED_USER = createField("Proxied_user", org.jooq.impl.SQLDataType.CHAR(32).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>mysql.proxies_priv.With_grant</code>.
     */
    public final TableField<ProxiesPrivRecord, Byte> WITH_GRANT = createField("With_grant", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>mysql.proxies_priv.Grantor</code>.
     */
    public final TableField<ProxiesPrivRecord, String> GRANTOR = createField("Grantor", org.jooq.impl.SQLDataType.CHAR(93).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>mysql.proxies_priv.Timestamp</code>.
     */
    public final TableField<ProxiesPrivRecord, Timestamp> TIMESTAMP = createField("Timestamp", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>mysql.proxies_priv</code> table reference
     */
    public ProxiesPriv() {
        this(DSL.name("proxies_priv"), null);
    }

    /**
     * Create an aliased <code>mysql.proxies_priv</code> table reference
     */
    public ProxiesPriv(String alias) {
        this(DSL.name(alias), PROXIES_PRIV);
    }

    /**
     * Create an aliased <code>mysql.proxies_priv</code> table reference
     */
    public ProxiesPriv(Name alias) {
        this(alias, PROXIES_PRIV);
    }

    private ProxiesPriv(Name alias, Table<ProxiesPrivRecord> aliased) {
        this(alias, aliased, null);
    }

    private ProxiesPriv(Name alias, Table<ProxiesPrivRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("User proxy privileges"));
    }

    public <O extends Record> ProxiesPriv(Table<O> child, ForeignKey<O, ProxiesPrivRecord> key) {
        super(child, key, PROXIES_PRIV);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Mysql.MYSQL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PROXIES_PRIV_GRANTOR, Indexes.PROXIES_PRIV_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProxiesPrivRecord> getPrimaryKey() {
        return Keys.KEY_PROXIES_PRIV_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProxiesPrivRecord>> getKeys() {
        return Arrays.<UniqueKey<ProxiesPrivRecord>>asList(Keys.KEY_PROXIES_PRIV_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProxiesPriv as(String alias) {
        return new ProxiesPriv(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProxiesPriv as(Name alias) {
        return new ProxiesPriv(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ProxiesPriv rename(String name) {
        return new ProxiesPriv(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ProxiesPriv rename(Name name) {
        return new ProxiesPriv(name, null);
    }
}
