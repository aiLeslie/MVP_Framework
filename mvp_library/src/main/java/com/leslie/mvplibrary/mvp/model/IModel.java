package com.leslie.mvplibrary.mvp.model;

import java.util.List;

public interface IModel<D> {
    void addModleCallBack(FetchModelCallBack listener);

    // 设计一个内部回调接口
    interface FetchModelCallBack<D> {
        void onCallBack(D datas);
    }

}
