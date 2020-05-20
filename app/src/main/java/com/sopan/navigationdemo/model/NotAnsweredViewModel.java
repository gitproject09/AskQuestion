package com.sopan.navigationdemo.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotAnsweredViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotAnsweredViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Not Answered Questions");
    }

    public LiveData<String> getText() {
        return mText;
    }
}