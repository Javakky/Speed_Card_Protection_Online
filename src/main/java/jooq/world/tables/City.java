/*
 * This file is generated by jOOQ.
 */
package jooq.world.tables;


import jooq.world.Indexes;
import jooq.world.Keys;
import jooq.world.World;
import jooq.world.tables.records.CityRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


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
public class City extends TableImpl<CityRecord> {

    private static final long serialVersionUID = 1154635904;

    /**
     * The reference instance of <code>world.city</code>
     */
    public static final City CITY = new City();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CityRecord> getRecordType() {
        return CityRecord.class;
    }

    /**
     * The column <code>world.city.ID</code>.
     */
    public final TableField<CityRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>world.city.Name</code>.
     */
    public final TableField<CityRecord, String> NAME = createField("Name", org.jooq.impl.SQLDataType.CHAR(35).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>world.city.CountryCode</code>.
     */
    public final TableField<CityRecord, String> COUNTRYCODE = createField("CountryCode", org.jooq.impl.SQLDataType.CHAR(3).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>world.city.District</code>.
     */
    public final TableField<CityRecord, String> DISTRICT = createField("District", org.jooq.impl.SQLDataType.CHAR(20).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>world.city.Population</code>.
     */
    public final TableField<CityRecord, Integer> POPULATION = createField("Population", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>world.city</code> table reference
     */
    public City() {
        this(DSL.name("city"), null);
    }

    /**
     * Create an aliased <code>world.city</code> table reference
     */
    public City(String alias) {
        this(DSL.name(alias), CITY);
    }

    /**
     * Create an aliased <code>world.city</code> table reference
     */
    public City(Name alias) {
        this(alias, CITY);
    }

    private City(Name alias, Table<CityRecord> aliased) {
        this(alias, aliased, null);
    }

    private City(Name alias, Table<CityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> City(Table<O> child, ForeignKey<O, CityRecord> key) {
        super(child, key, CITY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return World.WORLD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CITY_COUNTRYCODE, Indexes.CITY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CityRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CityRecord> getPrimaryKey() {
        return Keys.KEY_CITY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CityRecord>> getKeys() {
        return Arrays.<UniqueKey<CityRecord>>asList(Keys.KEY_CITY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<CityRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CityRecord, ?>>asList(Keys.CITY_IBFK_1);
    }

    public Country country() {
        return new Country(this, Keys.CITY_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public City as(String alias) {
        return new City(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public City as(Name alias) {
        return new City(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public City rename(String name) {
        return new City(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public City rename(Name name) {
        return new City(name, null);
    }
}
