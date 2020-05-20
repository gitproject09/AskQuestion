package com.sopan.navigationdemo.navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sopan.navigationdemo.R;
import com.sopan.navigationdemo.adapter.GridViewAdapter;
import com.sopan.navigationdemo.model.Tools;
import com.sopan.navigationdemo.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class TagFragment extends Fragment {

    private GridView gridView;
    private GridViewAdapter gridAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    RelativeLayout rlPopularTags;
    List<QuestionModel> informationList;

    public TagFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tags, container, false);

        setHasOptionsMenu(true);

        swipeRefreshLayout = rootView.findViewById(R.id.swipeRefreshInfo);

        informationList = new ArrayList<>();

        setGridView(rootView);

        rlPopularTags = rootView.findViewById(R.id.rlPopularTags);
        rlPopularTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Feature will coming soon", Toast.LENGTH_LONG).show();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(swipeRefreshLayout.isRefreshing()){
                    swipeRefreshLayout.setRefreshing(false);
                }
                Toast.makeText(getActivity(), "Feature will coming soon", Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

    private void setGridView(View v) {
        gridView = v.findViewById(R.id.gridViewQuestionsTag);

        informationList = Tools.getTagInfoList();

        gridAdapter = new GridViewAdapter(getActivity(), informationList);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (informationList != null && informationList.size() > 0) {
                    Toast.makeText(getActivity(), informationList.get(position).questionTitle, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        MenuItem action_ask = menu.findItem(R.id.action_ask);
        action_ask.setVisible(false);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //*** setOnQueryTextFocusChangeListener ***
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                Toast.makeText(getActivity(), "You Search for : " + query, Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchQuery) {

                // myAppAdapter.filter(searchQuery.toString().trim());

                return true;
            }
        });

        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        });

        /*MenuItem askQuestion = menu.findItem(R.id.action_ask);
        askQuestion.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                return true;
            }
        });*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        } /*else if (id == R.id.action_ask) {
            Toast.makeText(getActivity(), "Ask A Questions Comming soon", Toast.LENGTH_SHORT).show();
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}