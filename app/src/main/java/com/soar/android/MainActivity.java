package com.soar.android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.soar.android.model.PicInfoInput;
import com.soar.android.model.PicInfoOutput;
import com.soar.android.model.RequestEntry;
import com.soar.androidllibrary.activity.BaseActivity;
import com.soar.androidllibrary.model.viewinterface.BaseViewInterface;
import com.soar.androidllibrary.presenter.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BaseViewInterface<PicInfoOutput> {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.text)
    TextView text;
    private BasePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        basePresenter = new BasePresenter().setRquestEnity(RequestEntry.class).setRequestListener(this).setBaseViewInterface(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basePresenter.setInput(new PicInfoInput(2)).load();
            }
        });
    }

    @Override
    protected void requestData() {
        Log.e("soar" , "start to reqeust");
        basePresenter.setInput(new PicInfoInput(1)).load();
    }

    @Override
    protected String currActivityName() {
        return "测试";
    }

    @Override
    public void updateView(PicInfoOutput picInfoOutput) {
        text.setText(picInfoOutput.tngou.get(0).title);
    }

    @Override
    public void showError(String msg) {

    }
}
