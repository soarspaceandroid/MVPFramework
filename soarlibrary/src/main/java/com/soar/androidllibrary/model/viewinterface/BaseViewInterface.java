package com.soar.androidllibrary.model.viewinterface;

/**
 * Created by gaofei on 2016/2/24.
 */
public interface BaseViewInterface<T>{

    void updateView(T t);

    void showError(String msg);
}
