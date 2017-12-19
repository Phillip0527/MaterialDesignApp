package com.example.phillip.materialdesignapp.utils;

import com.example.phillip.materialdesignapp.ToolPagerAdapter;
import com.example.phillip.materialdesignapp.pojo.Tool;
import com.example.phillip.materialdesignapp.pojo.ToolType;

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


    private static final String [] HUWAI_TITLE = {"户外1：黑魂3DLC一无所有者","户外2：谁说小主播不厉害，come car",
            "户外3：2D恐怖经典系列","户外4：灵魂车队诛仙之路","户外5：锤一会僵尸 ~",
            "户外6：Candyboy：亿万僵尸","户外7：空洞骑士 恶魔城类游戏","户外8：老扬：漫漫长夜，竹子送现金","户外9：尘埃拉力和战地1 只为订阅",
            "户外10：风里雨里，快递给你"};

    private static final String [] XINGXIU_TITLE = {"星秀1：黑魂3DLC一无所有者","星秀2：谁说小主播不厉害，come car",
            "星秀3：2D恐怖经典系列","星秀4：灵魂车队诛仙之路","星秀5：锤一会僵尸 ~",
            "星秀6：Candyboy：亿万僵尸","星秀7：空洞骑士 恶魔城类游戏","星秀8：老扬：漫漫长夜，竹子送现金","星秀9：尘埃拉力和战地1 只为订阅",
            "星秀10：风里雨里，快递给你"};

    private static final String [] TITLES = {"黑魂3DLC一无所有者","谁说小主播不厉害，come car","2D恐怖经典系列","灵魂车队诛仙之路","锤一会僵尸 ~",
            "Candyboy：亿万僵尸","空洞骑士 恶魔城类游戏","老扬：漫漫长夜，竹子送现金","尘埃拉力和战地1 只为订阅","风里雨里，快递给你"};

    private static final String [] NAMES = {"司机严肃出品","咸鱼超人小DD","鬼鬼N七七","泽饶龙","紫羽羊",
            "Philllip0527","Darlene0505","两根火柴","Kulayi","迷宫MG"};




    private final Random mRandom;
    public ToolTestUtils(){
        this(0);
    }

    public ToolTestUtils(long seed) {
        this.mRandom = new Random(seed);
    }



    public Tool getNewTool(ToolType toolType, ToolPagerAdapter.Tab tab){
        final String names = getRandom(TITLES);
        String name = names + " ";
        String price = null;
        final String [] details = new String [3];
        switch (toolType){
            case INDEX:
                details[0] = getRandom(NAMES);
//                details[1] = getRandom(DETAILS_INCHES);
//                name += details[1] +" "+details[0]+" Clamp";
//                details[1]+= " opening";
                price = getRandom(PRICE_LOW);
                break;
            case HISTORY:
                details[0]=getRandom(NAMES);
                details[1]=getRandom(DETAILS_HP);
                if(tab == ToolPagerAdapter.Tab.HUWAI){
                    name = getRandom(HUWAI_TITLE);
                    details[2] = getRandom(DETAILS_BATTERY);
                }
                if(tab == ToolPagerAdapter.Tab.XINGXIU){
                    name = getRandom(XINGXIU_TITLE);
                }else {
                    name += getRandom(TYPES_SAWS_NOT_STATIONARY);
                }
                break;
            case CACHE:
                details[0]=getRandom(DETAILS_HP);
                if(tab == ToolPagerAdapter.Tab.HUWAI){
                    name = getRandom(HUWAI_TITLE);
                    details[1] = getRandom(DETAILS_BATTERY);
                }
                if(tab == ToolPagerAdapter.Tab.XINGXIU){
                    details[2] = getRandom(DETAILS_INCHES)+" throat";
                    name = getRandom(XINGXIU_TITLE);
                }else {
                    name += "Drill";
                }
                break;
            case COLLECTION:
                name += "Sander";
                break;
            case GUANZHU:
                name += "Router";
                break;
            case INFO:
                name += "Tool";
                break;
            case PIFU:
                name += "Tool";
                break;
            case HELP:
                name += "Tool";
                break;
            case SHARE:
                name += "Tool";
                break;

        }

        if(price==null){
            if(tab==ToolPagerAdapter.Tab.XINGXIU){
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
