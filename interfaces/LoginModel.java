package edu.galileo.mvp.interfaces;

/**
 * Created by ShadowRunner on 7/11/2017.
 */

public interface LoginModel {

    interface OnLoginFinishListener {
        void onCanceled();

        void onPasswordError();

        void onSuccess();
    }
    void login(String username, String password, OnLoginFinishListener loginFinishListener);
}
