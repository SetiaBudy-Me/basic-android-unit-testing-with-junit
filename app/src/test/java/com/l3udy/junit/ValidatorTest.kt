package com.l3udy.junit

import com.google.common.truth.Truth.assertThat
import com.l3udy.junit.utils.Validator
import org.junit.Test

class ValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(Validator.isValidEmail("name@email.com")).isTrue()
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertThat(Validator.isValidEmail("name@email.co.uk")).isTrue()
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertThat(Validator.isValidEmail("name@email")).isFalse()
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertThat(Validator.isValidEmail("name@email..com")).isFalse()
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertThat(Validator.isValidEmail("@email.com")).isFalse()
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertThat(Validator.isValidEmail("")).isFalse()
    }

    @Test
    fun passwordValidator_CorrectPassword_ReturnsTrue() {
        assertThat(Validator.isValidPassword("qwerty")).isTrue()
    }

    @Test
    fun passwordValidator_InvalidPassword_ReturnsFalse() {
        assertThat(Validator.isValidPassword("qwert")).isFalse()
        assertThat(Validator.isValidPassword("qwer")).isFalse()
        assertThat(Validator.isValidPassword("qwe")).isFalse()
        assertThat(Validator.isValidPassword("qw")).isFalse()
        assertThat(Validator.isValidPassword("q")).isFalse()
    }

    @Test
    fun passwordValidator_EmptyString_ReturnsFalse() {
        assertThat(Validator.isValidPassword("")).isFalse()
    }

}