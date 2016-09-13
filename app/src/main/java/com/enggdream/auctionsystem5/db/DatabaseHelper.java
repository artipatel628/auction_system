package com.enggdream.auctionsystem5.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.enggdream.auctionsystem5.model.AuctionItem;
import com.enggdream.auctionsystem5.model.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by PareshDudhat on 12-09-2016.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "auction_system";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper dbHelper = null;
    private RuntimeExceptionDao<User, Long> userDao = null;
    private RuntimeExceptionDao<AuctionItem, Long> itemDao = null;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new DatabaseHelper(context);
        }
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, AuctionItem.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public RuntimeExceptionDao<User, Long> getUserDao() {
        if (userDao == null) {
            userDao = getRuntimeExceptionDao(User.class);
        }
        return userDao;
    }

    public RuntimeExceptionDao<AuctionItem, Long> getItemDao() {
        if (itemDao == null) {
            itemDao = getRuntimeExceptionDao(AuctionItem.class);
        }
        return itemDao;
    }

    public User getUserByUsername(String user) throws SQLException {
        QueryBuilder<User, Long> queryBuilder = getUserDao().queryBuilder();
        queryBuilder.where().like("username", user);
        List<User> users = getUserDao().query(queryBuilder.prepare());
        return users.size() > 0 ? users.get(0) : null;
    }

    public User checkLogin(String username, String password) throws SQLException {
        QueryBuilder<User, Long> queryBuilder = getUserDao().queryBuilder();
        queryBuilder.where().like("username", username).and().like("password", password);
        List<User> users = getUserDao().query(queryBuilder.prepare());
        return users.size() > 0 ? users.get(0) : null;
    }

    public List<AuctionItem> getMyAuctions(long userId) throws SQLException {
        QueryBuilder<AuctionItem, Long> queryBuilder =
                getItemDao().queryBuilder()
                        .orderBy("created_date", false);
        queryBuilder.where().like("owner_id", userId);
        return getItemDao().query(queryBuilder.prepare());
    }
}
