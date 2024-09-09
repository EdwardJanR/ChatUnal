package com.unalalau.chat.view;

public interface LoginContract {

    interface View {

        void showToast(String message);

        void navigateToHome();

        String getEmail();

        String getPassword();
    }
}
