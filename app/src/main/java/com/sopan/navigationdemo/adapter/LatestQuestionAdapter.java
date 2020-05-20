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

public class LatestQuestionAdapter extends ArrayAdapter<QuestionModel> {

    public LatestQuestionAdapter(@NonNull Context context, List<QuestionModel> contactList) {
        super(context, R.layout.item_post, contactList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.item_post, parent, false);
       // View customView = inflater.inflate(R.layout.custom_latest_q_list_row, parent, false);
        QuestionModel questionModel = getItem(position);

        TextView post_author = customView.findViewById(R.id.post_author);
        TextView post_title = customView.findViewById(R.id.post_title);
        TextView post_body = customView.findViewById(R.id.post_body);
        TextView post_created = customView.findViewById(R.id.post_created);
        TextView post_comment = customView.findViewById(R.id.post_comment);
        TextView post_answered = customView.findViewById(R.id.post_answered);

        post_author.setText(questionModel.userId);

        post_title.setText(questionModel.questionTitle);
        post_created.setText(questionModel.quetionAuthor);

        if(questionModel.questionAnswer.equalsIgnoreCase("0")){
            post_answered.setText("+ Add Answer");
        } else {
            post_answered.setText("Answered");
        }

        post_body.setText(questionModel.questionDetails);
        post_comment.setText(questionModel.questionAnswer);
        return customView;
    }

}
