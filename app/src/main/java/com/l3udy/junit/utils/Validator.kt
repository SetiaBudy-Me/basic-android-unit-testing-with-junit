package com.l3udy.junit.utils

import java.util.regex.Pattern

object Validator {

    fun isValidEmail(value: String): Boolean {
        val emailPattern = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val pattern: Pattern = Pattern.compile(emailPattern)
        val matcher = pattern.matcher(value)
        return matcher.matches()
    }

    fun isValidPassword(value: String): Boolean {
        return value.length > 5
    }
}