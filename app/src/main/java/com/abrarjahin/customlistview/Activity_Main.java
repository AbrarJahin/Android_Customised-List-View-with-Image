package com.abrarjahin.customlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import java.util.ArrayList;
import android.widget.ListView;
import android.content.res.Resources;

public class Activity_Main extends Activity {
    ListView list;
    Adapter_ListView adapter;
    private ArrayList<Model_List_Item> CustomListViewValuesArr = new ArrayList<Model_List_Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);      //List view layout - main layout

        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData(0, 11);      //Set the list data - 0 is starting index and 11 is total no of elements to show

        list = (ListView) findViewById(R.id.list);     //Find list of the main list layout
        /**************** Create Custom Adapter *********/
        adapter = new Adapter_ListView(this, CustomListViewValuesArr);
        list.setAdapter(adapter);

        //Set OnCLick Action to each list item
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Model_List_Item selected_item = CustomListViewValuesArr.get(position);
                Toast.makeText(getApplicationContext(), "" + selected_item.getCompanyName() + " \nImage:" + selected_item.getImage() + " \nUrl:" + selected_item.getUrl(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * *** Function to set data in ArrayList to show in list ************
     */
    private void setListData(int start_item, int no_of_item)       //Put all your data in here
    {
        for (int i = start_item; i < no_of_item + start_item; i++)
        {
            final Model_List_Item all_current_data = new Model_List_Item();
            Resources res = getResources();
            /******* Firstly take data in model object ******/  //Same as in the model                                  //Update here////////////////////
            all_current_data.setCompanyName("Company " + i);
            all_current_data.setImage(res.getIdentifier("com.abrarjahin.customlistview:drawable/image" + i, null, null));
            all_current_data.setUrl("http:\\\\www." + i + ".com");

            /******** Take Model Object in ArrayList **********/
            CustomListViewValuesArr.add(all_current_data);
        }
    }
}
