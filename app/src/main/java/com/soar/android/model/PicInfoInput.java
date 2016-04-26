package com.soar.android.model;

import com.soar.androidllibrary.model.bean.input.BaseBeanInput;

import rx.Observable;

/**
 * Created by gaofei on 2016/2/26.
 */

public class PicInfoInput extends BaseBeanInput<RequestEntry> {

    private int id;

    public PicInfoInput(int id) {
        this.id = id;
    }


    @Override
    public Observable getData(RequestEntry enity) {
        return enity.getPicInfo(id);
    }
}
