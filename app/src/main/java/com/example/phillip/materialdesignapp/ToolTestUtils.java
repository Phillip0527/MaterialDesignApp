package com.example.phillip.materialdesignapp;

import java.util.Random;

/**
 * Created by Phillip on 2017/11/23.
 */

public class ToolTestUtils {
    private static final String [] BRANDS = {"Ace","Bosch","DeWalt","Irwin","Jet","Kreg","Makita","Porter Cable","Skil" ,"Stanley","Stihl"};
    private static final String [] DETAILS_HP = {"1/4 HP","1/2 HP","3/4 HP","1 HP","1 1/2 HP","2 HP"};
    private static final String [] DETAILS_CLAMP_TYPE = {"Bar","Spring","Quick-Grip","Pipe","Parallel"};
    private static final String [] DETAILS_INCHES = {"2\"","5\"","12\"","18\"","24\"","36\"","48\""};
    private static final String [] DETAILS_BATTERY = {"12V","18V","20V","24V","32V","48V"};

    private final Random random;
    public ToolTestUtils(){
        this(0);
    }

    public ToolTestUtils(long seed) {
        this.random = new Random(seed);
    }

//    public Tool getNewTool(ToolType toolType,ToolPagerAdapter.Tab tab){
//
//    }
}
