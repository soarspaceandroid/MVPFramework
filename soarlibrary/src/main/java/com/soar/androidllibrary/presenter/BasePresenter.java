package com.soar.androidllibrary.presenter;


import android.util.Log;

import com.soar.androidllibrary.interfaces.RequestListener;
import com.soar.androidllibrary.model.bean.input.BaseBeanInput;
import com.soar.androidllibrary.model.bean.output.BaseBeanOutput;
import com.soar.androidllibrary.model.viewinterface.BaseViewInterface;
import com.soar.androidllibrary.net.RetrofitFactory;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ligang967 on 16/2/23.
 */
public class BasePresenter<T extends BaseBeanOutput , S> {
    private final static String TAG = "BasePresenter";

    private BaseViewInterface baseViewInterface;


    private S enity = null;

    private BaseBeanInput input;

    private RequestListener requestListener;

    public BasePresenter setRquestEnity(Class<S> sClass) {
        if (enity == null) {
            enity = RetrofitFactory.getInstance(sClass);
        }
        return this;
    }

    public BasePresenter setBaseViewInterface(BaseViewInterface baseViewInterface) {
        this.baseViewInterface = baseViewInterface;
        return this;
    }


    public BasePresenter setInput(BaseBeanInput input) {
        this.input = input;
        return this;
    }

    public BasePresenter setRequestListener(RequestListener requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public void load() {
        if (input.isShowDialog()&&this.requestListener!=null) {
            this.requestListener.showProgressDialog();
        }
        Log.e("soar" , "start to reqeust");
        requestListener.errorHide();
        input.getData(enity)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                        if (input.isShowDialog()&&requestListener!=null) {
                            requestListener.hideProgressDialog();
                        }
                        Log.e("soar" , "completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (input.isShowDialog()&&requestListener!=null) {
                            requestListener.hideProgressDialog();
                        }
                        Log.e("soar" , "error");
                        baseViewInterface.showError(e.getLocalizedMessage());
                        requestListener.errorDisplay(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(T t) {
                        baseViewInterface.updateView(t);
                        Log.e("soar", "on next");
                        if (input.isShowDialog()&&requestListener!=null) {
                            requestListener.hideProgressDialog();
                        }
                    }
                });


    }

}
