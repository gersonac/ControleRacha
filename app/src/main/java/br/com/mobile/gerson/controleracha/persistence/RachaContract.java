package br.com.mobile.gerson.controleracha.persistence;

import android.provider.BaseColumns;

/**
 * Created by gerson on 06/05/2017.
 */

public final class RachaContract {
    private RachaContract() {}

    public static class Player implements BaseColumns {
        public static final String TABLE_NAME = "players";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_TELEFONE = "telefone";
    }

    public  static class Config implements BaseColumns {
        public static final String TABLE_NAME = "config";
        public static final String COLUMN_NAME_TEAMSIZE = "team_size";
    }

    public static final String CREATE_PLAYERS =
            "CREATE TABLE " + Player.TABLE_NAME + " ( " +
                    Player._ID + " INTEGER PRIMARY KEY," +
                    Player.COLUMN_NAME_NAME + " TEXT NOT NULL, " +
                    Player.COLUMN_NAME_TELEFONE + " TEXT )";

    public static final String CREATE_CONFIG =
            "CREATE TABLE " + Config.TABLE_NAME + " ( " +
                    Config._ID + " INTEGER PRIMARY KEY," +
                    Config.COLUMN_NAME_TEAMSIZE + " INTEGER )";
}
