/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables.records;


import jooq.information_schema.tables.InnodbSysVirtual;
import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;

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
public class InnodbSysVirtualRecord extends TableRecordImpl<InnodbSysVirtualRecord> implements Record3<ULong, UInteger, UInteger> {

    private static final long serialVersionUID = 1839843821;

    /**
     * Setter for <code>information_schema.INNODB_SYS_VIRTUAL.TABLE_ID</code>.
     */
    public void setTableId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_SYS_VIRTUAL.TABLE_ID</code>.
     */
    public ULong getTableId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>information_schema.INNODB_SYS_VIRTUAL.POS</code>.
     */
    public void setPos(UInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_SYS_VIRTUAL.POS</code>.
     */
    public UInteger getPos() {
        return (UInteger) get(1);
    }

    /**
     * Setter for <code>information_schema.INNODB_SYS_VIRTUAL.BASE_POS</code>.
     */
    public void setBasePos(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_SYS_VIRTUAL.BASE_POS</code>.
     */
    public UInteger getBasePos() {
        return (UInteger) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<ULong, UInteger, UInteger> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<ULong, UInteger, UInteger> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return InnodbSysVirtual.INNODB_SYS_VIRTUAL.TABLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field2() {
        return InnodbSysVirtual.INNODB_SYS_VIRTUAL.POS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field3() {
        return InnodbSysVirtual.INNODB_SYS_VIRTUAL.BASE_POS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component1() {
        return getTableId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component2() {
        return getPos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component3() {
        return getBasePos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value1() {
        return getTableId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value2() {
        return getPos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value3() {
        return getBasePos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbSysVirtualRecord value1(ULong value) {
        setTableId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbSysVirtualRecord value2(UInteger value) {
        setPos(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbSysVirtualRecord value3(UInteger value) {
        setBasePos(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbSysVirtualRecord values(ULong value1, UInteger value2, UInteger value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InnodbSysVirtualRecord
     */
    public InnodbSysVirtualRecord() {
        super(InnodbSysVirtual.INNODB_SYS_VIRTUAL);
    }

    /**
     * Create a detached, initialised InnodbSysVirtualRecord
     */
    public InnodbSysVirtualRecord(ULong tableId, UInteger pos, UInteger basePos) {
        super(InnodbSysVirtual.INNODB_SYS_VIRTUAL);

        set(0, tableId);
        set(1, pos);
        set(2, basePos);
    }
}
