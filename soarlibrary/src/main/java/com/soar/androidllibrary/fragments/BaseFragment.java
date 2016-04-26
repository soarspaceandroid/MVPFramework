package com.soar.androidllibrary.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.animation.Animation;

import com.soar.androidllibrary.activity.BaseActivity;
import com.soar.androidllibrary.interfaces.RequestListener;


public abstract class BaseFragment extends Fragment implements RequestListener {


    /**
     * do the request for fragment
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requestData();
    }

    /**
     * use to set fragment's title
     * @param transit
     * @param enter
     * @param nextAnim
     * @return
     */
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if(enter && !TextUtils.isEmpty(currentTitle())){
            ((BaseActivity) getActivity()).setTitle(currentTitle());
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    /**
     * 如果 当前的fragment不需要改变标题  ,返回 null 或是 "" ,默认重写返回 null  . 无需再管
     * @return
     */
    protected abstract String currentTitle();

    protected  abstract void  requestData();

    /**
     * dialog tag
     */
    private static String mDialogTag = "dialog";

    /**
     * 描述：显示加载框.
     *
     * @param context               the context
     */
    public static void showLoadDialog(Context context) {
    }

    /**
     * 描述：移除Fragment.
     *
     * @param context the context
     */
    public static void removeDialog(Context context) {
    }

    @Override
    public void showProgressDialog() {
        showLoadDialog(getActivity());
    }

    @Override
    public void hideProgressDialog() {
     removeDialog(getActivity());
    }

    @Override
    public void errorDisplay(String errorMsg) {
    }

    @Override
    public void errorHide() {

    }
}
