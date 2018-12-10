/*
 * This file is generated by jOOQ.
 */
package jooq.sys.routines;


import javax.annotation.Generated;

import jooq.sys.Sys;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.types.UByte;


/**
 * 
 *  Description
 *  
 *  Returns the major version of MySQL Server.
 *  
 *  Returns
 *  
 *  TINYINT UNSIGNED
 *  
 *  Example
 *  
 *  mysql&gt; SELECT VERSION(), sys.version_major();
 *  +--------------------------------------+---------------------+
 *  | VERSION()                            | sys.version_major() |
 *  +--------------------------------------+---------------------+
 *  | 5.7.9-enterprise-commercial-advanced | 5                   |
 *  +--------------------------------------+---------------------+
 *  1 row in set (0.00 sec)
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
public class VersionMajor extends AbstractRoutine<UByte> {

    private static final long serialVersionUID = -840607473;

    /**
     * The parameter <code>sys.version_major.RETURN_VALUE</code>.
     */
    public static final Parameter<UByte> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.TINYINTUNSIGNED, false, false);

    /**
     * Create a new routine call instance
     */
    public VersionMajor() {
        super("version_major", Sys.SYS, org.jooq.impl.SQLDataType.TINYINTUNSIGNED);

        setReturnParameter(RETURN_VALUE);
    }
}
