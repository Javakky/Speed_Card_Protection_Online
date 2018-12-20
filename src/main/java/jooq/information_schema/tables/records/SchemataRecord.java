/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables.records;


import jooq.information_schema.tables.Schemata;
import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;

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
public class SchemataRecord extends TableRecordImpl<SchemataRecord> implements Record5<String, String, String, String, String> {

    private static final long serialVersionUID = 450726968;

    /**
     * Create a detached SchemataRecord
     */
    public SchemataRecord() {
        super(Schemata.SCHEMATA);
    }

    /**
     * Create a detached, initialised SchemataRecord
     */
    public SchemataRecord(String catalogName, String schemaName, String defaultCharacterSetName, String defaultCollationName, String sqlPath) {
        super(Schemata.SCHEMATA);

        set(0, catalogName);
        set(1, schemaName);
        set(2, defaultCharacterSetName);
        set(3, defaultCollationName);
        set(4, sqlPath);
    }

    /**
     * Getter for <code>information_schema.SCHEMATA.CATALOG_NAME</code>.
     */
    public String getCatalogName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.SCHEMATA.CATALOG_NAME</code>.
     */
    public void setCatalogName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.SCHEMATA.SCHEMA_NAME</code>.
     */
    public String getSchemaName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.SCHEMATA.SCHEMA_NAME</code>.
     */
    public void setSchemaName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.SCHEMATA.DEFAULT_CHARACTER_SET_NAME</code>.
     */
    public String getDefaultCharacterSetName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>information_schema.SCHEMATA.DEFAULT_CHARACTER_SET_NAME</code>.
     */
    public void setDefaultCharacterSetName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.SCHEMATA.DEFAULT_COLLATION_NAME</code>.
     */
    public String getDefaultCollationName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>information_schema.SCHEMATA.DEFAULT_COLLATION_NAME</code>.
     */
    public void setDefaultCollationName(String value) {
        set(3, value);
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>information_schema.SCHEMATA.SQL_PATH</code>.
     */
    public String getSqlPath() {
        return (String) get(4);
    }

    /**
     * Setter for <code>information_schema.SCHEMATA.SQL_PATH</code>.
     */
    public void setSqlPath(String value) {
        set(4, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Schemata.SCHEMATA.CATALOG_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Schemata.SCHEMATA.SCHEMA_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Schemata.SCHEMATA.DEFAULT_CHARACTER_SET_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Schemata.SCHEMATA.DEFAULT_COLLATION_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Schemata.SCHEMATA.SQL_PATH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getCatalogName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getSchemaName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDefaultCharacterSetName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDefaultCollationName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getSqlPath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getCatalogName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSchemaName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDefaultCharacterSetName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDefaultCollationName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getSqlPath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SchemataRecord value1(String value) {
        setCatalogName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SchemataRecord value2(String value) {
        setSchemaName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SchemataRecord value3(String value) {
        setDefaultCharacterSetName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SchemataRecord value4(String value) {
        setDefaultCollationName(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public SchemataRecord value5(String value) {
        setSqlPath(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SchemataRecord values(String value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }
}
