/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import jooq.performance_schema.tables.MetadataLocks;
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
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MetadataLocksRecord extends TableRecordImpl<MetadataLocksRecord> implements Record10<String, String, String, ULong, String, String, String, String, ULong, ULong> {

    private static final long serialVersionUID = -623737022;

    /**
     * Setter for <code>performance_schema.metadata_locks.OBJECT_TYPE</code>.
     */
    public void setObjectType(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.OBJECT_TYPE</code>.
     */
    public String getObjectType() {
        return (String) get(0);
    }

    /**
     * Setter for <code>performance_schema.metadata_locks.OBJECT_SCHEMA</code>.
     */
    public void setObjectSchema(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.OBJECT_SCHEMA</code>.
     */
    public String getObjectSchema() {
        return (String) get(1);
    }

    /**
     * Setter for <code>performance_schema.metadata_locks.OBJECT_NAME</code>.
     */
    public void setObjectName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.OBJECT_NAME</code>.
     */
    public String getObjectName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>performance_schema.metadata_locks.OBJECT_INSTANCE_BEGIN</code>.
     */
    public void setObjectInstanceBegin(ULong value) {
        set(3, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.OBJECT_INSTANCE_BEGIN</code>.
     */
    public ULong getObjectInstanceBegin() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>performance_schema.metadata_locks.LOCK_TYPE</code>.
     */
    public void setLockType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.LOCK_TYPE</code>.
     */
    public String getLockType() {
        return (String) get(4);
    }

    /**
     * Setter for <code>performance_schema.metadata_locks.LOCK_DURATION</code>.
     */
    public void setLockDuration(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.LOCK_DURATION</code>.
     */
    public String getLockDuration() {
        return (String) get(5);
    }

    /**
     * Setter for <code>performance_schema.metadata_locks.LOCK_STATUS</code>.
     */
    public void setLockStatus(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.LOCK_STATUS</code>.
     */
    public String getLockStatus() {
        return (String) get(6);
    }

    /**
     * Setter for <code>performance_schema.metadata_locks.SOURCE</code>.
     */
    public void setSource(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.SOURCE</code>.
     */
    public String getSource() {
        return (String) get(7);
    }

    /**
     * Setter for <code>performance_schema.metadata_locks.OWNER_THREAD_ID</code>.
     */
    public void setOwnerThreadId(ULong value) {
        set(8, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.OWNER_THREAD_ID</code>.
     */
    public ULong getOwnerThreadId() {
        return (ULong) get(8);
    }

    /**
     * Setter for <code>performance_schema.metadata_locks.OWNER_EVENT_ID</code>.
     */
    public void setOwnerEventId(ULong value) {
        set(9, value);
    }

    /**
     * Getter for <code>performance_schema.metadata_locks.OWNER_EVENT_ID</code>.
     */
    public ULong getOwnerEventId() {
        return (ULong) get(9);
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<String, String, String, ULong, String, String, String, String, ULong, ULong> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<String, String, String, ULong, String, String, String, String, ULong, ULong> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return MetadataLocks.METADATA_LOCKS.OBJECT_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return MetadataLocks.METADATA_LOCKS.OBJECT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return MetadataLocks.METADATA_LOCKS.OBJECT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field4() {
        return MetadataLocks.METADATA_LOCKS.OBJECT_INSTANCE_BEGIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return MetadataLocks.METADATA_LOCKS.LOCK_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return MetadataLocks.METADATA_LOCKS.LOCK_DURATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return MetadataLocks.METADATA_LOCKS.LOCK_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return MetadataLocks.METADATA_LOCKS.SOURCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field9() {
        return MetadataLocks.METADATA_LOCKS.OWNER_THREAD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field10() {
        return MetadataLocks.METADATA_LOCKS.OWNER_EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getObjectType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getObjectSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getObjectName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component4() {
        return getObjectInstanceBegin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getLockType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getLockDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getLockStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getSource();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component9() {
        return getOwnerThreadId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component10() {
        return getOwnerEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getObjectType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getObjectSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getObjectName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value4() {
        return getObjectInstanceBegin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getLockType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getLockDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getLockStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getSource();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value9() {
        return getOwnerThreadId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value10() {
        return getOwnerEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value1(String value) {
        setObjectType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value2(String value) {
        setObjectSchema(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value3(String value) {
        setObjectName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value4(ULong value) {
        setObjectInstanceBegin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value5(String value) {
        setLockType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value6(String value) {
        setLockDuration(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value7(String value) {
        setLockStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value8(String value) {
        setSource(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value9(ULong value) {
        setOwnerThreadId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord value10(ULong value) {
        setOwnerEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocksRecord values(String value1, String value2, String value3, ULong value4, String value5, String value6, String value7, String value8, ULong value9, ULong value10) {
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

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MetadataLocksRecord
     */
    public MetadataLocksRecord() {
        super(MetadataLocks.METADATA_LOCKS);
    }

    /**
     * Create a detached, initialised MetadataLocksRecord
     */
    public MetadataLocksRecord(String objectType, String objectSchema, String objectName, ULong objectInstanceBegin, String lockType, String lockDuration, String lockStatus, String source, ULong ownerThreadId, ULong ownerEventId) {
        super(MetadataLocks.METADATA_LOCKS);

        set(0, objectType);
        set(1, objectSchema);
        set(2, objectName);
        set(3, objectInstanceBegin);
        set(4, lockType);
        set(5, lockDuration);
        set(6, lockStatus);
        set(7, source);
        set(8, ownerThreadId);
        set(9, ownerEventId);
    }
}
