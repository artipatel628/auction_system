package com.enggdream.auctionsystem5.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by PareshDudhat on 13-09-2016.
 */

public class PreferenceUtil {
    private static final String PREF_NAME = "auction_system";
    private static final String ACTIVE_USER_ID = "active_user_id";

    private static String readData(Context context, String keyName, String defaultValue) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getString(keyName, defaultValue);
    }

    private static boolean writeData(Context context, String keyName, String value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(keyName, value);
        return editor.commit();
    }

    public static long getActiveUserID(Context context) {
        String activeUserId = readData(context, ACTIVE_USER_ID, "0");
        return Long.valueOf(activeUserId);
    }

    public static boolean setActiveUserID(Context context, long userID) {
        return writeData(context, ACTIVE_USER_ID, String.valueOf(userID));
    }
}
