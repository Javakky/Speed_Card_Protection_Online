/*
 * This file is generated by jOOQ.
 */
package jooq.sys.routines;


import jooq.sys.Sys;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;

import javax.annotation.Generated;


/**
 * Description
 * <p>
 * Disables consumers within Performance Schema
 * matching the input pattern.
 * <p>
 * Parameters
 * <p>
 * consumer (VARCHAR(128)):
 * A LIKE pattern match (using "%consumer%") of consumers to disable
 * <p>
 * Example
 * <p>
 * To disable all consumers:
 * <p>
 * mysql&gt; CALL sys.ps_setup_disable_consumer('');
 * +--------------------------+
 * | summary                  |
 * +--------------------------+
 * | Disabled 15 consumers    |
 * +--------------------------+
 * 1 row in set (0.02 sec)
 * <p>
 * To disable just the event_stage consumers:
 * <p>
 * mysql&gt; CALL sys.ps_setup_disable_comsumers('stage');
 * +------------------------+
 * | summary                |
 * +------------------------+
 * | Disabled 3 consumers   |
 * +------------------------+
 * 1 row in set (0.00 sec)
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class PsSetupDisableConsumer extends AbstractRoutine<java.lang.Void> {

    /**
     * The parameter <code>sys.ps_setup_disable_consumer.consumer</code>.
     */
    public static final Parameter<String> CONSUMER = createParameter("consumer", org.jooq.impl.SQLDataType.VARCHAR(128), false, false);
    private static final long serialVersionUID = -904119842;

    /**
     * Create a new routine call instance
     */
    public PsSetupDisableConsumer() {
        super("ps_setup_disable_consumer", Sys.SYS);

        addInParameter(CONSUMER);
    }

    /**
     * Set the <code>consumer</code> parameter IN value to the routine
     */
    public void setConsumer(String value) {
        setValue(CONSUMER, value);
    }
}
