package com.sopan.navigationdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sopan.navigationdemo.R;
import com.sopan.navigationdemo.model.QuestionModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GridViewAdapter extends ArrayAdapter<QuestionModel> {

    public GridViewAdapter(@NonNull Context context, List<QuestionModel> contactList) {
        super(context, R.layout.categories_grid_item, contactList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.categories_grid_item, parent, false);
        // View customView = inflater.inflate(R.layout.custom_latest_q_list_row, parent, false);
        QuestionModel questionModel = getItem(position);

        TextView tvTagTitle = customView.findViewById(R.id.tvTagTitle);
        TextView tvQuestionNo = customView.findViewById(R.id.tvQuestionNo);

        tvTagTitle.setText(questionModel.questionTitle);
        tvQuestionNo.setText(questionModel.questionDetails);

        return customView;
    }

}
