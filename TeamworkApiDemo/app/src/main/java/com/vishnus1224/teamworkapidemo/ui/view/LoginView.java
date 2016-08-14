package com.vishnus1224.teamworkapidemo.ui.view;

import com.vishnus1224.rxjavateamworkclient.model.Account;

/**
 * Created by Vishnu on 8/14/2016.
 */
public interface LoginView extends BaseView {

    void showProgressDialog();

    void hideProgressDialog();

    void showError(String message);

    void goToMainScreen(Account account);
}
