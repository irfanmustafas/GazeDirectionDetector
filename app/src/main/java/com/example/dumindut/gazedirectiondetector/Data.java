package com.example.dumindut.gazedirectiondetector;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Data class is used to store parent and child information as static variables which will be shared
 * by face Graphics within each other and face Graphics with Feature Detector.
 */
public class Data {

    public static final String PARENT = "parent";
    public static final String CHILD = "child";
    public static final String UNKNOWN = "unknown";

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    //Settings used in the applications (Thresholds and specific constants)

    public static final int PREVIEW_WIDTH = 640;
    public static final int PREVIEW_HEIGHT = 480;

    public static final float REQUESTED_FRAME_RATE = 30f;

    public static final float X_DIF_THRESHOLD = 10.0f;
    public static final float Y_DIF_THRESHOLD = 40.0f;

    public static final int FEATURE_DETECTION_TIME_THRESHOLD = 3000;  //seconds

    public static final int AGE_DETECTION_FRAME_COUNT_THRESHOLD = 2;  //feature detection frames

    public static final int AVERAGING_FRAME_COUNT_THRESHOLD = 5;   //feature detection frames
    public static final int AVERAGING_WINDOW_LENGTH = 20;    //feature detection frames

    public static final int TIME_THRESHOLD_FOR_GLOBAL_THETA = FEATURE_DETECTION_TIME_THRESHOLD/2;

    // Settings for features
    public static final float FACE_HEIGHT_FACTOR = 0.25f;  // for X looking at y thresholds
    public static final float CROP_DIMENSION_FACTOR = 2.0f; //crop width/height factor
    public static final float PARENT_ELEVATION_FACTOR = 0.5f; // for parent child same eye level check

    private static final String[] TAGS = {"colored","dog","animal","stuffed","bear","teddy","toy",
            "colorful","decorated","plastic","sign"};
    public static final ArrayList<String> TAG_LIST = new ArrayList<String>(Arrays.asList(TAGS));

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////

    public static int previewWidth = PREVIEW_WIDTH;
    public static int previewHeight = PREVIEW_HEIGHT;

    public static float meetX = 0;
    public static float meetY = 0;

    public static boolean isIdentified = false;

    static void clearData(){
        isIdentified = false;
    }

    static void updateParent(int id, float x, float y, float height, float width ){
        Parent.id = id;
        Parent.x = x;
        Parent.y = y;
        Parent.faceHeight = height;
        Parent.faceWidth = width;
    }

    static void updateChild(int id, float x, float y, float height, float width){
        Child.id = id;
        Child.x = x;
        Child.y = y;
        Child.faceHeight = height;
        Child.faceWidth = width;
    }

    public static class Parent {
        public static int id = -1;
        public static float x;
        public static float y;
        public static float faceWidth;
        public static float faceHeight;

        public static float globalTheta;
        public static long lastTime;
    }

    public static class Child {
        public static int id = -2;
        public static float x;
        public static float y;
        public static float faceWidth;
        public static float faceHeight;

        public static float globalTheta;
        public static long lastTime;
    }
}