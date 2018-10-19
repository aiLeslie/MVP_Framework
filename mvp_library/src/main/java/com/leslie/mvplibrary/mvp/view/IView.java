package com.leslie.mvplibrary.mvp.view;

import java.util.List;

public interface IView<D> {
    // 获得图形层
    void fetchViewCallBack();

    // 显示数据(使用回调的方式返回数据)
    void loadingData(D data);

}
