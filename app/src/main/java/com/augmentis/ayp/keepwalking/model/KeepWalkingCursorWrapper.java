package com.augmentis.ayp.keepwalking.model;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.augmentis.ayp.keepwalking.KeepWalking;
import com.augmentis.ayp.keepwalking.model.KeepWalkingDbSchema.KeepWalkingTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Apinya on 8/1/2016.
 */
public class KeepWalkingCursorWrapper extends CursorWrapper {

    public KeepWalkingCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public KeepWalking getKeepWalking(){

        String keepWalkingIdString = getString(getColumnIndex(KeepWalkingTable.Cols.KEEPWALKINGID));
        String keepWalkingTitle = getString(getColumnIndex(KeepWalkingTable.Cols.KEEPWALKINGTITLE));
        long date = getLong(getColumnIndex(KeepWalkingTable.Cols.DATE));

        KeepWalking keepwalking = new KeepWalking(UUID.fromString(keepWalkingIdString));
        keepwalking.setKeepWalkingTitle(keepWalkingTitle);
        keepwalking.setKeepWalkingDate(new Date(date));

        return keepwalking;
    }
}
