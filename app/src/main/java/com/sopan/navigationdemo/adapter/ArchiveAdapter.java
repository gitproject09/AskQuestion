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

public class ArchiveAdapter extends ArrayAdapter<QuestionModel> {

    public ArchiveAdapter(@NonNull Context context, List<QuestionModel> contactList) {
        super(context, R.layout.archive_item, contactList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.archive_item, parent, false);
        // View customView = inflater.inflate(R.layout.custom_latest_q_list_row, parent, false);
        QuestionModel questionModel = getItem(position);

        TextView tvMonth = customView.findViewById(R.id.tvMonth);
        TextView tvYear = customView.findViewById(R.id.tvYear);

        tvMonth.setText(questionModel.questionTitle);
        tvYear.setText(questionModel.questionDetails);

        return customView;
    }

}
