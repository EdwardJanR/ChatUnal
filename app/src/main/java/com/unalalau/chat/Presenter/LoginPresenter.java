package com.unalalau.chat.Presenter;

import com.google.firebase.auth.FirebaseUser;

import com.unalalau.chat.model.LoginModel;

import com.unalalau.chat.view.LoginContract;



public class LoginPresenter {
    private LoginContract.View view;
    private LoginModel model;


    public LoginPresenter(LoginContract.View view, LoginModel model) {
        this.view = view;
        this.model = model;
    }


    public void loginUser() {
        String email = view.getEmail();
        String password = view.getPassword();

        if (email.isEmpty() || password.isEmpty()) {
            view.showToast("Por favor, completa todos los campos");
            return;
        }

        model.loginUser(email, password, new LoginModel.LoginCallback() {
            @Override
            public void onSuccess(FirebaseUser user) {
                view.showToast("Inicio de sesión exitoso");
                view.navigateToHome();
            }

            @Override
            public void onFailure(Exception e) {
                view.showToast("Error de inicio de sesión: " + e.getMessage());
            }
        });
    }
}