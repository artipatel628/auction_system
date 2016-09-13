package com.enggdream.auctionsystem5.db;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by PareshDudhat on 12-09-2016.
 */

public class DatabaseConfig extends OrmLiteConfigUtil {
    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile("abc");
    }
}
