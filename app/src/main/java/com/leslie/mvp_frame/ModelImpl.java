package com.leslie.mvp_frame;

import com.leslie.mvplibrary.mvp.model.IModel;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements IModel {

    @Override
    public void addModleCallBack(FetchModelCallBack listener) {
        // 加载数据

        // 返回数据到presenter去处理
        listener.onCallBack("Hello, I am the model layer!");
    }
}
