/*
 * This file is generated by jOOQ.
 */
package jooq.sys.routines;


import jooq.sys.Sys;
import org.jooq.impl.AbstractRoutine;

import javax.annotation.Generated;


/**
 * Description
 * <p>
 * Shows all currently enabled consumers.
 * <p>
 * Parameters
 * <p>
 * None
 * <p>
 * Example
 * <p>
 * mysql&gt; CALL sys.ps_setup_show_enabled_consumers();
 * <p>
 * +---------------------------+
 * | enabled_consumers         |
 * +---------------------------+
 * | events_statements_current |
 * | global_instrumentation    |
 * | thread_instrumentation    |
 * | statements_digest         |
 * +---------------------------+
 * 4 rows in set (0.05 sec)
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class PsSetupShowEnabledConsumers extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 1894374365;

    /**
     * Create a new routine call instance
     */
    public PsSetupShowEnabledConsumers() {
        super("ps_setup_show_enabled_consumers", Sys.SYS);
    }
}
