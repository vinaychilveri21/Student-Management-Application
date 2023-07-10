package com.example.projectstddb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Std_adapter extends BaseAdapter {

    Context context;

    public Std_adapter(Context context)
    {
        this.context=context;
    }
    @Override
    public int getCount() {

        return Std_data.std_collection.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.stdlist_layout,null);
        TextView troll,tname,tmob,tadrs,tbranch;
        troll=view.findViewById(R.id.txt_roll);
        tname=view.findViewById(R.id.txt_name);
        tmob=view.findViewById(R.id.txt_mob);
        tadrs=view.findViewById(R.id.txt_adrs);
        tbranch=view.findViewById(R.id.txt_branch);

        troll.setText("RollNo="+Std_data.std_collection.get(i).getRoll());
        tname.setText("Name="+Std_data.std_collection.get(i).getName());
        tmob.setText("MobileNo="+Std_data.std_collection.get(i).getMobile());
        tadrs.setText("Address="+Std_data.std_collection.get(i).getAddr());
        tbranch.setText("Branch="+Std_data.std_collection.get(i).getBranch());



        return view;
    }
}
