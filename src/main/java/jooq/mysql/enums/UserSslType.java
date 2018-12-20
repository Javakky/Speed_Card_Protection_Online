/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.enums;


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
public enum UserSslType implements EnumType {

    _(""),

    ANY("ANY"),

    X509("X509"),

    SPECIFIED("SPECIFIED");

    private final String literal;

    private UserSslType(String literal) {
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
        return "user_ssl_type";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLiteral() {
        return literal;
    }
}
