package com.abrarjahin.customlistview;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_ListView extends BaseAdapter
{
/********** Declare Used Variables ********/
    private Activity activity;
    private ArrayList<Model_List_Item> all_data_holder;

    /************  Custom Adapter Constructor ****************/
    public Adapter_ListView(Activity current_activity, ArrayList all_data)
    {
        /********* Take passed values *********/
        activity = current_activity;
        all_data_holder = new ArrayList<Model_List_Item>(all_data);
    }

    /******* What is the size of Passed Arraylist ***********/
    @Override
    public int getCount()
    {
        if(all_data_holder.size()<=0)
            return 1;
        return all_data_holder.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

/********** Depends upon all_data_holder size called for each row , Create each ListView row **********/
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Model_List_Item current_item = (Model_List_Item) all_data_holder.get(position);
        //if view already exists, no need to create again, just return that
        if (convertView != null)
        {
            return convertView;
        }
        //If not exists, create them
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        gridView = new View(activity);
        gridView = inflater.inflate(R.layout.single_item, null);

        //Get the view items
        ImageView iv_title = (ImageView) gridView.findViewById(R.id.title_image);
        TextView tv_header = (TextView) gridView.findViewById(R.id.header_text);
        TextView tv_detail = (TextView) gridView.findViewById(R.id.detailed_text);

        // setting the values
        iv_title.setImageResource(current_item.getImage());
        tv_header.setText(current_item.getCompanyName());
        tv_detail.setText(current_item.getUrl());

        return gridView;
    }
}
