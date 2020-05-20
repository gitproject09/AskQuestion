package com.sopan.navigationdemo.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LatestQuestionsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LatestQuestionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Latest Questions");
    }

    public LiveData<String> getText() {
        return mText;
    }
}