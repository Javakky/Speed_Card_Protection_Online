/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables.records;


import jooq.information_schema.tables.InnodbBufferPageLru;
import org.jooq.Field;
import org.jooq.Record20;
import org.jooq.Row20;
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
public class InnodbBufferPageLruRecord extends TableRecordImpl<InnodbBufferPageLruRecord> implements Record20<ULong, ULong, ULong, ULong, String, ULong, ULong, String, ULong, ULong, ULong, String, String, ULong, ULong, ULong, String, String, String, ULong> {

    private static final long serialVersionUID = 1242597681;

    /**
     * Create a detached InnodbBufferPageLruRecord
     */
    public InnodbBufferPageLruRecord() {
        super(InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU);
    }

    /**
     * Create a detached, initialised InnodbBufferPageLruRecord
     */
    public InnodbBufferPageLruRecord(ULong poolId, ULong lruPosition, ULong space, ULong pageNumber, String pageType, ULong flushType, ULong fixCount, String isHashed, ULong newestModification, ULong oldestModification, ULong accessTime, String tableName, String indexName, ULong numberRecords, ULong dataSize, ULong compressedSize, String compressed, String ioFix, String isOld, ULong freePageClock) {
        super(InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU);

        set(0, poolId);
        set(1, lruPosition);
        set(2, space);
        set(3, pageNumber);
        set(4, pageType);
        set(5, flushType);
        set(6, fixCount);
        set(7, isHashed);
        set(8, newestModification);
        set(9, oldestModification);
        set(10, accessTime);
        set(11, tableName);
        set(12, indexName);
        set(13, numberRecords);
        set(14, dataSize);
        set(15, compressedSize);
        set(16, compressed);
        set(17, ioFix);
        set(18, isOld);
        set(19, freePageClock);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.POOL_ID</code>.
     */
    public ULong getPoolId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.POOL_ID</code>.
     */
    public void setPoolId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.LRU_POSITION</code>.
     */
    public ULong getLruPosition() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.LRU_POSITION</code>.
     */
    public void setLruPosition(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.SPACE</code>.
     */
    public ULong getSpace() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.SPACE</code>.
     */
    public void setSpace(ULong value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.PAGE_NUMBER</code>.
     */
    public ULong getPageNumber() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.PAGE_NUMBER</code>.
     */
    public void setPageNumber(ULong value) {
        set(3, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.PAGE_TYPE</code>.
     */
    public String getPageType() {
        return (String) get(4);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.PAGE_TYPE</code>.
     */
    public void setPageType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.FLUSH_TYPE</code>.
     */
    public ULong getFlushType() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.FLUSH_TYPE</code>.
     */
    public void setFlushType(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.FIX_COUNT</code>.
     */
    public ULong getFixCount() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.FIX_COUNT</code>.
     */
    public void setFixCount(ULong value) {
        set(6, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.IS_HASHED</code>.
     */
    public String getIsHashed() {
        return (String) get(7);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.IS_HASHED</code>.
     */
    public void setIsHashed(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.NEWEST_MODIFICATION</code>.
     */
    public ULong getNewestModification() {
        return (ULong) get(8);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.NEWEST_MODIFICATION</code>.
     */
    public void setNewestModification(ULong value) {
        set(8, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.OLDEST_MODIFICATION</code>.
     */
    public ULong getOldestModification() {
        return (ULong) get(9);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.OLDEST_MODIFICATION</code>.
     */
    public void setOldestModification(ULong value) {
        set(9, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.ACCESS_TIME</code>.
     */
    public ULong getAccessTime() {
        return (ULong) get(10);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.ACCESS_TIME</code>.
     */
    public void setAccessTime(ULong value) {
        set(10, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.TABLE_NAME</code>.
     */
    public String getTableName() {
        return (String) get(11);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.TABLE_NAME</code>.
     */
    public void setTableName(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.INDEX_NAME</code>.
     */
    public String getIndexName() {
        return (String) get(12);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.INDEX_NAME</code>.
     */
    public void setIndexName(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.NUMBER_RECORDS</code>.
     */
    public ULong getNumberRecords() {
        return (ULong) get(13);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.NUMBER_RECORDS</code>.
     */
    public void setNumberRecords(ULong value) {
        set(13, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.DATA_SIZE</code>.
     */
    public ULong getDataSize() {
        return (ULong) get(14);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.DATA_SIZE</code>.
     */
    public void setDataSize(ULong value) {
        set(14, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.COMPRESSED_SIZE</code>.
     */
    public ULong getCompressedSize() {
        return (ULong) get(15);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.COMPRESSED_SIZE</code>.
     */
    public void setCompressedSize(ULong value) {
        set(15, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.COMPRESSED</code>.
     */
    public String getCompressed() {
        return (String) get(16);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.COMPRESSED</code>.
     */
    public void setCompressed(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.IO_FIX</code>.
     */
    public String getIoFix() {
        return (String) get(17);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.IO_FIX</code>.
     */
    public void setIoFix(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.IS_OLD</code>.
     */
    public String getIsOld() {
        return (String) get(18);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.IS_OLD</code>.
     */
    public void setIsOld(String value) {
        set(18, value);
    }

    // -------------------------------------------------------------------------
    // Record20 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.FREE_PAGE_CLOCK</code>.
     */
    public ULong getFreePageClock() {
        return (ULong) get(19);
    }

    /**
     * Setter for <code>information_schema.INNODB_BUFFER_PAGE_LRU.FREE_PAGE_CLOCK</code>.
     */
    public void setFreePageClock(ULong value) {
        set(19, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row20<ULong, ULong, ULong, ULong, String, ULong, ULong, String, ULong, ULong, ULong, String, String, ULong, ULong, ULong, String, String, String, ULong> fieldsRow() {
        return (Row20) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row20<ULong, ULong, ULong, ULong, String, ULong, ULong, String, ULong, ULong, ULong, String, String, ULong, ULong, ULong, String, String, String, ULong> valuesRow() {
        return (Row20) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.POOL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field2() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.LRU_POSITION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field3() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.SPACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field4() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.PAGE_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.PAGE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field6() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.FLUSH_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field7() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.FIX_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.IS_HASHED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field9() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.NEWEST_MODIFICATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field10() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.OLDEST_MODIFICATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field11() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.ACCESS_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.TABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.INDEX_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field14() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.NUMBER_RECORDS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field15() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.DATA_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field16() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.COMPRESSED_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field17() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.COMPRESSED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field18() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.IO_FIX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field19() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.IS_OLD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field20() {
        return InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU.FREE_PAGE_CLOCK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component1() {
        return getPoolId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component2() {
        return getLruPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component3() {
        return getSpace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component4() {
        return getPageNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getPageType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component6() {
        return getFlushType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component7() {
        return getFixCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getIsHashed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component9() {
        return getNewestModification();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component10() {
        return getOldestModification();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component11() {
        return getAccessTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getIndexName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component14() {
        return getNumberRecords();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component15() {
        return getDataSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component16() {
        return getCompressedSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component17() {
        return getCompressed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component18() {
        return getIoFix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component19() {
        return getIsOld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component20() {
        return getFreePageClock();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value1() {
        return getPoolId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value2() {
        return getLruPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value3() {
        return getSpace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value4() {
        return getPageNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPageType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value6() {
        return getFlushType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value7() {
        return getFixCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getIsHashed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value9() {
        return getNewestModification();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value10() {
        return getOldestModification();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value11() {
        return getAccessTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getIndexName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value14() {
        return getNumberRecords();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value15() {
        return getDataSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value16() {
        return getCompressedSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value17() {
        return getCompressed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value18() {
        return getIoFix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value19() {
        return getIsOld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value20() {
        return getFreePageClock();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value1(ULong value) {
        setPoolId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value2(ULong value) {
        setLruPosition(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value3(ULong value) {
        setSpace(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value4(ULong value) {
        setPageNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value5(String value) {
        setPageType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value6(ULong value) {
        setFlushType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value7(ULong value) {
        setFixCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value8(String value) {
        setIsHashed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value9(ULong value) {
        setNewestModification(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value10(ULong value) {
        setOldestModification(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value11(ULong value) {
        setAccessTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value12(String value) {
        setTableName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value13(String value) {
        setIndexName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value14(ULong value) {
        setNumberRecords(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value15(ULong value) {
        setDataSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value16(ULong value) {
        setCompressedSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value17(String value) {
        setCompressed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value18(String value) {
        setIoFix(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value19(String value) {
        setIsOld(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord value20(ULong value) {
        setFreePageClock(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPageLruRecord values(ULong value1, ULong value2, ULong value3, ULong value4, String value5, ULong value6, ULong value7, String value8, ULong value9, ULong value10, ULong value11, String value12, String value13, ULong value14, ULong value15, ULong value16, String value17, String value18, String value19, ULong value20) {
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
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        return this;
    }
}
