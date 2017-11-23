package com.example.phillip.materialdesignapp;

import android.support.annotation.StringRes;

/**
 * Created by Phillip on 2017/11/23.
 */

public enum ToolType {
    CLAMPS(R.string.clamps,R.string.clamps_description),
    SAWS(R.string.saw,R.string.saw_description),
    DRILLS(R.string.drills,R.string.drills_description),
    SANDERS(R.string.sanders,R.string.sanders_description),
    ROUTERS(R.string.routers,R.string.routers_description),
    MORE(R.string.more,R.string.more_description),
    ;

    private final int toolNameResourceId;
    private final int toolDescriptionResourceId;

    private ToolType(@StringRes int toolname, @StringRes int tooldescription) {
        toolNameResourceId = toolname;
        toolDescriptionResourceId = tooldescription;
    }

    @StringRes
    public int getToolNameResourceId() {
        return toolNameResourceId;

    }

    @StringRes
    public int getToolDescriptionResourceId() {
        return toolDescriptionResourceId;
    }


}
