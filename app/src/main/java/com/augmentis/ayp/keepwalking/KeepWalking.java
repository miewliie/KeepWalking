package com.augmentis.ayp.keepwalking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;
import java.util.UUID;

public class KeepWalking {

    private UUID keepWalkingId;
    private String keepWalkingTitle;
    private Date keepWalkingDate;

    public KeepWalking(){
        keepWalkingId = UUID.randomUUID();
        keepWalkingDate = new Date();
    }

    public UUID getKeepWalkingId() {
        return keepWalkingId;
    }

    public void setKeepWalkingId(UUID keepWalkingId) {
        this.keepWalkingId = keepWalkingId;
    }

    public String getKeepWalkingTitle() {
        return keepWalkingTitle;
    }

    public void setKeepWalkingTitle(String keepWalkingTitle) {
        this.keepWalkingTitle = keepWalkingTitle;
    }

    public Date getKeepWalkingDate() {
        return keepWalkingDate;
    }

    public void setKeepWalkingDate(Date keepWalkingDate) {
        this.keepWalkingDate = keepWalkingDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UUID=").append(keepWalkingId);
        builder.append("Title=").append(keepWalkingTitle);
        builder.append("Date=").append(keepWalkingDate);
        return builder.toString();
    }
}
