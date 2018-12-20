/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables;


import jooq.information_schema.InformationSchema;
import jooq.information_schema.tables.records.InnodbBufferPoolStatsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
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
public class InnodbBufferPoolStats extends TableImpl<InnodbBufferPoolStatsRecord> {

    /**
     * The reference instance of <code>information_schema.INNODB_BUFFER_POOL_STATS</code>
     */
    public static final InnodbBufferPoolStats INNODB_BUFFER_POOL_STATS = new InnodbBufferPoolStats();
    private static final long serialVersionUID = 1466110188;
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.POOL_ID</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> POOL_ID = createField("POOL_ID", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.POOL_SIZE</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> POOL_SIZE = createField("POOL_SIZE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.FREE_BUFFERS</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> FREE_BUFFERS = createField("FREE_BUFFERS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.DATABASE_PAGES</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> DATABASE_PAGES = createField("DATABASE_PAGES", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.OLD_DATABASE_PAGES</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> OLD_DATABASE_PAGES = createField("OLD_DATABASE_PAGES", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.MODIFIED_DATABASE_PAGES</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> MODIFIED_DATABASE_PAGES = createField("MODIFIED_DATABASE_PAGES", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PENDING_DECOMPRESS</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> PENDING_DECOMPRESS = createField("PENDING_DECOMPRESS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PENDING_READS</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> PENDING_READS = createField("PENDING_READS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PENDING_FLUSH_LRU</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> PENDING_FLUSH_LRU = createField("PENDING_FLUSH_LRU", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PENDING_FLUSH_LIST</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> PENDING_FLUSH_LIST = createField("PENDING_FLUSH_LIST", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PAGES_MADE_YOUNG</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> PAGES_MADE_YOUNG = createField("PAGES_MADE_YOUNG", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PAGES_NOT_MADE_YOUNG</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> PAGES_NOT_MADE_YOUNG = createField("PAGES_NOT_MADE_YOUNG", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PAGES_MADE_YOUNG_RATE</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, Double> PAGES_MADE_YOUNG_RATE = createField("PAGES_MADE_YOUNG_RATE", org.jooq.impl.SQLDataType.DOUBLE.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DOUBLE)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PAGES_MADE_NOT_YOUNG_RATE</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, Double> PAGES_MADE_NOT_YOUNG_RATE = createField("PAGES_MADE_NOT_YOUNG_RATE", org.jooq.impl.SQLDataType.DOUBLE.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DOUBLE)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.NUMBER_PAGES_READ</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> NUMBER_PAGES_READ = createField("NUMBER_PAGES_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.NUMBER_PAGES_CREATED</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> NUMBER_PAGES_CREATED = createField("NUMBER_PAGES_CREATED", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.NUMBER_PAGES_WRITTEN</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> NUMBER_PAGES_WRITTEN = createField("NUMBER_PAGES_WRITTEN", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PAGES_READ_RATE</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, Double> PAGES_READ_RATE = createField("PAGES_READ_RATE", org.jooq.impl.SQLDataType.DOUBLE.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DOUBLE)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PAGES_CREATE_RATE</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, Double> PAGES_CREATE_RATE = createField("PAGES_CREATE_RATE", org.jooq.impl.SQLDataType.DOUBLE.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DOUBLE)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.PAGES_WRITTEN_RATE</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, Double> PAGES_WRITTEN_RATE = createField("PAGES_WRITTEN_RATE", org.jooq.impl.SQLDataType.DOUBLE.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DOUBLE)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.NUMBER_PAGES_GET</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> NUMBER_PAGES_GET = createField("NUMBER_PAGES_GET", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.HIT_RATE</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> HIT_RATE = createField("HIT_RATE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.YOUNG_MAKE_PER_THOUSAND_GETS</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> YOUNG_MAKE_PER_THOUSAND_GETS = createField("YOUNG_MAKE_PER_THOUSAND_GETS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.NOT_YOUNG_MAKE_PER_THOUSAND_GETS</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> NOT_YOUNG_MAKE_PER_THOUSAND_GETS = createField("NOT_YOUNG_MAKE_PER_THOUSAND_GETS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.NUMBER_PAGES_READ_AHEAD</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> NUMBER_PAGES_READ_AHEAD = createField("NUMBER_PAGES_READ_AHEAD", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.NUMBER_READ_AHEAD_EVICTED</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> NUMBER_READ_AHEAD_EVICTED = createField("NUMBER_READ_AHEAD_EVICTED", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.READ_AHEAD_RATE</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, Double> READ_AHEAD_RATE = createField("READ_AHEAD_RATE", org.jooq.impl.SQLDataType.DOUBLE.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DOUBLE)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.READ_AHEAD_EVICTED_RATE</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, Double> READ_AHEAD_EVICTED_RATE = createField("READ_AHEAD_EVICTED_RATE", org.jooq.impl.SQLDataType.DOUBLE.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DOUBLE)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.LRU_IO_TOTAL</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> LRU_IO_TOTAL = createField("LRU_IO_TOTAL", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.LRU_IO_CURRENT</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> LRU_IO_CURRENT = createField("LRU_IO_CURRENT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.UNCOMPRESS_TOTAL</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> UNCOMPRESS_TOTAL = createField("UNCOMPRESS_TOTAL", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");
    /**
     * The column <code>information_schema.INNODB_BUFFER_POOL_STATS.UNCOMPRESS_CURRENT</code>.
     */
    public final TableField<InnodbBufferPoolStatsRecord, ULong> UNCOMPRESS_CURRENT = createField("UNCOMPRESS_CURRENT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");

    /**
     * Create a <code>information_schema.INNODB_BUFFER_POOL_STATS</code> table reference
     */
    public InnodbBufferPoolStats() {
        this(DSL.name("INNODB_BUFFER_POOL_STATS"), null);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_BUFFER_POOL_STATS</code> table reference
     */
    public InnodbBufferPoolStats(String alias) {
        this(DSL.name(alias), INNODB_BUFFER_POOL_STATS);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_BUFFER_POOL_STATS</code> table reference
     */
    public InnodbBufferPoolStats(Name alias) {
        this(alias, INNODB_BUFFER_POOL_STATS);
    }

    private InnodbBufferPoolStats(Name alias, Table<InnodbBufferPoolStatsRecord> aliased) {
        this(alias, aliased, null);
    }

    private InnodbBufferPoolStats(Name alias, Table<InnodbBufferPoolStatsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> InnodbBufferPoolStats(Table<O> child, ForeignKey<O, InnodbBufferPoolStatsRecord> key) {
        super(child, key, INNODB_BUFFER_POOL_STATS);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InnodbBufferPoolStatsRecord> getRecordType() {
        return InnodbBufferPoolStatsRecord.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPoolStats as(String alias) {
        return new InnodbBufferPoolStats(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbBufferPoolStats as(Name alias) {
        return new InnodbBufferPoolStats(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public InnodbBufferPoolStats rename(String name) {
        return new InnodbBufferPoolStats(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public InnodbBufferPoolStats rename(Name name) {
        return new InnodbBufferPoolStats(name, null);
    }
}
