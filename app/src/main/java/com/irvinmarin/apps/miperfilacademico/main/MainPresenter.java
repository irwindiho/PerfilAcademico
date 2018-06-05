package com.irvinmarin.apps.miperfilacademico.main;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public interface MainPresenter {
    void onCreate();

    void onStar();

    void onResume();

    void onDestroy();

    void setView(MainView view);

    void navigationItemSelected(int itemId);
}
