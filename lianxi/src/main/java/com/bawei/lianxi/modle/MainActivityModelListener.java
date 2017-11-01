package com.bawei.lianxi.modle;

import com.bawei.lianxi.Bean;

/**
 * Created by 于俊建 on 2017/10/30.
 */

public interface MainActivityModelListener  {

    public void callBackSuccess(Bean bean);
    public void callBackFailure(int code);
}
