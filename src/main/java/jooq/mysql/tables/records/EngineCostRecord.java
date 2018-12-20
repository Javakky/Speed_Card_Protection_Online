/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables.records;


import jooq.mysql.tables.EngineCost;
import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


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
public class EngineCostRecord extends UpdatableRecordImpl<EngineCostRecord> implements Record6<String, Integer, String, Double, Timestamp, String> {

    private static final long serialVersionUID = -1592120531;

    /**
     * Create a detached EngineCostRecord
     */
    public EngineCostRecord() {
        super(EngineCost.ENGINE_COST);
    }

    /**
     * Create a detached, initialised EngineCostRecord
     */
    public EngineCostRecord(String engineName, Integer deviceType, String costName, Double costValue, Timestamp lastUpdate, String comment) {
        super(EngineCost.ENGINE_COST);

        set(0, engineName);
        set(1, deviceType);
        set(2, costName);
        set(3, costValue);
        set(4, lastUpdate);
        set(5, comment);
    }

    /**
     * Getter for <code>mysql.engine_cost.engine_name</code>.
     */
    public String getEngineName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>mysql.engine_cost.engine_name</code>.
     */
    public void setEngineName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>mysql.engine_cost.device_type</code>.
     */
    public Integer getDeviceType() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>mysql.engine_cost.device_type</code>.
     */
    public void setDeviceType(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>mysql.engine_cost.cost_name</code>.
     */
    public String getCostName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>mysql.engine_cost.cost_name</code>.
     */
    public void setCostName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>mysql.engine_cost.cost_value</code>.
     */
    public Double getCostValue() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>mysql.engine_cost.cost_value</code>.
     */
    public void setCostValue(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>mysql.engine_cost.last_update</code>.
     */
    public Timestamp getLastUpdate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>mysql.engine_cost.last_update</code>.
     */
    public void setLastUpdate(Timestamp value) {
        set(4, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>mysql.engine_cost.comment</code>.
     */
    public String getComment() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>mysql.engine_cost.comment</code>.
     */
    public void setComment(String value) {
        set(5, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record3<String, String, Integer> key() {
        return (Record3) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, Integer, String, Double, Timestamp, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, Integer, String, Double, Timestamp, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return EngineCost.ENGINE_COST.ENGINE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return EngineCost.ENGINE_COST.DEVICE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return EngineCost.ENGINE_COST.COST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field4() {
        return EngineCost.ENGINE_COST.COST_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return EngineCost.ENGINE_COST.LAST_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return EngineCost.ENGINE_COST.COMMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getEngineName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getDeviceType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getCostName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component4() {
        return getCostValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getLastUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getEngineName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getDeviceType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCostName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value4() {
        return getCostValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getLastUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EngineCostRecord value1(String value) {
        setEngineName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EngineCostRecord value2(Integer value) {
        setDeviceType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EngineCostRecord value3(String value) {
        setCostName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EngineCostRecord value4(Double value) {
        setCostValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EngineCostRecord value5(Timestamp value) {
        setLastUpdate(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EngineCostRecord value6(String value) {
        setComment(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EngineCostRecord values(String value1, Integer value2, String value3, Double value4, Timestamp value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }
}
