package com.example.mosbydemo.Model;

import android.os.AsyncTask;

import com.example.mosbydemo.Api.NameApi;

import java.util.Collections;
import java.util.List;

public class NameAsyncLoader extends AsyncTask<Void, Void, List<Name>> {

    private boolean shouldFail;
    private NameAsyncListener listener;

    public NameAsyncLoader(boolean shouldFail, NameAsyncListener listener) {
        this.shouldFail = shouldFail;
        this.listener = listener;
    }

    public interface NameAsyncListener {

        public void onSuccess(List<Name> names);
        public void onError(Exception e) ;
    }

    @Override
    protected List<Name> doInBackground(Void... voids) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Name> names = NameApi.getNames();
        Collections.shuffle(names);
        return names;
    }

    @Override
    protected void onPostExecute(List<Name> names) {
        if (isCancelled() || names == null)
            return;
        if (shouldFail) {
            listener.onError(new Exception("Oops Something went wrong"));
        } else {
            listener.onSuccess(names);
        }


    }
}
