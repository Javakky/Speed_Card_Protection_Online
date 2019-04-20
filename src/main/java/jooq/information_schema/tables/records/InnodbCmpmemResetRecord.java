/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables.records;


import jooq.information_schema.tables.InnodbCmpmemReset;
import org.jooq.Field;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.TableRecordImpl;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InnodbCmpmemResetRecord extends TableRecordImpl<InnodbCmpmemResetRecord> implements Record6<Integer, Integer, Integer, Integer, Long, Integer> {

    private static final long serialVersionUID = -1858319005;

    /**
     * Setter for <code>information_schema.INNODB_CMPMEM_RESET.page_size</code>.
     */
    public void setPageSize(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_CMPMEM_RESET.page_size</code>.
     */
    public Integer getPageSize() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>information_schema.INNODB_CMPMEM_RESET.buffer_pool_instance</code>.
     */
    public void setBufferPoolInstance(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_CMPMEM_RESET.buffer_pool_instance</code>.
     */
    public Integer getBufferPoolInstance() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>information_schema.INNODB_CMPMEM_RESET.pages_used</code>.
     */
    public void setPagesUsed(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_CMPMEM_RESET.pages_used</code>.
     */
    public Integer getPagesUsed() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>information_schema.INNODB_CMPMEM_RESET.pages_free</code>.
     */
    public void setPagesFree(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_CMPMEM_RESET.pages_free</code>.
     */
    public Integer getPagesFree() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>information_schema.INNODB_CMPMEM_RESET.relocation_ops</code>.
     */
    public void setRelocationOps(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_CMPMEM_RESET.relocation_ops</code>.
     */
    public Long getRelocationOps() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>information_schema.INNODB_CMPMEM_RESET.relocation_time</code>.
     */
    public void setRelocationTime(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_CMPMEM_RESET.relocation_time</code>.
     */
    public Integer getRelocationTime() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, Integer, Integer, Long, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, Integer, Integer, Long, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return InnodbCmpmemReset.INNODB_CMPMEM_RESET.PAGE_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return InnodbCmpmemReset.INNODB_CMPMEM_RESET.BUFFER_POOL_INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return InnodbCmpmemReset.INNODB_CMPMEM_RESET.PAGES_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return InnodbCmpmemReset.INNODB_CMPMEM_RESET.PAGES_FREE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return InnodbCmpmemReset.INNODB_CMPMEM_RESET.RELOCATION_OPS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return InnodbCmpmemReset.INNODB_CMPMEM_RESET.RELOCATION_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getPageSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getBufferPoolInstance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getPagesUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getPagesFree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getRelocationOps();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getRelocationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getPageSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getBufferPoolInstance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getPagesUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getPagesFree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getRelocationOps();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getRelocationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbCmpmemResetRecord value1(Integer value) {
        setPageSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbCmpmemResetRecord value2(Integer value) {
        setBufferPoolInstance(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbCmpmemResetRecord value3(Integer value) {
        setPagesUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbCmpmemResetRecord value4(Integer value) {
        setPagesFree(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbCmpmemResetRecord value5(Long value) {
        setRelocationOps(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbCmpmemResetRecord value6(Integer value) {
        setRelocationTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbCmpmemResetRecord values(Integer value1, Integer value2, Integer value3, Integer value4, Long value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InnodbCmpmemResetRecord
     */
    public InnodbCmpmemResetRecord() {
        super(InnodbCmpmemReset.INNODB_CMPMEM_RESET);
    }

    /**
     * Create a detached, initialised InnodbCmpmemResetRecord
     */
    public InnodbCmpmemResetRecord(Integer pageSize, Integer bufferPoolInstance, Integer pagesUsed, Integer pagesFree, Long relocationOps, Integer relocationTime) {
        super(InnodbCmpmemReset.INNODB_CMPMEM_RESET);

        set(0, pageSize);
        set(1, bufferPoolInstance);
        set(2, pagesUsed);
        set(3, pagesFree);
        set(4, relocationOps);
        set(5, relocationTime);
    }
}
