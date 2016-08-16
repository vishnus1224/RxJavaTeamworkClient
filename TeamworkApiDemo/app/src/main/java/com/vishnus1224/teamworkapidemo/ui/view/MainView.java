package com.vishnus1224.teamworkapidemo.ui.view;

/**
 * Created by Vishnu on 8/16/2016.
 */
public interface MainView extends BaseView {

    void showLatestActivityScreen();

    void showProjectsScreen();

    void showTaskScreen();

    void openDrawer();

    void closeDrawer();

    void updateTitle(int position);
}
