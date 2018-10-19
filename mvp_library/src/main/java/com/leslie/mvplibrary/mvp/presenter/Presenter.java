package com.leslie.mvplibrary.mvp.presenter;


import android.util.Log;

import com.leslie.mvplibrary.mvp.model.IModel;
import com.leslie.mvplibrary.mvp.view.IView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * 表示层
 */
public class Presenter<T extends IView, M extends IModel> extends BasePresenter<T> {
    private static final String TAG = "Presenter";
    // 第一步: view层的引用 (不能使用new实例化)
//    IView viewLayer;


    // 第二步: model层引用 (可以直接使用new实例化)
    // view层的弱引用
    protected WeakReference<M> mModelWf;

    // 第三步: 构造方法

    public Presenter(M model) {
        mModelWf = new WeakReference<>(model);
    }

    @Override
    public void detachView() {
        super.detachView();
        mModelWf.clear();
    }

    // 第四步: 执行操作
    @Override
    public void fetch() {
        if (mViewWf.get() != null) {
            mViewWf.get().fetchViewCallBack();

            if (mModelWf.get() != null) {
                mModelWf.get().addModleCallBack(new IModel.FetchModelCallBack() {
                    @Override
                    public void onCallBack(Object data) {
                        Log.d(TAG, "onCallBack: Successfully acquire the graphics layer and model layer");
                        mViewWf.get().loadingData(data);
                    }
                });
            }
        }

    }
}
