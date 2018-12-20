/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;

import javax.annotation.Generated;


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
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public enum ReplicationConnectionConfigurationSslAllowed implements EnumType {

    YES("YES"),

    NO("NO"),

    IGNORED("IGNORED");

    private final String literal;

    private ReplicationConnectionConfigurationSslAllowed(String literal) {
        this.literal = literal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "replication_connection_configuration_SSL_ALLOWED";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLiteral() {
        return literal;
    }
}
