/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables.records;


import jooq.information_schema.tables.InnodbLocks;
import org.jooq.Field;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.ULong;

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
public class InnodbLocksRecord extends TableRecordImpl<InnodbLocksRecord> implements Record10<String, String, String, String, String, String, ULong, ULong, ULong, String> {

    private static final long serialVersionUID = 401901852;

    /**
     * Create a detached InnodbLocksRecord
     */
    public InnodbLocksRecord() {
        super(InnodbLocks.INNODB_LOCKS);
    }

    /**
     * Create a detached, initialised InnodbLocksRecord
     */
    public InnodbLocksRecord(String lockId, String lockTrxId, String lockMode, String lockType, String lockTable, String lockIndex, ULong lockSpace, ULong lockPage, ULong lockRec, String lockData) {
        super(InnodbLocks.INNODB_LOCKS);

        set(0, lockId);
        set(1, lockTrxId);
        set(2, lockMode);
        set(3, lockType);
        set(4, lockTable);
        set(5, lockIndex);
        set(6, lockSpace);
        set(7, lockPage);
        set(8, lockRec);
        set(9, lockData);
    }

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_id</code>.
     */
    public String getLockId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_id</code>.
     */
    public void setLockId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_trx_id</code>.
     */
    public String getLockTrxId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_trx_id</code>.
     */
    public void setLockTrxId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_mode</code>.
     */
    public String getLockMode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_mode</code>.
     */
    public void setLockMode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_type</code>.
     */
    public String getLockType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_type</code>.
     */
    public void setLockType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_table</code>.
     */
    public String getLockTable() {
        return (String) get(4);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_table</code>.
     */
    public void setLockTable(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_index</code>.
     */
    public String getLockIndex() {
        return (String) get(5);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_index</code>.
     */
    public void setLockIndex(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_space</code>.
     */
    public ULong getLockSpace() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_space</code>.
     */
    public void setLockSpace(ULong value) {
        set(6, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_page</code>.
     */
    public ULong getLockPage() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_page</code>.
     */
    public void setLockPage(ULong value) {
        set(7, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_rec</code>.
     */
    public ULong getLockRec() {
        return (ULong) get(8);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_rec</code>.
     */
    public void setLockRec(ULong value) {
        set(8, value);
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>information_schema.INNODB_LOCKS.lock_data</code>.
     */
    public String getLockData() {
        return (String) get(9);
    }

    /**
     * Setter for <code>information_schema.INNODB_LOCKS.lock_data</code>.
     */
    public void setLockData(String value) {
        set(9, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<String, String, String, String, String, String, ULong, ULong, ULong, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<String, String, String, String, String, String, ULong, ULong, ULong, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return InnodbLocks.INNODB_LOCKS.LOCK_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return InnodbLocks.INNODB_LOCKS.LOCK_TRX_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return InnodbLocks.INNODB_LOCKS.LOCK_MODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return InnodbLocks.INNODB_LOCKS.LOCK_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return InnodbLocks.INNODB_LOCKS.LOCK_TABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return InnodbLocks.INNODB_LOCKS.LOCK_INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field7() {
        return InnodbLocks.INNODB_LOCKS.LOCK_SPACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field8() {
        return InnodbLocks.INNODB_LOCKS.LOCK_PAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field9() {
        return InnodbLocks.INNODB_LOCKS.LOCK_REC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return InnodbLocks.INNODB_LOCKS.LOCK_DATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getLockId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getLockTrxId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getLockMode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getLockType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getLockTable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getLockIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component7() {
        return getLockSpace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component8() {
        return getLockPage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component9() {
        return getLockRec();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getLockData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getLockId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getLockTrxId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getLockMode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getLockType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getLockTable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getLockIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value7() {
        return getLockSpace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value8() {
        return getLockPage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value9() {
        return getLockRec();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getLockData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value1(String value) {
        setLockId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value2(String value) {
        setLockTrxId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value3(String value) {
        setLockMode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value4(String value) {
        setLockType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value5(String value) {
        setLockTable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value6(String value) {
        setLockIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value7(ULong value) {
        setLockSpace(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value8(ULong value) {
        setLockPage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value9(ULong value) {
        setLockRec(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord value10(String value) {
        setLockData(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbLocksRecord values(String value1, String value2, String value3, String value4, String value5, String value6, ULong value7, ULong value8, ULong value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }
}
