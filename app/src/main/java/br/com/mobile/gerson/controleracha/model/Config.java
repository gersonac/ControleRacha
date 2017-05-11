package br.com.mobile.gerson.controleracha.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import br.com.mobile.gerson.controleracha.persistence.RachaContract;

/**
 * Created by gerson on 06/05/2017.
 */

public class Config extends ModelBase {
    private Integer teamSize;

    public Config(Context context) {
        super(context);
        this.teamSize = 5;
        TABLE_NAME = RachaContract.Config.TABLE_NAME;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    protected ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(RachaContract.Config.COLUMN_NAME_TEAMSIZE, getTeamSize());

        return values;
    }

    @Override
    protected String[] getProjection() {
        String[] projection = {
                RachaContract.Config._ID,
                RachaContract.Config.COLUMN_NAME_TEAMSIZE
        };
        return projection;
    }

    @Override
    protected void setValues(Cursor c) {
        super.setValues(c);
        setId(c.getInt(c.getColumnIndex(RachaContract.Config._ID)));
        setTeamSize(c.getInt(c.getColumnIndex(RachaContract.Config.COLUMN_NAME_TEAMSIZE)));
    }
}
