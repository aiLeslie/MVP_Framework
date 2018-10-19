package com.leslie.mvplibrary.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.leslie.mvplibrary.mvp.presenter.BasePresenter;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView {


    protected P presenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 获得Presenter的实例
        presenter = createPresenter();

        if (presenter == null) {
            throw new RuntimeException("presenter not found!");
        }
        // 如果presenter不为空绑定图形层(Activity)
        presenter.attachView(this);


        presenter.fetch();

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 如果presenter不为空解绑图形层(Activity)
        if (presenter != null) presenter.detachView();
    }
}
