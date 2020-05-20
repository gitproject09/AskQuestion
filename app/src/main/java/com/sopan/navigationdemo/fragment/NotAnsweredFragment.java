package com.sopan.navigationdemo.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sopan.navigationdemo.R;
import com.sopan.navigationdemo.adapter.LatestQuestionAdapter;
import com.sopan.navigationdemo.model.LatestQuestionsViewModel;
import com.sopan.navigationdemo.model.QuestionModel;
import com.sopan.navigationdemo.model.Tools;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class NotAnsweredFragment extends Fragment {

    // private RecyclerView mRecycler;
    ListAdapter adapter;
    ListView lv_QuestionList;
    private LinearLayoutManager mManager;

    private View rootView;
    private List<QuestionModel> latestQuestionsList;

    QuestionModel questionModel;
    private ProgressDialog pd;
    SwipeRefreshLayout swipeRefreshLayout;

    private LatestQuestionsViewModel latestQuestionsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //  latestQuestionsViewModel = ViewModelProviders.of(this).get(LatestQuestionsViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_latest_questions, container, false);

        //mRecycler = rootView.findViewById(R.id.messages_list);
        lv_QuestionList = rootView.findViewById(R.id.lv_QuestionList);
        latestQuestionsList = Tools.getNotAnsweredList();

        swipeRefreshLayout = rootView.findViewById(R.id.swipeRefresh);
        // mRecycler.setHasFixedSize(true);

        adapter = new LatestQuestionAdapter(getActivity(), latestQuestionsList);
        lv_QuestionList.setAdapter(adapter);
        lv_QuestionList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (latestQuestionsList != null && latestQuestionsList.size() > 0) {
                            TextView email = view.findViewById(R.id.tv_HiddenEmail);
                            Toast.makeText(getActivity(), latestQuestionsList.get(position).questionTitle, Toast.LENGTH_SHORT).show();

                        }
                    }
                }
        );

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                Toast.makeText(getActivity(), "Feature will coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}