package com.example.camisetas_momento2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.camisetas_momento2.R;

import com.example.camisetas_momento2.models.CamisetasModel;

import java.util.ArrayList;

public class CamisetasAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CamisetasModel> modelArrayList;

    public CamisetasAdapter(Context context, ArrayList<CamisetasModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public CamisetasModel getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.camiseta_list_item, viewGroup, false);
        }
        TextView tv_camisetas_list_item_description = view.findViewById(R.id.tv_camisetas_list_item_description);
        TextView tv_camisetas_list_item_type = view.findViewById(R.id.tv_camisetas_list_item_type);

        tv_camisetas_list_item_description.setText(getItem(position).getDescription());
        tv_camisetas_list_item_type.setText(getItem(position).getType());
        
        return view;
    }
}
