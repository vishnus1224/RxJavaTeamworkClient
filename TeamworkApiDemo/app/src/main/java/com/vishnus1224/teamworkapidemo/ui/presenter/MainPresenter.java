package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.teamworkapidemo.ui.view.MainView;

import javax.inject.Inject;

/**
 * Handles presentation logic for the main screen.
 * Created by Vishnu on 8/16/2016.
 */
public class MainPresenter implements BasePresenter<MainView> {

    private MainView mainView;

    /**
     * Item position of the currently selected navigation drawer item.
     */
    private int selectedItemPosition;

    @Inject
    public MainPresenter(){


    }

    @Override
    public void onViewAttached(MainView mainView) {

        if(mainView == null){

            throw new IllegalArgumentException("View cannot be null");

        }

        this.mainView = mainView;

    }

    @Override
    public void onViewDetached(MainView mainView) {

        this.mainView = null;

    }

    public void drawerItemClicked(int position){

        //do not take any action if the new position is same as the selectedItemPosition
        if(selectedItemPosition == position){

            return;

        }

        setSelectedItemPosition(position);

        closeDrawer();

        showScreen(position);

    }

    private void setSelectedItemPosition(int position) {

        selectedItemPosition = position;

    }

    /**
     * Show the correct screen based on the selected item position.
     * @param position The position of the selected item.
     */
    private void showScreen(int position) {

        switch (position){

            case 0:

                mainView.showLatestActivityScreen();

                break;
            case 1:

                mainView.showProjectsScreen();

                break;
            case 2:

                mainView.showTaskScreen();

                break;

        }

    }



    private void closeDrawer() {

        mainView.closeDrawer();

    }


}
