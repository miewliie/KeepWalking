package com.augmentis.ayp.keepwalking.model;

/**
 * Created by Apinya on 8/1/2016.
 */


public class KeepWalkingDbSchema {

    public static final class KeepWalkingTable{


        public static final String NAME = "keepwalking";

        public static final class Cols{
            public static final String KEEPWALKINGID = "uuid";
            public static final String KEEPWALKINGTITLE = "title";
            public static final String DATE = "date";

        }
    }
}
