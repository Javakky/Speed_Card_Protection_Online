/*
 * This file is generated by jOOQ.
 */
package jooq.sys.routines;


import jooq.sys.Sys;
import org.jooq.impl.AbstractRoutine;

import javax.annotation.Generated;


/**
 * 
 *  Description
 *  
 *  Shows all currently enabled instruments.
 *  
 *  Parameters
 *  
 *  None
 *  
 *  Example
 *  
 *  mysql&gt; CALL sys.ps_setup_show_enabled_instruments();
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
public class PsSetupShowEnabledInstruments extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = -1389739406;

    /**
     * Create a new routine call instance
     */
    public PsSetupShowEnabledInstruments() {
        super("ps_setup_show_enabled_instruments", Sys.SYS);
    }
}
