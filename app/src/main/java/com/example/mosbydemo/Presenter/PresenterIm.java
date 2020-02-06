package com.example.mosbydemo.Presenter;

import androidx.annotation.NonNull;

import com.example.mosbydemo.Api.NameApi;
import com.example.mosbydemo.Model.Name;
import com.example.mosbydemo.Model.NameAsyncLoader;
import com.example.mosbydemo.NameView;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import java.util.List;


public class PresenterIm extends MvpBasePresenter<NameView> implements NamePresenter {

    @Override
    public void loadNames(final boolean pullToRefresh) {

        ifViewAttached(new ViewAction<NameView>() {
            @Override
            public void run(@NonNull NameView view) {
                view.showLoading(false);
            }
        });
        NameAsyncLoader loader = new NameAsyncLoader(false, new NameAsyncLoader.NameAsyncListener() {
            @Override
            public void onSuccess(final List<Name> names) {
                ifViewAttached(new ViewAction<NameView>() {
                    @Override
                    public void run(@NonNull NameView view) {
                        view.setData(names);
                        view.showContent();
                        view.disableRefresh();
                    }
                });
            }

            @Override
            public void onError(final Exception e) {
                ifViewAttached(new ViewAction<NameView>() {
                    @Override
                    public void run(@NonNull NameView view) {
                        view.showError(e,pullToRefresh);
                    }
                });
            }
        });
        loader.execute();
    }


}
