package com.example.xiuxian;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveSharedPreference {

    static final String PREF_EXP= "exp";
    static final String PREF_FROZEN_PERIOD = "frozenPeriod";
    static final String PREF_INDEX = "index";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static String getExp(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_EXP, "");
    }

    public static void setExp(Context ctx, String exp) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_EXP, exp);
        editor.apply();
    }

    public static String getFrozenPeriod(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_FROZEN_PERIOD, "");
    }

    public static void setFrozenPeriod(Context ctx, String frozenPeriod) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_FROZEN_PERIOD, frozenPeriod);
        editor.apply();
    }

    public static String getIndex(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_INDEX, "");
    }

    public static void setIndex(Context ctx, String index) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_INDEX, index);
        editor.apply();
    }


}
