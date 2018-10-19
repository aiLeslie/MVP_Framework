package com.leslie.mvp_frame;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.leslie.mvplibrary.mvp.presenter.Presenter;
import com.leslie.mvplibrary.mvp.view.BaseActivity;
import com.leslie.mvplibrary.mvp.view.IView;

import java.util.List;

public class MainActivity extends BaseActivity<Presenter<IView, ModelImpl>>{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    protected Presenter createPresenter() {
        return new Presenter<>(new ModelImpl());
    }


    @Override
    public void fetchViewCallBack() {
        Toast.makeText(this, "Hello, I am the graphics layer!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void loadingData(Object data) {
        Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show();
    }


}
