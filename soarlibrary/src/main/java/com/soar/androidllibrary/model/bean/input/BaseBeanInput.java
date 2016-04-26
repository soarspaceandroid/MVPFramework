package com.soar.androidllibrary.model.bean.input;


import rx.Observable;

/**
 * Created by gaofei on 2016/2/24.
 */
public  class BaseBeanInput<T>{

    private boolean showDialog = true;


    public Observable getData(T enity) {
        return null;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
