package br.com.mobile.gerson.controleracha.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;

import br.com.mobile.gerson.controleracha.persistence.RachaSQLiteOpenHelper;

/**
 * Created by gerson on 07/05/2017.
 */

public class ModelBase {
    RachaSQLiteOpenHelper helper;
    Context context;
    protected String TABLE_NAME;
    private Integer id;

    public ModelBase(Context context) {
        this.context = context;
        if (context != null)
            helper = new RachaSQLiteOpenHelper(context);
        TABLE_NAME = "";
    }

    protected String[] getProjection() {
        return null;
    }

    protected void setValues(Cursor c) { }

    protected ContentValues getContentValues() {
        return null;
    }

    public boolean find(Integer id) {
        SQLiteDatabase db = helper.getWritableDatabase();

        String selection = BaseColumns._ID + " = ?";
        String[] selectionArgs = { id.toString() };

        Cursor c = db.query(TABLE_NAME, getProjection(), selection, selectionArgs, null, null, null);
        if (c.moveToFirst()) {
            setValues(c);
            return true;
        } else
            return false;
    }

    public void save() {
        SQLiteDatabase db = helper.getWritableDatabase();

        db.insert(TABLE_NAME, null, getContentValues());
    }

    public void update() {
        SQLiteDatabase db = helper.getWritableDatabase();

        String selection = BaseColumns._ID + " = ?";
        String[] selectionArgs = { id.toString() };

        db.update(TABLE_NAME, getContentValues(), selection, selectionArgs);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
