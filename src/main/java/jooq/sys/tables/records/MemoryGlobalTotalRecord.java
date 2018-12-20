/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables.records;


import javax.annotation.Generated;

import jooq.sys.tables.MemoryGlobalTotal;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.TableRecordImpl;


/**
 * VIEW
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MemoryGlobalTotalRecord extends TableRecordImpl<MemoryGlobalTotalRecord> implements Record1<String> {

    private static final long serialVersionUID = -1427253371;

    /**
     * Setter for <code>sys.memory_global_total.total_allocated</code>.
     */
    public void setTotalAllocated(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>sys.memory_global_total.total_allocated</code>.
     */
    public String getTotalAllocated() {
        return (String) get(0);
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return MemoryGlobalTotal.MEMORY_GLOBAL_TOTAL.TOTAL_ALLOCATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getTotalAllocated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getTotalAllocated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemoryGlobalTotalRecord value1(String value) {
        setTotalAllocated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemoryGlobalTotalRecord values(String value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MemoryGlobalTotalRecord
     */
    public MemoryGlobalTotalRecord() {
        super(MemoryGlobalTotal.MEMORY_GLOBAL_TOTAL);
    }

    /**
     * Create a detached, initialised MemoryGlobalTotalRecord
     */
    public MemoryGlobalTotalRecord(String totalAllocated) {
        super(MemoryGlobalTotal.MEMORY_GLOBAL_TOTAL);

        set(0, totalAllocated);
    }
}
