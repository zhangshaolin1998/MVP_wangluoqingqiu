package com.bawei.lianxi.presenter;

import com.bawei.lianxi.Bean;
import com.bawei.lianxi.modle.MainActivityModel;
import com.bawei.lianxi.modle.MainActivityModelListener;
import com.bawei.lianxi.view.MainActivityViewListener;

/**
 * Created by 于俊建 on 2017/10/30.
 */

public class MainActivityPresenter {


    private MainActivityViewListener listener;
    private MainActivityModel mainActivityModel;
    public MainActivityPresenter(MainActivityViewListener listener) {
        this.listener = listener;
        this.mainActivityModel = new MainActivityModel();
    }
    public void getData(boolean up){

        mainActivityModel.getData(up, new MainActivityModelListener() {
            @Override
            public void callBackSuccess(Bean bean) {
                listener.callBackSuccess(bean);
            }

            @Override
            public void callBackFailure(int code) {
                listener.callBackFailure(code);
            }
        });

    }



}
