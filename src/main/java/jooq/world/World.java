/*
 * This file is generated by jOOQ.
 */
package jooq.world;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooq.DefaultCatalog;
import jooq.world.tables.City;
import jooq.world.tables.Country;
import jooq.world.tables.Countrylanguage;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class World extends SchemaImpl {

    private static final long serialVersionUID = -1628371203;

    /**
     * The reference instance of <code>world</code>
     */
    public static final World WORLD = new World();

    /**
     * The table <code>world.city</code>.
     */
    public final City CITY = jooq.world.tables.City.CITY;

    /**
     * The table <code>world.country</code>.
     */
    public final Country COUNTRY = jooq.world.tables.Country.COUNTRY;

    /**
     * The table <code>world.countrylanguage</code>.
     */
    public final Countrylanguage COUNTRYLANGUAGE = jooq.world.tables.Countrylanguage.COUNTRYLANGUAGE;

    /**
     * No further instances allowed
     */
    private World() {
        super("world", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            City.CITY,
            Country.COUNTRY,
            Countrylanguage.COUNTRYLANGUAGE);
    }
}
