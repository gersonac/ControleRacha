package br.com.mobile.gerson.controleracha.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.mobile.gerson.controleracha.persistence.RachaContract;

/**
 * Created by gerson on 01/05/2017.
 */

public class Player extends ModelBase {
    private String name;
    private String telefone;

    public Player(Context context) {
        super(context);
        this.TABLE_NAME = RachaContract.Player.TABLE_NAME;
    }

    public Player(Context context, String name) {
        super(context);
        this.TABLE_NAME = RachaContract.Player.TABLE_NAME;
        this.name = name;
    }

    public Player(String name) {
        super(null);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Player> getAll() {
        ArrayList<Player> result = new ArrayList<>();
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor c = db.query(TABLE_NAME, getProjection(), null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            Player player = new Player(context);
            player.setId(c.getInt(c.getColumnIndex(RachaContract.Player._ID)));
            player.setName(c.getString(c.getColumnIndex(RachaContract.Player.COLUMN_NAME_NAME)));
            player.setTelefone(c.getString(c.getColumnIndex(RachaContract.Player.COLUMN_NAME_TELEFONE)));
            result.add(player);
            c.moveToNext();
        }

        return result;
    }

    @Override
    public String toString() {
        return getName().toString();
    }

    @Override
    protected String[] getProjection() {
        String[] projection = {
                RachaContract.Player._ID,
                RachaContract.Player.COLUMN_NAME_NAME,
                RachaContract.Player.COLUMN_NAME_TELEFONE
        };
        return projection;
    }

    @Override
    protected ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(RachaContract.Player.COLUMN_NAME_NAME, getName());
        values.put(RachaContract.Player.COLUMN_NAME_TELEFONE, getTelefone());
        return values;
    }

    @Override
    protected void setValues(Cursor c) {
        setId(c.getInt(c.getColumnIndex(RachaContract.Player._ID)));
        setName(c.getString(c.getColumnIndex(RachaContract.Player.COLUMN_NAME_NAME)));
        setTelefone(c.getString(c.getColumnIndex(RachaContract.Player.COLUMN_NAME_TELEFONE)));
    }
}
