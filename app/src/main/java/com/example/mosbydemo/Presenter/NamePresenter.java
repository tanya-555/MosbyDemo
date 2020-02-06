package com.example.mosbydemo.Presenter;

import com.example.mosbydemo.NameView;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

public interface NamePresenter extends MvpPresenter<NameView> {

    void loadNames(final boolean pullToRefresh);
}
