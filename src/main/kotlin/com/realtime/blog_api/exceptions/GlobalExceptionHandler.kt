package com.realtime.blog_api.exceptions

import com.realtime.blog_api.payloads.ApiResponce
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundExceptionHandler(exception: ResourceNotFoundException): ResponseEntity<ApiResponce> {
        return ResponseEntity(ApiResponce(exception.message.toString(), false), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(exception : MethodArgumentNotValidException) : ResponseEntity<Map<String, String>> {
        val response = HashMap<String, String>()
        exception.bindingResult.allErrors.forEach { error: ObjectError ->
            val fieldName : String = (error as FieldError).field
            val message : String = error.defaultMessage.toString()
            response[fieldName] = message
        }
        return ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST)
    }

}