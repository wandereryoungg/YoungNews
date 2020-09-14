package com.young.youngnews.module.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment implements IBaseView<T> {

    protected T presenter;
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(attachLayoutId(), container, false);

        initView(view);

        initData();

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    protected void initToolbar(Toolbar toolbar, boolean enableHomeAsUpEnabled, String title) {
        ((BaseActivity) getActivity()).initToolBar(toolbar, enableHomeAsUpEnabled, title);
    }

    protected abstract int attachLayoutId();

    protected abstract void initView(View view);

    protected abstract void initData();
}
