package com.example.mosbydemo.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mosbydemo.Model.Name;
import com.example.mosbydemo.NameView;
import com.example.mosbydemo.Presenter.NamePresenter;
import com.example.mosbydemo.Presenter.PresenterIm;
import com.example.mosbydemo.R;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceFragment;

import java.util.List;

public class NamesFragment extends MvpLceFragment<RecyclerView, List<Name>, NameView, NamePresenter> implements SwipeRefreshLayout.OnRefreshListener, NameView {

    NameAdapter adapter;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_controller,container,false);
        recyclerView = view.findViewById(R.id.contentView);
        swipeRefreshLayout = view.findViewById(R.id.refresh);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout.setOnRefreshListener(this);
        if(getActivity()!=null) {
            adapter = new NameAdapter(getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
            loadData(true);
        }
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return "failed!";
    }

    @Override
    public NamePresenter createPresenter() {
        return new PresenterIm();
    }

    @Override
    public void setData(List<Name> data) {

        adapter.updateAdapter(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadNames(pullToRefresh);
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }

    @Override
    public void disableRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
