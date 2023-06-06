package com.example.management.model.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class BaseResponse<T>(
    val isError: Boolean,
    val errorMessage: String? = null,
    val data: T? = null,
    val code: Int
){
    companion object {
        fun <T> createResponse(
            message: String = "Credenciais Inválidas!",
            code: HttpStatus = HttpStatus.UNAUTHORIZED,
            data: T? = null,
            isError: Boolean = true
        ): ResponseEntity<BaseResponse<T>> {
            return if (isError) {
                ResponseEntity.status(code).body(
                    BaseResponse(
                        isError = true,
                        errorMessage = message,
                        code = code.value()
                    )
                )
            } else {
                ResponseEntity.ok(
                    BaseResponse(
                        isError = false,
                        data = data,
                        code = code.value()
                    )
                )
            }
        }
    }
}
