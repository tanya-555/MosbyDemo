package com.example.mosbydemo.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mosbydemo.Model.Name;
import com.example.mosbydemo.R;

import java.util.ArrayList;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder>  {

    private List<Name> names;

     private Context context;

    NameAdapter(Context context) {
        this.context = context;
        names = new ArrayList<>();
    }


    public void updateAdapter(List<Name> names)
    {
        this.names.clear();
        this.names.addAll(names);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fullName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName = itemView.findViewById(R.id.fullName);
        }

        public void bind(Name name, int position) {
            String full_name = name.getFirstname() + " " + name.getLastname();
            fullName.setText(full_name);
        }
    }

    @NonNull
    @Override
    public NameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_view, parent, false);
        ViewHolder nameViewHolder = new ViewHolder(view);
        return nameViewHolder;

    }



    @Override
    public void onBindViewHolder(@NonNull NameAdapter.ViewHolder holder, int position) {

        holder.bind(names.get(position), position);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


}
