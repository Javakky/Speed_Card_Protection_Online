/*
 * This file is generated by jOOQ.
 */
package jooq.sakila.tables.records;


import jooq.sakila.tables.Staff;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UByte;
import org.jooq.types.UShort;

import javax.annotation.Generated;
import java.sql.Timestamp;


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
public class StaffRecord extends UpdatableRecordImpl<StaffRecord> implements Record11<UByte, String, String, UShort, byte[], String, UByte, Byte, String, String, Timestamp> {

    private static final long serialVersionUID = 941576488;

    /**
     * Setter for <code>sakila.staff.staff_id</code>.
     */
    public void setStaffId(UByte value) {
        set(0, value);
    }

    /**
     * Getter for <code>sakila.staff.staff_id</code>.
     */
    public UByte getStaffId() {
        return (UByte) get(0);
    }

    /**
     * Setter for <code>sakila.staff.first_name</code>.
     */
    public void setFirstName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sakila.staff.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sakila.staff.last_name</code>.
     */
    public void setLastName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>sakila.staff.last_name</code>.
     */
    public String getLastName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sakila.staff.address_id</code>.
     */
    public void setAddressId(UShort value) {
        set(3, value);
    }

    /**
     * Getter for <code>sakila.staff.address_id</code>.
     */
    public UShort getAddressId() {
        return (UShort) get(3);
    }

    /**
     * Setter for <code>sakila.staff.picture</code>.
     */
    public void setPicture(byte... value) {
        set(4, value);
    }

    /**
     * Getter for <code>sakila.staff.picture</code>.
     */
    public byte[] getPicture() {
        return (byte[]) get(4);
    }

    /**
     * Setter for <code>sakila.staff.email</code>.
     */
    public void setEmail(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>sakila.staff.email</code>.
     */
    public String getEmail() {
        return (String) get(5);
    }

    /**
     * Setter for <code>sakila.staff.store_id</code>.
     */
    public void setStoreId(UByte value) {
        set(6, value);
    }

    /**
     * Getter for <code>sakila.staff.store_id</code>.
     */
    public UByte getStoreId() {
        return (UByte) get(6);
    }

    /**
     * Setter for <code>sakila.staff.active</code>.
     */
    public void setActive(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>sakila.staff.active</code>.
     */
    public Byte getActive() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>sakila.staff.username</code>.
     */
    public void setUsername(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>sakila.staff.username</code>.
     */
    public String getUsername() {
        return (String) get(8);
    }

    /**
     * Setter for <code>sakila.staff.password</code>.
     */
    public void setPassword(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>sakila.staff.password</code>.
     */
    public String getPassword() {
        return (String) get(9);
    }

    /**
     * Setter for <code>sakila.staff.last_update</code>.
     */
    public void setLastUpdate(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>sakila.staff.last_update</code>.
     */
    public Timestamp getLastUpdate() {
        return (Timestamp) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UByte> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<UByte, String, String, UShort, byte[], String, UByte, Byte, String, String, Timestamp> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<UByte, String, String, UShort, byte[], String, UByte, Byte, String, String, Timestamp> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UByte> field1() {
        return Staff.STAFF.STAFF_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Staff.STAFF.FIRST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Staff.STAFF.LAST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UShort> field4() {
        return Staff.STAFF.ADDRESS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field5() {
        return Staff.STAFF.PICTURE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Staff.STAFF.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UByte> field7() {
        return Staff.STAFF.STORE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field8() {
        return Staff.STAFF.ACTIVE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Staff.STAFF.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Staff.STAFF.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return Staff.STAFF.LAST_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte component1() {
        return getStaffId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UShort component4() {
        return getAddressId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component5() {
        return getPicture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte component7() {
        return getStoreId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component8() {
        return getActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component11() {
        return getLastUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte value1() {
        return getStaffId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UShort value4() {
        return getAddressId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value5() {
        return getPicture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte value7() {
        return getStoreId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value8() {
        return getActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getLastUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value1(UByte value) {
        setStaffId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value2(String value) {
        setFirstName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value3(String value) {
        setLastName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value4(UShort value) {
        setAddressId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value5(byte... value) {
        setPicture(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value6(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value7(UByte value) {
        setStoreId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value8(Byte value) {
        setActive(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value9(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value10(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord value11(Timestamp value) {
        setLastUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StaffRecord values(UByte value1, String value2, String value3, UShort value4, byte[] value5, String value6, UByte value7, Byte value8, String value9, String value10, Timestamp value11) {
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
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StaffRecord
     */
    public StaffRecord() {
        super(Staff.STAFF);
    }

    /**
     * Create a detached, initialised StaffRecord
     */
    public StaffRecord(UByte staffId, String firstName, String lastName, UShort addressId, byte[] picture, String email, UByte storeId, Byte active, String username, String password, Timestamp lastUpdate) {
        super(Staff.STAFF);

        set(0, staffId);
        set(1, firstName);
        set(2, lastName);
        set(3, addressId);
        set(4, picture);
        set(5, email);
        set(6, storeId);
        set(7, active);
        set(8, username);
        set(9, password);
        set(10, lastUpdate);
    }
}
