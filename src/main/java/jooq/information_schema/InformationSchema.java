/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema;


import jooq.DefaultCatalog;
import jooq.information_schema.tables.Tables;
import jooq.information_schema.tables.*;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
public class InformationSchema extends SchemaImpl {

    private static final long serialVersionUID = -1085726988;

    /**
     * The reference instance of <code>information_schema</code>
     */
    public static final InformationSchema INFORMATION_SCHEMA = new InformationSchema();

    /**
     * The table <code>information_schema.CHARACTER_SETS</code>.
     */
    public final CharacterSets CHARACTER_SETS = jooq.information_schema.tables.CharacterSets.CHARACTER_SETS;

    /**
     * The table <code>information_schema.COLLATIONS</code>.
     */
    public final Collations COLLATIONS = jooq.information_schema.tables.Collations.COLLATIONS;

    /**
     * The table <code>information_schema.COLLATION_CHARACTER_SET_APPLICABILITY</code>.
     */
    public final CollationCharacterSetApplicability COLLATION_CHARACTER_SET_APPLICABILITY = jooq.information_schema.tables.CollationCharacterSetApplicability.COLLATION_CHARACTER_SET_APPLICABILITY;

    /**
     * The table <code>information_schema.COLUMNS</code>.
     */
    public final Columns COLUMNS = jooq.information_schema.tables.Columns.COLUMNS;

    /**
     * The table <code>information_schema.COLUMN_PRIVILEGES</code>.
     */
    public final ColumnPrivileges COLUMN_PRIVILEGES = jooq.information_schema.tables.ColumnPrivileges.COLUMN_PRIVILEGES;

    /**
     * The table <code>information_schema.ENGINES</code>.
     */
    public final Engines ENGINES = jooq.information_schema.tables.Engines.ENGINES;

    /**
     * The table <code>information_schema.EVENTS</code>.
     */
    public final Events EVENTS = jooq.information_schema.tables.Events.EVENTS;

    /**
     * The table <code>information_schema.FILES</code>.
     */
    public final Files FILES = jooq.information_schema.tables.Files.FILES;

    /**
     * The table <code>information_schema.GLOBAL_STATUS</code>.
     */
    public final GlobalStatus GLOBAL_STATUS = jooq.information_schema.tables.GlobalStatus.GLOBAL_STATUS;

    /**
     * The table <code>information_schema.GLOBAL_VARIABLES</code>.
     */
    public final GlobalVariables GLOBAL_VARIABLES = jooq.information_schema.tables.GlobalVariables.GLOBAL_VARIABLES;

    /**
     * The table <code>information_schema.INNODB_BUFFER_PAGE</code>.
     */
    public final InnodbBufferPage INNODB_BUFFER_PAGE = jooq.information_schema.tables.InnodbBufferPage.INNODB_BUFFER_PAGE;

    /**
     * The table <code>information_schema.INNODB_BUFFER_PAGE_LRU</code>.
     */
    public final InnodbBufferPageLru INNODB_BUFFER_PAGE_LRU = jooq.information_schema.tables.InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU;

    /**
     * The table <code>information_schema.INNODB_BUFFER_POOL_STATS</code>.
     */
    public final InnodbBufferPoolStats INNODB_BUFFER_POOL_STATS = jooq.information_schema.tables.InnodbBufferPoolStats.INNODB_BUFFER_POOL_STATS;

    /**
     * The table <code>information_schema.INNODB_CMP</code>.
     */
    public final InnodbCmp INNODB_CMP = jooq.information_schema.tables.InnodbCmp.INNODB_CMP;

    /**
     * The table <code>information_schema.INNODB_CMPMEM</code>.
     */
    public final InnodbCmpmem INNODB_CMPMEM = jooq.information_schema.tables.InnodbCmpmem.INNODB_CMPMEM;

    /**
     * The table <code>information_schema.INNODB_CMPMEM_RESET</code>.
     */
    public final InnodbCmpmemReset INNODB_CMPMEM_RESET = jooq.information_schema.tables.InnodbCmpmemReset.INNODB_CMPMEM_RESET;

    /**
     * The table <code>information_schema.INNODB_CMP_PER_INDEX</code>.
     */
    public final InnodbCmpPerIndex INNODB_CMP_PER_INDEX = jooq.information_schema.tables.InnodbCmpPerIndex.INNODB_CMP_PER_INDEX;

    /**
     * The table <code>information_schema.INNODB_CMP_PER_INDEX_RESET</code>.
     */
    public final InnodbCmpPerIndexReset INNODB_CMP_PER_INDEX_RESET = jooq.information_schema.tables.InnodbCmpPerIndexReset.INNODB_CMP_PER_INDEX_RESET;

    /**
     * The table <code>information_schema.INNODB_CMP_RESET</code>.
     */
    public final InnodbCmpReset INNODB_CMP_RESET = jooq.information_schema.tables.InnodbCmpReset.INNODB_CMP_RESET;

    /**
     * The table <code>information_schema.INNODB_FT_BEING_DELETED</code>.
     */
    public final InnodbFtBeingDeleted INNODB_FT_BEING_DELETED = jooq.information_schema.tables.InnodbFtBeingDeleted.INNODB_FT_BEING_DELETED;

    /**
     * The table <code>information_schema.INNODB_FT_CONFIG</code>.
     */
    public final InnodbFtConfig INNODB_FT_CONFIG = jooq.information_schema.tables.InnodbFtConfig.INNODB_FT_CONFIG;

    /**
     * The table <code>information_schema.INNODB_FT_DEFAULT_STOPWORD</code>.
     */
    public final InnodbFtDefaultStopword INNODB_FT_DEFAULT_STOPWORD = jooq.information_schema.tables.InnodbFtDefaultStopword.INNODB_FT_DEFAULT_STOPWORD;

    /**
     * The table <code>information_schema.INNODB_FT_DELETED</code>.
     */
    public final InnodbFtDeleted INNODB_FT_DELETED = jooq.information_schema.tables.InnodbFtDeleted.INNODB_FT_DELETED;

    /**
     * The table <code>information_schema.INNODB_FT_INDEX_CACHE</code>.
     */
    public final InnodbFtIndexCache INNODB_FT_INDEX_CACHE = jooq.information_schema.tables.InnodbFtIndexCache.INNODB_FT_INDEX_CACHE;

    /**
     * The table <code>information_schema.INNODB_FT_INDEX_TABLE</code>.
     */
    public final InnodbFtIndexTable INNODB_FT_INDEX_TABLE = jooq.information_schema.tables.InnodbFtIndexTable.INNODB_FT_INDEX_TABLE;

    /**
     * The table <code>information_schema.INNODB_LOCKS</code>.
     */
    public final InnodbLocks INNODB_LOCKS = jooq.information_schema.tables.InnodbLocks.INNODB_LOCKS;

    /**
     * The table <code>information_schema.INNODB_LOCK_WAITS</code>.
     */
    public final InnodbLockWaits INNODB_LOCK_WAITS = jooq.information_schema.tables.InnodbLockWaits.INNODB_LOCK_WAITS;

    /**
     * The table <code>information_schema.INNODB_METRICS</code>.
     */
    public final InnodbMetrics INNODB_METRICS = jooq.information_schema.tables.InnodbMetrics.INNODB_METRICS;

    /**
     * The table <code>information_schema.INNODB_SYS_COLUMNS</code>.
     */
    public final InnodbSysColumns INNODB_SYS_COLUMNS = jooq.information_schema.tables.InnodbSysColumns.INNODB_SYS_COLUMNS;

    /**
     * The table <code>information_schema.INNODB_SYS_DATAFILES</code>.
     */
    public final InnodbSysDatafiles INNODB_SYS_DATAFILES = jooq.information_schema.tables.InnodbSysDatafiles.INNODB_SYS_DATAFILES;

    /**
     * The table <code>information_schema.INNODB_SYS_FIELDS</code>.
     */
    public final InnodbSysFields INNODB_SYS_FIELDS = jooq.information_schema.tables.InnodbSysFields.INNODB_SYS_FIELDS;

    /**
     * The table <code>information_schema.INNODB_SYS_FOREIGN</code>.
     */
    public final InnodbSysForeign INNODB_SYS_FOREIGN = jooq.information_schema.tables.InnodbSysForeign.INNODB_SYS_FOREIGN;

    /**
     * The table <code>information_schema.INNODB_SYS_FOREIGN_COLS</code>.
     */
    public final InnodbSysForeignCols INNODB_SYS_FOREIGN_COLS = jooq.information_schema.tables.InnodbSysForeignCols.INNODB_SYS_FOREIGN_COLS;

    /**
     * The table <code>information_schema.INNODB_SYS_INDEXES</code>.
     */
    public final InnodbSysIndexes INNODB_SYS_INDEXES = jooq.information_schema.tables.InnodbSysIndexes.INNODB_SYS_INDEXES;

    /**
     * The table <code>information_schema.INNODB_SYS_TABLES</code>.
     */
    public final InnodbSysTables INNODB_SYS_TABLES = jooq.information_schema.tables.InnodbSysTables.INNODB_SYS_TABLES;

    /**
     * The table <code>information_schema.INNODB_SYS_TABLESPACES</code>.
     */
    public final InnodbSysTablespaces INNODB_SYS_TABLESPACES = jooq.information_schema.tables.InnodbSysTablespaces.INNODB_SYS_TABLESPACES;

    /**
     * The table <code>information_schema.INNODB_SYS_TABLESTATS</code>.
     */
    public final InnodbSysTablestats INNODB_SYS_TABLESTATS = jooq.information_schema.tables.InnodbSysTablestats.INNODB_SYS_TABLESTATS;

    /**
     * The table <code>information_schema.INNODB_SYS_VIRTUAL</code>.
     */
    public final InnodbSysVirtual INNODB_SYS_VIRTUAL = jooq.information_schema.tables.InnodbSysVirtual.INNODB_SYS_VIRTUAL;

    /**
     * The table <code>information_schema.INNODB_TEMP_TABLE_INFO</code>.
     */
    public final InnodbTempTableInfo INNODB_TEMP_TABLE_INFO = jooq.information_schema.tables.InnodbTempTableInfo.INNODB_TEMP_TABLE_INFO;

    /**
     * The table <code>information_schema.INNODB_TRX</code>.
     */
    public final InnodbTrx INNODB_TRX = jooq.information_schema.tables.InnodbTrx.INNODB_TRX;

    /**
     * The table <code>information_schema.KEY_COLUMN_USAGE</code>.
     */
    public final KeyColumnUsage KEY_COLUMN_USAGE = jooq.information_schema.tables.KeyColumnUsage.KEY_COLUMN_USAGE;

    /**
     * The table <code>information_schema.OPTIMIZER_TRACE</code>.
     */
    public final OptimizerTrace OPTIMIZER_TRACE = jooq.information_schema.tables.OptimizerTrace.OPTIMIZER_TRACE;

    /**
     * The table <code>information_schema.PARAMETERS</code>.
     */
    public final Parameters PARAMETERS = jooq.information_schema.tables.Parameters.PARAMETERS;

    /**
     * The table <code>information_schema.PARTITIONS</code>.
     */
    public final Partitions PARTITIONS = jooq.information_schema.tables.Partitions.PARTITIONS;

    /**
     * The table <code>information_schema.PLUGINS</code>.
     */
    public final Plugins PLUGINS = jooq.information_schema.tables.Plugins.PLUGINS;

    /**
     * The table <code>information_schema.PROCESSLIST</code>.
     */
    public final Processlist PROCESSLIST = jooq.information_schema.tables.Processlist.PROCESSLIST;

    /**
     * The table <code>information_schema.PROFILING</code>.
     */
    public final Profiling PROFILING = jooq.information_schema.tables.Profiling.PROFILING;

    /**
     * The table <code>information_schema.REFERENTIAL_CONSTRAINTS</code>.
     */
    public final ReferentialConstraints REFERENTIAL_CONSTRAINTS = jooq.information_schema.tables.ReferentialConstraints.REFERENTIAL_CONSTRAINTS;

    /**
     * The table <code>information_schema.ROUTINES</code>.
     */
    public final Routines ROUTINES = jooq.information_schema.tables.Routines.ROUTINES;

    /**
     * The table <code>information_schema.SCHEMATA</code>.
     */
    public final Schemata SCHEMATA = jooq.information_schema.tables.Schemata.SCHEMATA;

    /**
     * The table <code>information_schema.SCHEMA_PRIVILEGES</code>.
     */
    public final SchemaPrivileges SCHEMA_PRIVILEGES = jooq.information_schema.tables.SchemaPrivileges.SCHEMA_PRIVILEGES;

    /**
     * The table <code>information_schema.SESSION_STATUS</code>.
     */
    public final SessionStatus SESSION_STATUS = jooq.information_schema.tables.SessionStatus.SESSION_STATUS;

    /**
     * The table <code>information_schema.SESSION_VARIABLES</code>.
     */
    public final SessionVariables SESSION_VARIABLES = jooq.information_schema.tables.SessionVariables.SESSION_VARIABLES;

    /**
     * The table <code>information_schema.STATISTICS</code>.
     */
    public final Statistics STATISTICS = jooq.information_schema.tables.Statistics.STATISTICS;

    /**
     * The table <code>information_schema.TABLES</code>.
     */
    public final Tables TABLES = jooq.information_schema.tables.Tables.TABLES;

    /**
     * The table <code>information_schema.TABLESPACES</code>.
     */
    public final Tablespaces TABLESPACES = jooq.information_schema.tables.Tablespaces.TABLESPACES;

    /**
     * The table <code>information_schema.TABLE_CONSTRAINTS</code>.
     */
    public final TableConstraints TABLE_CONSTRAINTS = jooq.information_schema.tables.TableConstraints.TABLE_CONSTRAINTS;

    /**
     * The table <code>information_schema.TABLE_PRIVILEGES</code>.
     */
    public final TablePrivileges TABLE_PRIVILEGES = jooq.information_schema.tables.TablePrivileges.TABLE_PRIVILEGES;

    /**
     * The table <code>information_schema.TRIGGERS</code>.
     */
    public final Triggers TRIGGERS = jooq.information_schema.tables.Triggers.TRIGGERS;

    /**
     * The table <code>information_schema.USER_PRIVILEGES</code>.
     */
    public final UserPrivileges USER_PRIVILEGES = jooq.information_schema.tables.UserPrivileges.USER_PRIVILEGES;

    /**
     * The table <code>information_schema.VIEWS</code>.
     */
    public final Views VIEWS = jooq.information_schema.tables.Views.VIEWS;

    /**
     * No further instances allowed
     */
    private InformationSchema() {
        super("information_schema", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            CharacterSets.CHARACTER_SETS,
            Collations.COLLATIONS,
            CollationCharacterSetApplicability.COLLATION_CHARACTER_SET_APPLICABILITY,
            Columns.COLUMNS,
            ColumnPrivileges.COLUMN_PRIVILEGES,
            Engines.ENGINES,
            Events.EVENTS,
            Files.FILES,
            GlobalStatus.GLOBAL_STATUS,
            GlobalVariables.GLOBAL_VARIABLES,
            InnodbBufferPage.INNODB_BUFFER_PAGE,
            InnodbBufferPageLru.INNODB_BUFFER_PAGE_LRU,
            InnodbBufferPoolStats.INNODB_BUFFER_POOL_STATS,
            InnodbCmp.INNODB_CMP,
            InnodbCmpmem.INNODB_CMPMEM,
            InnodbCmpmemReset.INNODB_CMPMEM_RESET,
            InnodbCmpPerIndex.INNODB_CMP_PER_INDEX,
            InnodbCmpPerIndexReset.INNODB_CMP_PER_INDEX_RESET,
            InnodbCmpReset.INNODB_CMP_RESET,
            InnodbFtBeingDeleted.INNODB_FT_BEING_DELETED,
            InnodbFtConfig.INNODB_FT_CONFIG,
            InnodbFtDefaultStopword.INNODB_FT_DEFAULT_STOPWORD,
            InnodbFtDeleted.INNODB_FT_DELETED,
            InnodbFtIndexCache.INNODB_FT_INDEX_CACHE,
            InnodbFtIndexTable.INNODB_FT_INDEX_TABLE,
            InnodbLocks.INNODB_LOCKS,
            InnodbLockWaits.INNODB_LOCK_WAITS,
            InnodbMetrics.INNODB_METRICS,
            InnodbSysColumns.INNODB_SYS_COLUMNS,
            InnodbSysDatafiles.INNODB_SYS_DATAFILES,
            InnodbSysFields.INNODB_SYS_FIELDS,
            InnodbSysForeign.INNODB_SYS_FOREIGN,
            InnodbSysForeignCols.INNODB_SYS_FOREIGN_COLS,
            InnodbSysIndexes.INNODB_SYS_INDEXES,
            InnodbSysTables.INNODB_SYS_TABLES,
            InnodbSysTablespaces.INNODB_SYS_TABLESPACES,
            InnodbSysTablestats.INNODB_SYS_TABLESTATS,
            InnodbSysVirtual.INNODB_SYS_VIRTUAL,
            InnodbTempTableInfo.INNODB_TEMP_TABLE_INFO,
            InnodbTrx.INNODB_TRX,
            KeyColumnUsage.KEY_COLUMN_USAGE,
            OptimizerTrace.OPTIMIZER_TRACE,
            Parameters.PARAMETERS,
            Partitions.PARTITIONS,
            Plugins.PLUGINS,
            Processlist.PROCESSLIST,
            Profiling.PROFILING,
            ReferentialConstraints.REFERENTIAL_CONSTRAINTS,
            Routines.ROUTINES,
            Schemata.SCHEMATA,
            SchemaPrivileges.SCHEMA_PRIVILEGES,
            SessionStatus.SESSION_STATUS,
            SessionVariables.SESSION_VARIABLES,
            Statistics.STATISTICS,
            Tables.TABLES,
            Tablespaces.TABLESPACES,
            TableConstraints.TABLE_CONSTRAINTS,
            TablePrivileges.TABLE_PRIVILEGES,
            Triggers.TRIGGERS,
            UserPrivileges.USER_PRIVILEGES,
            Views.VIEWS);
    }
}
