/*
 * Copyright (C) 2013 Mathias Claes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.claesinc.blediscover;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MainActivity class
 *
 * @author claesmathias@gmail.com (Mathias Claes)
 */
public class MainActivity extends Activity {
    private String[] mMenuItems;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    ListView list;
    private LazyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("0", "0");
        map.put("1", "test");
        map.put("2", "test");
        map.put("3", "test");

        // adding HashList to ArrayList
        songsList.add(map);

        list = (ListView) findViewById(R.id.list);

        // Getting adapter by passing xml data ArrayList
        mAdapter = new LazyAdapter(this, songsList);
        list.setAdapter(mAdapter);




        mMenuItems = getResources().getStringArray(R.array.drawer_items);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mMenuItems));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    }
}

