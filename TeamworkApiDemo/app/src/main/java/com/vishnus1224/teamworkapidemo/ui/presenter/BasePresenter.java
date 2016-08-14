package com.vishnus1224.teamworkapidemo.ui.presenter;

/**
 * Created by Vishnu on 8/14/2016.
 */
public interface BasePresenter<BaseView> {

    void onViewAttached(BaseView baseView);

    void onViewDetached(BaseView baseView);
}
