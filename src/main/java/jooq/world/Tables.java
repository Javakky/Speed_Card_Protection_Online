/*
 * This file is generated by jOOQ.
 */
package jooq.world;


import jooq.world.tables.City;
import jooq.world.tables.Country;
import jooq.world.tables.Countrylanguage;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in world
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>world.city</code>.
     */
    public static final City CITY = jooq.world.tables.City.CITY;

    /**
     * The table <code>world.country</code>.
     */
    public static final Country COUNTRY = jooq.world.tables.Country.COUNTRY;

    /**
     * The table <code>world.countrylanguage</code>.
     */
    public static final Countrylanguage COUNTRYLANGUAGE = jooq.world.tables.Countrylanguage.COUNTRYLANGUAGE;
}
