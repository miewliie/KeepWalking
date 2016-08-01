package com.augmentis.ayp.keepwalking;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Apinya on 7/27/2016.
 */
public class KeepWalkingLab {

    List<KeepWalking> keepWalkingList;


    private static KeepWalkingLab instance;


    public static KeepWalkingLab getInstance(Context context){
        if(instance == null){
            instance = new KeepWalkingLab();
        }
        return instance;
    }

    private KeepWalkingLab(){
        keepWalkingList = new ArrayList<>();

    }


    public  KeepWalking getKeepWalkingByID(UUID uuid){
        for (KeepWalking keepWalking : keepWalkingList){
            if(keepWalking.getKeepWalkingId().equals(uuid)){
                return keepWalking;
            }
        }
        return null;
    }

    public int getKeepWalkingPositionByID(UUID uuid){
        int size = keepWalkingList.size();
        for (int i = 0; i < size; i++){
            if(keepWalkingList.get(i).getKeepWalkingId().equals(uuid)){
                return i;
            }
        }
        return -1;
    }

    public List<KeepWalking> getKeepWalking(){
        return this.keepWalkingList;
    }

    public static void main(String [] args){
        KeepWalkingLab keepWalking = KeepWalkingLab.getInstance(null);
        List<KeepWalking> keepWalkingList = keepWalking.getKeepWalking();
        int size = keepWalkingList.size();

        for(int i = 0; i < size; i++){
            System.out.println(keepWalkingList.get(i));

        }

    }

    public void addKeepWalking(KeepWalking keepWalking) {
        keepWalkingList.add(keepWalking);
    }
}
