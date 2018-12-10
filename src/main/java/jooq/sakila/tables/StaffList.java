/*
 * This file is generated by jOOQ.
 */
package jooq.sakila.tables;


import javax.annotation.Generated;

import jooq.sakila.Sakila;
import jooq.sakila.tables.records.StaffListRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UByte;


/**
 * VIEW
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StaffList extends TableImpl<StaffListRecord> {

    private static final long serialVersionUID = 839159534;

    /**
     * The reference instance of <code>sakila.staff_list</code>
     */
    public static final StaffList STAFF_LIST = new StaffList();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StaffListRecord> getRecordType() {
        return StaffListRecord.class;
    }

    /**
     * The column <code>sakila.staff_list.ID</code>.
     */
    public final TableField<StaffListRecord, UByte> ID = createField("ID", org.jooq.impl.SQLDataType.TINYINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINTUNSIGNED)), this, "");

    /**
     * The column <code>sakila.staff_list.name</code>.
     */
    public final TableField<StaffListRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(91), this, "");

    /**
     * The column <code>sakila.staff_list.address</code>.
     */
    public final TableField<StaffListRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>sakila.staff_list.zip code</code>.
     */
    public final TableField<StaffListRecord, String> ZIP_CODE = createField("zip code", org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>sakila.staff_list.phone</code>.
     */
    public final TableField<StaffListRecord, String> PHONE = createField("phone", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>sakila.staff_list.city</code>.
     */
    public final TableField<StaffListRecord, String> CITY = createField("city", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>sakila.staff_list.country</code>.
     */
    public final TableField<StaffListRecord, String> COUNTRY = createField("country", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>sakila.staff_list.SID</code>.
     */
    public final TableField<StaffListRecord, UByte> SID = createField("SID", org.jooq.impl.SQLDataType.TINYINTUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>sakila.staff_list</code> table reference
     */
    public StaffList() {
        this(DSL.name("staff_list"), null);
    }

    /**
     * Create an aliased <code>sakila.staff_list</code> table reference
     */
    public StaffList(String alias) {
        this(DSL.name(alias), STAFF_LIST);
    }

    /**
     * Create an aliased <code>sakila.staff_list</code> table reference
     */
    public StaffList(Name alias) {
        this(alias, STAFF_LIST);
    }

    private StaffList(Name alias, Table<StaffListRecord> aliased) {
        this(alias, aliased, null);
    }

    private StaffList(Name alias, Table<StaffListRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> StaffList(Table<O> child, ForeignKey<O, StaffListRecord> key) {
        super(child, key, STAFF_LIST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Sakila.SAKILA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffList as(String alias) {
        return new StaffList(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffList as(Name alias) {
        return new StaffList(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StaffList rename(String name) {
        return new StaffList(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StaffList rename(Name name) {
        return new StaffList(name, null);
    }
}
