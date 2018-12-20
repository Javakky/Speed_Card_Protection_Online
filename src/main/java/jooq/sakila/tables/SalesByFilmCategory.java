/*
 * This file is generated by jOOQ.
 */
package jooq.sakila.tables;


import jooq.sakila.Sakila;
import jooq.sakila.tables.records.SalesByFilmCategoryRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

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
public class SalesByFilmCategory extends TableImpl<SalesByFilmCategoryRecord> {

    /**
     * The reference instance of <code>sakila.sales_by_film_category</code>
     */
    public static final SalesByFilmCategory SALES_BY_FILM_CATEGORY = new SalesByFilmCategory();
    private static final long serialVersionUID = 1320314413;
    /**
     * The column <code>sakila.sales_by_film_category.category</code>.
     */
    public final TableField<SalesByFilmCategoryRecord, String> CATEGORY = createField("category", org.jooq.impl.SQLDataType.VARCHAR(25).nullable(false), this, "");
    /**
     * The column <code>sakila.sales_by_film_category.total_sales</code>.
     */
    public final TableField<SalesByFilmCategoryRecord, BigDecimal> TOTAL_SALES = createField("total_sales", org.jooq.impl.SQLDataType.DECIMAL(27, 2), this, "");

    /**
     * Create a <code>sakila.sales_by_film_category</code> table reference
     */
    public SalesByFilmCategory() {
        this(DSL.name("sales_by_film_category"), null);
    }

    /**
     * Create an aliased <code>sakila.sales_by_film_category</code> table reference
     */
    public SalesByFilmCategory(String alias) {
        this(DSL.name(alias), SALES_BY_FILM_CATEGORY);
    }

    /**
     * Create an aliased <code>sakila.sales_by_film_category</code> table reference
     */
    public SalesByFilmCategory(Name alias) {
        this(alias, SALES_BY_FILM_CATEGORY);
    }

    private SalesByFilmCategory(Name alias, Table<SalesByFilmCategoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private SalesByFilmCategory(Name alias, Table<SalesByFilmCategoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> SalesByFilmCategory(Table<O> child, ForeignKey<O, SalesByFilmCategoryRecord> key) {
        super(child, key, SALES_BY_FILM_CATEGORY);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SalesByFilmCategoryRecord> getRecordType() {
        return SalesByFilmCategoryRecord.class;
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
    public SalesByFilmCategory as(String alias) {
        return new SalesByFilmCategory(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SalesByFilmCategory as(Name alias) {
        return new SalesByFilmCategory(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SalesByFilmCategory rename(String name) {
        return new SalesByFilmCategory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SalesByFilmCategory rename(Name name) {
        return new SalesByFilmCategory(name, null);
    }
}
