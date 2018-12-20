/*
 * This file is generated by jOOQ.
 */
package jooq.sakila.tables;


import jooq.sakila.Sakila;
import jooq.sakila.enums.FilmListRating;
import jooq.sakila.tables.records.FilmListRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UShort;

import javax.annotation.Generated;
import java.math.BigDecimal;


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
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class FilmList extends TableImpl<FilmListRecord> {

    /**
     * The reference instance of <code>sakila.film_list</code>
     */
    public static final FilmList FILM_LIST = new FilmList();
    private static final long serialVersionUID = 1152066149;
    /**
     * The column <code>sakila.film_list.FID</code>.
     */
    public final TableField<FilmListRecord, UShort> FID = createField("FID", org.jooq.impl.SQLDataType.SMALLINTUNSIGNED.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.SMALLINTUNSIGNED)), this, "");
    /**
     * The column <code>sakila.film_list.title</code>.
     */
    public final TableField<FilmListRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");
    /**
     * The column <code>sakila.film_list.description</code>.
     */
    public final TableField<FilmListRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sakila.film_list.category</code>.
     */
    public final TableField<FilmListRecord, String> CATEGORY = createField("category", org.jooq.impl.SQLDataType.VARCHAR(25).nullable(false), this, "");
    /**
     * The column <code>sakila.film_list.price</code>.
     */
    public final TableField<FilmListRecord, BigDecimal> PRICE = createField("price", org.jooq.impl.SQLDataType.DECIMAL(4, 2).defaultValue(org.jooq.impl.DSL.inline("4.99", org.jooq.impl.SQLDataType.DECIMAL)), this, "");
    /**
     * The column <code>sakila.film_list.length</code>.
     */
    public final TableField<FilmListRecord, UShort> LENGTH = createField("length", org.jooq.impl.SQLDataType.SMALLINTUNSIGNED, this, "");
    /**
     * The column <code>sakila.film_list.rating</code>.
     */
    public final TableField<FilmListRecord, FilmListRating> RATING = createField("rating", org.jooq.impl.SQLDataType.VARCHAR(5).defaultValue(org.jooq.impl.DSL.inline("G", org.jooq.impl.SQLDataType.VARCHAR)).asEnumDataType(jooq.sakila.enums.FilmListRating.class), this, "");
    /**
     * The column <code>sakila.film_list.actors</code>.
     */
    public final TableField<FilmListRecord, String> ACTORS = createField("actors", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>sakila.film_list</code> table reference
     */
    public FilmList() {
        this(DSL.name("film_list"), null);
    }

    /**
     * Create an aliased <code>sakila.film_list</code> table reference
     */
    public FilmList(String alias) {
        this(DSL.name(alias), FILM_LIST);
    }

    /**
     * Create an aliased <code>sakila.film_list</code> table reference
     */
    public FilmList(Name alias) {
        this(alias, FILM_LIST);
    }

    private FilmList(Name alias, Table<FilmListRecord> aliased) {
        this(alias, aliased, null);
    }

    private FilmList(Name alias, Table<FilmListRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> FilmList(Table<O> child, ForeignKey<O, FilmListRecord> key) {
        super(child, key, FILM_LIST);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FilmListRecord> getRecordType() {
        return FilmListRecord.class;
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
    public FilmList as(String alias) {
        return new FilmList(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilmList as(Name alias) {
        return new FilmList(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FilmList rename(String name) {
        return new FilmList(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FilmList rename(Name name) {
        return new FilmList(name, null);
    }
}
