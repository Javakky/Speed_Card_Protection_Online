/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables.records;


import javax.annotation.Generated;

import jooq.mysql.tables.HelpTopic;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;
import org.jooq.types.UShort;


/**
 * help topics
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HelpTopicRecord extends UpdatableRecordImpl<HelpTopicRecord> implements Record6<UInteger, String, UShort, String, String, String> {

    private static final long serialVersionUID = 271028559;

    /**
     * Setter for <code>mysql.help_topic.help_topic_id</code>.
     */
    public void setHelpTopicId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>mysql.help_topic.help_topic_id</code>.
     */
    public UInteger getHelpTopicId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>mysql.help_topic.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>mysql.help_topic.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>mysql.help_topic.help_category_id</code>.
     */
    public void setHelpCategoryId(UShort value) {
        set(2, value);
    }

    /**
     * Getter for <code>mysql.help_topic.help_category_id</code>.
     */
    public UShort getHelpCategoryId() {
        return (UShort) get(2);
    }

    /**
     * Setter for <code>mysql.help_topic.description</code>.
     */
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>mysql.help_topic.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>mysql.help_topic.example</code>.
     */
    public void setExample(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>mysql.help_topic.example</code>.
     */
    public String getExample() {
        return (String) get(4);
    }

    /**
     * Setter for <code>mysql.help_topic.url</code>.
     */
    public void setUrl(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>mysql.help_topic.url</code>.
     */
    public String getUrl() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<UInteger, String, UShort, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<UInteger, String, UShort, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return HelpTopic.HELP_TOPIC.HELP_TOPIC_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return HelpTopic.HELP_TOPIC.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UShort> field3() {
        return HelpTopic.HELP_TOPIC.HELP_CATEGORY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return HelpTopic.HELP_TOPIC.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return HelpTopic.HELP_TOPIC.EXAMPLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return HelpTopic.HELP_TOPIC.URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getHelpTopicId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UShort component3() {
        return getHelpCategoryId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getExample();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getHelpTopicId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UShort value3() {
        return getHelpCategoryId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getExample();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HelpTopicRecord value1(UInteger value) {
        setHelpTopicId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HelpTopicRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HelpTopicRecord value3(UShort value) {
        setHelpCategoryId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HelpTopicRecord value4(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HelpTopicRecord value5(String value) {
        setExample(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HelpTopicRecord value6(String value) {
        setUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HelpTopicRecord values(UInteger value1, String value2, UShort value3, String value4, String value5, String value6) {
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
     * Create a detached HelpTopicRecord
     */
    public HelpTopicRecord() {
        super(HelpTopic.HELP_TOPIC);
    }

    /**
     * Create a detached, initialised HelpTopicRecord
     */
    public HelpTopicRecord(UInteger helpTopicId, String name, UShort helpCategoryId, String description, String example, String url) {
        super(HelpTopic.HELP_TOPIC);

        set(0, helpTopicId);
        set(1, name);
        set(2, helpCategoryId);
        set(3, description);
        set(4, example);
        set(5, url);
    }
}
