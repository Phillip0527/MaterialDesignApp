package com.example.phillip.materialdesignapp.pojo;

import android.support.annotation.StringRes;

import com.example.phillip.materialdesignapp.R;

/**
 * Created by Phillip on 2017/11/23.
 */

public enum ToolType {
    INDEX(R.string.index,R.string.index_description),
    HISTORY(R.string.history,R.string.history_description),
    CACHE(R.string.cache,R.string.cache_description),
    COLLECTION(R.string.collection,R.string.collection_description),
    GUANZHU(R.string.guanzhu,R.string.guanzhu_description),
    INFO(R.string.info,R.string.info_description),
    PIFU(R.string.pifu,R.string.pifu_description),
    HELP(R.string.help,R.string.help_description),
    SHARE(R.string.share,R.string.share_description)
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
