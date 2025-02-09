package ru.rogotovskiy.book_api.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.rogotovskiy.book_api.exceptions.DuplicateObjectException
import ru.rogotovskiy.book_api.exceptions.ObjectNotFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException::class)
    fun handleObjectNotFoundException(e: ObjectNotFoundException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(DuplicateObjectException::class)
    fun handleDuplicateObjectException(e: DuplicateObjectException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
}