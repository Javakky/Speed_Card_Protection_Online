/*
 * This file is generated by jOOQ.
 */
package jooq.sakila.tables;


import javax.annotation.Generated;

import jooq.sakila.Sakila;
import jooq.sakila.tables.records.ActorInfoRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UShort;


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
public class ActorInfo extends TableImpl<ActorInfoRecord> {

    private static final long serialVersionUID = -742257732;

    /**
     * The reference instance of <code>sakila.actor_info</code>
     */
    public static final ActorInfo ACTOR_INFO = new ActorInfo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ActorInfoRecord> getRecordType() {
        return ActorInfoRecord.class;
    }

    /**
     * The column <code>sakila.actor_info.actor_id</code>.
     */
    public final TableField<ActorInfoRecord, UShort> ACTOR_ID = createField("actor_id", org.jooq.impl.SQLDataType.SMALLINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.SMALLINTUNSIGNED)), this, "");

    /**
     * The column <code>sakila.actor_info.first_name</code>.
     */
    public final TableField<ActorInfoRecord, String> FIRST_NAME = createField("first_name", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>sakila.actor_info.last_name</code>.
     */
    public final TableField<ActorInfoRecord, String> LAST_NAME = createField("last_name", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>sakila.actor_info.film_info</code>.
     */
    public final TableField<ActorInfoRecord, String> FILM_INFO = createField("film_info", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>sakila.actor_info</code> table reference
     */
    public ActorInfo() {
        this(DSL.name("actor_info"), null);
    }

    /**
     * Create an aliased <code>sakila.actor_info</code> table reference
     */
    public ActorInfo(String alias) {
        this(DSL.name(alias), ACTOR_INFO);
    }

    /**
     * Create an aliased <code>sakila.actor_info</code> table reference
     */
    public ActorInfo(Name alias) {
        this(alias, ACTOR_INFO);
    }

    private ActorInfo(Name alias, Table<ActorInfoRecord> aliased) {
        this(alias, aliased, null);
    }

    private ActorInfo(Name alias, Table<ActorInfoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> ActorInfo(Table<O> child, ForeignKey<O, ActorInfoRecord> key) {
        super(child, key, ACTOR_INFO);
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
    public ActorInfo as(String alias) {
        return new ActorInfo(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ActorInfo as(Name alias) {
        return new ActorInfo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ActorInfo rename(String name) {
        return new ActorInfo(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ActorInfo rename(Name name) {
        return new ActorInfo(name, null);
    }
}
