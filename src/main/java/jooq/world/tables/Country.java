/*
 * This file is generated by jOOQ.
 */
package jooq.world.tables;


import jooq.world.Indexes;
import jooq.world.Keys;
import jooq.world.World;
import jooq.world.enums.CountryContinent;
import jooq.world.tables.records.CountryRecord;
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
public class Country extends TableImpl<CountryRecord> {

    private static final long serialVersionUID = 1289315050;

    /**
     * The reference instance of <code>world.country</code>
     */
    public static final Country COUNTRY = new Country();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CountryRecord> getRecordType() {
        return CountryRecord.class;
    }

    /**
     * The column <code>world.country.Code</code>.
     */
    public final TableField<CountryRecord, String> CODE = createField("Code", org.jooq.impl.SQLDataType.CHAR(3).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>world.country.Name</code>.
     */
    public final TableField<CountryRecord, String> NAME = createField("Name", org.jooq.impl.SQLDataType.CHAR(52).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>world.country.Continent</code>.
     */
    public final TableField<CountryRecord, CountryContinent> CONTINENT = createField("Continent", org.jooq.impl.SQLDataType.VARCHAR(13).nullable(false).defaultValue(org.jooq.impl.DSL.inline("Asia", org.jooq.impl.SQLDataType.VARCHAR)).asEnumDataType(jooq.world.enums.CountryContinent.class), this, "");

    /**
     * The column <code>world.country.Region</code>.
     */
    public final TableField<CountryRecord, String> REGION = createField("Region", org.jooq.impl.SQLDataType.CHAR(26).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>world.country.SurfaceArea</code>.
     */
    public final TableField<CountryRecord, Double> SURFACEAREA = createField("SurfaceArea", org.jooq.impl.SQLDataType.FLOAT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.FLOAT)), this, "");

    /**
     * The column <code>world.country.IndepYear</code>.
     */
    public final TableField<CountryRecord, Short> INDEPYEAR = createField("IndepYear", org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>world.country.Population</code>.
     */
    public final TableField<CountryRecord, Integer> POPULATION = createField("Population", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>world.country.LifeExpectancy</code>.
     */
    public final TableField<CountryRecord, Double> LIFEEXPECTANCY = createField("LifeExpectancy", org.jooq.impl.SQLDataType.FLOAT, this, "");

    /**
     * The column <code>world.country.GNP</code>.
     */
    public final TableField<CountryRecord, Double> GNP = createField("GNP", org.jooq.impl.SQLDataType.FLOAT, this, "");

    /**
     * The column <code>world.country.GNPOld</code>.
     */
    public final TableField<CountryRecord, Double> GNPOLD = createField("GNPOld", org.jooq.impl.SQLDataType.FLOAT, this, "");

    /**
     * The column <code>world.country.LocalName</code>.
     */
    public final TableField<CountryRecord, String> LOCALNAME = createField("LocalName", org.jooq.impl.SQLDataType.CHAR(45).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>world.country.GovernmentForm</code>.
     */
    public final TableField<CountryRecord, String> GOVERNMENTFORM = createField("GovernmentForm", org.jooq.impl.SQLDataType.CHAR(45).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>world.country.HeadOfState</code>.
     */
    public final TableField<CountryRecord, String> HEADOFSTATE = createField("HeadOfState", org.jooq.impl.SQLDataType.CHAR(60), this, "");

    /**
     * The column <code>world.country.Capital</code>.
     */
    public final TableField<CountryRecord, Integer> CAPITAL = createField("Capital", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>world.country.Code2</code>.
     */
    public final TableField<CountryRecord, String> CODE2 = createField("Code2", org.jooq.impl.SQLDataType.CHAR(2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * Create a <code>world.country</code> table reference
     */
    public Country() {
        this(DSL.name("country"), null);
    }

    /**
     * Create an aliased <code>world.country</code> table reference
     */
    public Country(String alias) {
        this(DSL.name(alias), COUNTRY);
    }

    /**
     * Create an aliased <code>world.country</code> table reference
     */
    public Country(Name alias) {
        this(alias, COUNTRY);
    }

    private Country(Name alias, Table<CountryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Country(Name alias, Table<CountryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Country(Table<O> child, ForeignKey<O, CountryRecord> key) {
        super(child, key, COUNTRY);
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
        return Arrays.<Index>asList(Indexes.COUNTRY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CountryRecord> getPrimaryKey() {
        return Keys.KEY_COUNTRY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CountryRecord>> getKeys() {
        return Arrays.<UniqueKey<CountryRecord>>asList(Keys.KEY_COUNTRY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Country as(String alias) {
        return new Country(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Country as(Name alias) {
        return new Country(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Country rename(String name) {
        return new Country(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Country rename(Name name) {
        return new Country(name, null);
    }
}
