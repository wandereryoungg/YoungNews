package com.young.youngnews.module.base;

public interface IBaseView<T> {

    //显示加载动画
    void onShowLoading();

    //隐藏加载动画
    void onHideLoading();

    void onShowNetError();

    void setPresenter(T presenter);


}
