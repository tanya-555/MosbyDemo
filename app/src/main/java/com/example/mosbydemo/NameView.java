package com.example.mosbydemo;

import com.example.mosbydemo.Model.Name;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;

import java.util.List;

public interface NameView extends MvpLceView<List<Name>> {

    void disableRefresh();

}
