package com.vishnus1224.teamworkapidemo.manager;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Vishnu on 8/14/2016.
 */
@Singleton
public class PreferencesManager {

    private SharedPreferences sharedPreferences;

    @Inject
    public PreferencesManager(SharedPreferences sharedPreferences){

        this.sharedPreferences = sharedPreferences;

    }

    public void save(String key, String value){

        sharedPreferences.edit().putString(key, value).commit();

    }

    public void remove(String key){

        sharedPreferences.edit().remove(key).commit();

    }

    public void clear(){

        sharedPreferences.edit().clear().commit();

    }

}
