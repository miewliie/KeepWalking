package com.augmentis.ayp.keepwalking.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.augmentis.ayp.keepwalking.model.KeepWalkingDbSchema.KeepWalkingTable;

/**
 * Created by Apinya on 8/1/2016.
 */
public class KeepWalkingBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "keepwalkingbase.db";
    private static final int VERSION = 1;

    public KeepWalkingBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + KeepWalkingTable.NAME
                + "("
                + "_id integer primary key autoincrement, "
                + KeepWalkingTable.Cols.KEEPWALKINGID + ","
                + KeepWalkingTable.Cols.KEEPWALKINGTITLE +  ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
