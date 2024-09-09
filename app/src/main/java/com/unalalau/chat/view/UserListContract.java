package com.unalalau.chat.view;

import java.util.List;

import com.unalalau.chat.model.UserModel;

public interface UserListContract {

    void displayUsers(List<UserModel> users);

    void showError(String message);
}