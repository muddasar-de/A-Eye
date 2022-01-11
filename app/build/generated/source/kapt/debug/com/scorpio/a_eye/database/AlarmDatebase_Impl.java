package com.scorpio.a_eye.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDatebase_Impl extends AlarmDatebase {
  private volatile AlarmDao _alarmDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Alarm` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `time` TEXT, `hour` TEXT, `mins` TEXT, `label` TEXT, `mon` TEXT, `tues` TEXT, `wed` TEXT, `thurs` TEXT, `fri` TEXT, `sat` TEXT, `sun` TEXT, `is_enabled` TEXT, `snooze` TEXT, `vibration` TEXT, `alarmid` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3ce0df00e5fa85c65d23b4a2905925b5')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Alarm`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAlarm = new HashMap<String, TableInfo.Column>(16);
        _columnsAlarm.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("time", new TableInfo.Column("time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("hour", new TableInfo.Column("hour", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("mins", new TableInfo.Column("mins", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("label", new TableInfo.Column("label", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("mon", new TableInfo.Column("mon", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("tues", new TableInfo.Column("tues", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("wed", new TableInfo.Column("wed", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("thurs", new TableInfo.Column("thurs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("fri", new TableInfo.Column("fri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("sat", new TableInfo.Column("sat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("sun", new TableInfo.Column("sun", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("is_enabled", new TableInfo.Column("is_enabled", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("snooze", new TableInfo.Column("snooze", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("vibration", new TableInfo.Column("vibration", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("alarmid", new TableInfo.Column("alarmid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlarm = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlarm = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlarm = new TableInfo("Alarm", _columnsAlarm, _foreignKeysAlarm, _indicesAlarm);
        final TableInfo _existingAlarm = TableInfo.read(_db, "Alarm");
        if (! _infoAlarm.equals(_existingAlarm)) {
          return new RoomOpenHelper.ValidationResult(false, "Alarm(com.scorpio.a_eye.database.Alarm).\n"
                  + " Expected:\n" + _infoAlarm + "\n"
                  + " Found:\n" + _existingAlarm);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "3ce0df00e5fa85c65d23b4a2905925b5", "d532f80874ba04230a6e0c549715c6be");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Alarm");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Alarm`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(AlarmDao.class, AlarmDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public AlarmDao alarmDao() {
    if (_alarmDao != null) {
      return _alarmDao;
    } else {
      synchronized(this) {
        if(_alarmDao == null) {
          _alarmDao = new AlarmDao_Impl(this);
        }
        return _alarmDao;
      }
    }
  }
}
