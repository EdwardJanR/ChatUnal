package com.unalalau.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import com.unalalau.chat.R;
import com.unalalau.chat.model.UserModel;

public class UserAdapter extends ArrayAdapter<UserModel> {
    private Context context;
    private List<UserModel> users;

    private ChatButtonClickListener chatButtonClickListener;

    public UserAdapter(Context context, List<UserModel> users, ChatButtonClickListener listener) {
        super(context, 0, users);
        this.context = context;
        this.users = users;
        this.chatButtonClickListener = listener;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        UserModel user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewEmail = convertView.findViewById(R.id.textViewEmail);
        Button buttonChat = convertView.findViewById(R.id.buttonChat);

        if (user != null) {
            textViewName.setText(user.getName());
            textViewEmail.setText(user.getEmail());

            buttonChat.setOnClickListener(v -> {
                if (chatButtonClickListener != null) {
                    chatButtonClickListener.onChatButtonClick(user);
                }
            });
        }
        return convertView;
    }

    public interface ChatButtonClickListener {
        void onChatButtonClick(UserModel user);
    }
}