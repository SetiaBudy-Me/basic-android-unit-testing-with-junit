package com.l3udy.junit

import com.l3udy.junit.viewmodel.LoginViewModel
import org.junit.Test

class LoginViewModelTest {
    private val loginViewModel = LoginViewModel()

    /*
    @Test -> annotation specifies that method is the test method.
    @Test(timeout=1000) -> annotation specifies that method will be failed if it takes longer than 1000 milliseconds (1 second).
    @BeforeClass -> annotation specifies that method will be invoked only once, before starting all the tests.
    @Before -> annotation specifies that method will be invoked before each test.
    @After -> annotation specifies that method will be invoked after each test.
    @AfterClass -> annotation specifies that method will be invoked only once, after finishing all the tests.
     */

    @Test
    fun login_isSuccess() {
        //print("log: ${R.string.login_error_email_password_empty}\n")
        //print("log: ${loginViewModel.login("", "")}\n")

        //Log.d("SetBud", "X: ${R.string.login_error_email_password_empty}, Y: ${loginViewModel.login("", "")}")

        //Assert.assertEquals(R.string.login_error_email_password_empty, loginViewModel.login("", ""))
    }

    @Test
    fun login_isFailed() {

    }
}