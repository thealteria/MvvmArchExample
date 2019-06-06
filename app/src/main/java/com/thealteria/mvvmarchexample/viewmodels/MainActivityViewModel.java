package com.thealteria.mvvmarchexample.viewmodels;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.thealteria.mvvmarchexample.model.NicePlace;
import com.thealteria.mvvmarchexample.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces; //MutableLiveData is the subclass of LiveData class
    private NicePlaceRepository repository;
    //MutableLiveData an be changed
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public void init() {
        if (mNicePlaces != null) {
            return;
        }
        repository = NicePlaceRepository.getInstance();
        mNicePlaces = repository.getNicePlaces();
    }

    @SuppressLint("StaticFieldLeak")
    public void addNewValue(final NicePlace nicePlace) {
        isUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);


            }

            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        }.execute();
    }

    public LiveData<List<NicePlace>> getNicePlaces() { //LiveData can't be changed
        //we can observe changes data in LiveData
        return mNicePlaces;
    }
}
