package com.sopan.navigationdemo.navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sopan.navigationdemo.R;
import com.sopan.navigationdemo.fragment.LatestQuestionsFragment;
import com.sopan.navigationdemo.fragment.MostPopularFragment;
import com.sopan.navigationdemo.fragment.NotAnsweredFragment;

public class HomeFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        setHasOptionsMenu(true);

        BottomNavigationView navegacion = root.findViewById(R.id.navbartransporte);
        navegacion.setOnNavigationItemSelectedListener(this);

        LatestQuestionsFragment latestQuestionsFragment = new LatestQuestionsFragment();
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.espacioLineas, latestQuestionsFragment).commit();

        return root;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.navigation_home:
                LatestQuestionsFragment latestQuestionsFragment = new LatestQuestionsFragment();
                FragmentManager fragmentManager1 = getChildFragmentManager();
                fragmentManager1.beginTransaction().replace(R.id.espacioLineas, latestQuestionsFragment).commit();
                return true;

            case R.id.navigation_dashboard:
                NotAnsweredFragment notAnsweredFragment = new NotAnsweredFragment();
                FragmentManager fragmentManager2 = getChildFragmentManager();
                fragmentManager2.beginTransaction().replace(R.id.espacioLineas, notAnsweredFragment).commit();
                return true;

            case R.id.navigation_notifications:
                MostPopularFragment mostPopularFragment = new MostPopularFragment();
                FragmentManager fragmentManager3 = getChildFragmentManager();
                fragmentManager3.beginTransaction().replace(R.id.espacioLineas, mostPopularFragment).commit();

                return true;
        }
        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
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
                Log.e("Homefragment", "onQueryTextChange : " + searchQuery);

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
        } else if (id == R.id.action_ask) {
            Toast.makeText(getActivity(), "Ask A Questions Comming soon", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}