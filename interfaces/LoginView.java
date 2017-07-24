package edu.galileo.mvp.interfaces;

/**
 * Created by ShadowRunner on 7/11/2017.
 */

public interface LoginView {
    void showProgress(Boolean showProgress);
    void setUsernameError(int msgId);
    void setPasswordError(int msgId);
    void successAction();
}
