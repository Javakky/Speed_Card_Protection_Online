/*
 * This file is generated by jOOQ.
 */
package jooq.sys.routines;


import javax.annotation.Generated;

import jooq.sys.Sys;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;


/**
 * 
 *  Description
 *  
 *  Truncates all summary tables within Performance Schema, 
 *  resetting all aggregated instrumentation as a snapshot.
 *  
 *  Parameters
 *  
 *  in_verbose (BOOLEAN):
 *  Whether to print each TRUNCATE statement before running
 *  
 *  Example
 *  
 *  mysql&gt; CALL sys.ps_truncate_all_tables(false);
 *  +---------------------+
 *  | summary             |
 *  +---------------------+
 *  | Truncated 44 tables |
 *  +---------------------+
 *  1 row in set (0.10 sec)
 *  
 *  Query OK, 0 rows affected (0.10 sec)
 *  
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PsTruncateAllTables extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 1407451158;

    /**
     * The parameter <code>sys.ps_truncate_all_tables.in_verbose</code>.
     */
    public static final Parameter<Byte> IN_VERBOSE = createParameter("in_verbose", org.jooq.impl.SQLDataType.TINYINT, false, false);

    /**
     * Create a new routine call instance
     */
    public PsTruncateAllTables() {
        super("ps_truncate_all_tables", Sys.SYS);

        addInParameter(IN_VERBOSE);
    }

    /**
     * Set the <code>in_verbose</code> parameter IN value to the routine
     */
    public void setInVerbose(Byte value) {
        setValue(IN_VERBOSE, value);
    }
}
