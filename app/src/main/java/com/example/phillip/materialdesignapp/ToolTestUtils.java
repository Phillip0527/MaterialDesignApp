package com.example.phillip.materialdesignapp;

import java.util.ArrayList;
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
    private static final String [] PRICE_LOW = {"13.5$","33.9$","32.0$","32$"};
    private static final String [] PRICE_HIGH = {"33.5$","43.9$","52.0$","62$"};
    private static final String [] PRICE_MEDIUM = {"20.5$","20.9$","20.0$","20$"};
    private static final String [] DETAILS_BLADE_SIZE = {"32","15","23","11"};
    private static final String [] TYPES_SAWS_STATIONARY = {"AA","BB","CC","DD"};
    private static final String [] TYPES_SAWS_NOT_STATIONARY = {"NOT_AA","NOT_BB","NOT_CC","NOT_DD"};


    private final Random mRandom;
    public ToolTestUtils(){
        this(0);
    }

    public ToolTestUtils(long seed) {
        this.mRandom = new Random(seed);
    }



    public Tool getNewTool(ToolType toolType, ToolPagerAdapter.Tab tab){
        final String brand = getRandom(BRANDS);
        String name = brand + " ";
        String price = null;
        final String [] details = new String [3];
        switch (toolType){
            case CLAMPS:
                details[0] = getRandom(DETAILS_CLAMP_TYPE);
                details[1] = getRandom(DETAILS_INCHES);
                name += details[1] +" "+details[0]+" Clamp";
                details[1]+= " opening";
                price = getRandom(PRICE_LOW);
                break;
            case SAWS:
                details[0]=getRandom(DETAILS_BLADE_SIZE);
                details[1]=getRandom(DETAILS_HP);
                if(tab == ToolPagerAdapter.Tab.BATTERY){
                    details[2] = getRandom(DETAILS_BATTERY);
                }
                if(tab == ToolPagerAdapter.Tab.STATIONARY){
                    name += getRandom(TYPES_SAWS_STATIONARY);
                }else {
                    name += getRandom(TYPES_SAWS_NOT_STATIONARY);
                }
                break;
            case DRILLS:
                details[0]=getRandom(DETAILS_HP);
                if(tab == ToolPagerAdapter.Tab.BATTERY){
                    details[1] = getRandom(DETAILS_BATTERY);
                }
                if(tab == ToolPagerAdapter.Tab.STATIONARY){
                    details[2] = getRandom(DETAILS_INCHES)+" throat";
                    name += getRandom(TYPES_SAWS_STATIONARY);
                }else {
                    name += "Drill";
                }
                break;
            case SANDERS:
                name += "Sander";
                break;
            case ROUTERS:
                name += "Router";
                break;
            case MORE:
                name += "Tool";
                break;

        }

        if(price==null){
            if(tab==ToolPagerAdapter.Tab.STATIONARY){
                price=getRandom(PRICE_HIGH);
            }else{
                price=getRandom(PRICE_MEDIUM);
            }
        }
        String description = "工具说明..................................................";
        return new Tool(name,price,details,description);
    }

    public ArrayList<Tool> getNewTools(ToolType toolType,ToolPagerAdapter.Tab tab, int count){
        final ArrayList<Tool> results =new ArrayList<>(count);
        for (int i=0;i<count;i++){
            results.add(getNewTool(toolType,tab));
        }
        return results;
    }

    private String getRandom(String [] strings){
        return strings[mRandom.nextInt(strings.length)];
    }
}
