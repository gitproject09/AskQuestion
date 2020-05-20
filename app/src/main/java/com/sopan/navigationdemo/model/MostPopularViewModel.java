package com.sopan.navigationdemo.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MostPopularViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MostPopularViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Most Popular Questions");
    }

    public LiveData<String> getText() {
        return mText;
    }
}