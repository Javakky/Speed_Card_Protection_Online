/*
 * This file is generated by jOOQ.
 */
package jooq.sys.routines;


import jooq.sys.Sys;
import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;

import javax.annotation.Generated;


/**
 * 
 *  Description
 *  
 *  Takes a raw path value, and strips out the datadir or tmpdir
 *  replacing with @@datadir and @@tmpdir respectively. 
 *  
 *  Also normalizes the paths across operating systems, so backslashes
 *  on Windows are converted to forward slashes
 *  
 *  Parameters
 *  
 *  path (VARCHAR(512)):
 *  The raw file path value to format.
 *  
 *  Returns
 *  
 *  VARCHAR(512) CHARSET UTF8
 *  
 *  Example
 *  
 *  mysql&gt; select @@datadir;
 *  +-----------------------------------------------+
 *  | @@datadir                                     |
 *  +-----------------------------------------------+
 *  | /Users/mark/sandboxes/SmallTree/AMaster/data/ |
 *  +-----------------------------------------------+
 *  1 row in set (0.06 sec)
 *  
 *  mysql&gt; select format_path('/Users/mark/sandboxes/SmallTree/AMaster/data/mysql/proc.MYD') 
 * AS path;
 *  +--------------------------+
 *  | path                     |
 *  +--------------------------+
 *  | @@datadir/mysql/proc.MYD |
 *  +--------------------------+
 *  1 row in set (0.03 sec)
 *  
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FormatPath extends AbstractRoutine<String> {

    private static final long serialVersionUID = -1122273956;

    /**
     * The parameter <code>sys.format_path.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.VARCHAR(512), false, false);

    /**
     * The parameter <code>sys.format_path.in_path</code>.
     */
    public static final Parameter<String> IN_PATH = Internal.createParameter("in_path", org.jooq.impl.SQLDataType.VARCHAR(512), false, false);

    /**
     * Create a new routine call instance
     */
    public FormatPath() {
        super("format_path", Sys.SYS, org.jooq.impl.SQLDataType.VARCHAR(512));

        setReturnParameter(RETURN_VALUE);
        addInParameter(IN_PATH);
    }

    /**
     * Set the <code>in_path</code> parameter IN value to the routine
     */
    public void setInPath(String value) {
        setValue(IN_PATH, value);
    }

    /**
     * Set the <code>in_path</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setInPath(Field<String> field) {
        setField(IN_PATH, field);
    }
}
