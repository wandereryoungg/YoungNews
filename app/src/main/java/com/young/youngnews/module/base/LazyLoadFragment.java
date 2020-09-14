package com.young.youngnews.module.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract class LazyLoadFragment<T extends IBasePresenter> extends BaseFragment<T> {

    protected boolean isViewInitiated;

    protected boolean isDataInitiated;

    protected boolean isVisibleToUser;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    public void prepareFetchData() {
        prepareFetchData(false);
    }

    public void prepareFetchData(boolean forceUpdate) {
        if (isViewInitiated && isVisibleToUser && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
        }
    }

    public abstract void fetchData();

}
