package com.l3udy.junit.model

/**
 * Authentication result : success (true) or error message.
 */
data class ApiResult(
    val success: Boolean? = null,
    val error: Int? = null,
    val errorMessage: String? = null
)