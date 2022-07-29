package com.l3udy.junit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.l3udy.junit.R
import com.l3udy.junit.model.ApiResult
import com.l3udy.junit.utils.Validator

/*
 *  LoginViewModel
 *  - ViewModel that updates the LoginActivity (the visible UI)
 *  - Gets the data from model
 */
class LoginViewModel : ViewModel() {

    // Create MutableLiveData which LoginActivity can subscribe to
    // When this data changes, it triggers the UI to do an update
    val loginResult = MutableLiveData<ApiResult>()

    fun login(email: String, password: String) {
        if (email.isEmpty() && password.isEmpty()) {
            loginResult.value = ApiResult(error = R.string.login_error_email_password_empty)
        } else if (email.isEmpty()) {
            loginResult.value = ApiResult(error = R.string.login_error_email_empty)
        } else if (!Validator.isValidEmail(email)) {
            loginResult.value = ApiResult(error = R.string.login_error_email_not_valid)
        } else if (password.isEmpty()) {
            loginResult.value = ApiResult(error = R.string.login_error_password_empty)
        } else if (!Validator.isValidPassword(password)) {
            loginResult.value = ApiResult(error = R.string.login_error_password_greater_the_5_char)
        } else {
            loginResult.value = ApiResult(success = true)
        }
    }
}