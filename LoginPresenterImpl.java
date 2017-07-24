package edu.galileo.mvp;

import android.text.TextUtils;

import edu.galileo.mvp.interfaces.LoginModel;
import edu.galileo.mvp.interfaces.LoginPresenter;
import edu.galileo.mvp.interfaces.LoginView;

/**
 * Created by ShadowRunner on 7/11/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginModel.OnLoginFinishListener {
    private LoginView loginView;
    private LoginModelImpl loginModel = new LoginModelImpl();

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    @Override
    public void validateCredentials(String username, String password) {

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            loginView.setPasswordError(R.string.error_invalid_password);
        }

        // Check for a valid username address.
        if (TextUtils.isEmpty(username)) {
            loginView.setUsernameError(R.string.error_field_required);
        } else if (!isEmailValid(username)) {
            loginView.setUsernameError(R.string.error_invalid_email);
        }
        loginView.showProgress(true);
        loginModel.login(username, password, this);
    }

    @Override
    public void onCanceled() {
        loginView.showProgress(false);
    }

    @Override
    public void onPasswordError() {
        loginView.showProgress(false);
        loginView.setPasswordError(R.string.error_incorrect_password);
    }

    @Override
    public void onSuccess() {
        loginView.showProgress(false);
        loginView.successAction();
    }
}
