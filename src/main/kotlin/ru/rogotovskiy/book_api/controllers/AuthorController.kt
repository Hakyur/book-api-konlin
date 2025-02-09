package ru.rogotovskiy.book_api.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.rogotovskiy.book_api.dto.AuthorDto
import ru.rogotovskiy.book_api.service.AuthorService

@RestController
@RequestMapping("/author")
class AuthorController(private val service: AuthorService) {

    @GetMapping("/get/all")
    fun getAllAuthors(): ResponseEntity<Any> = ResponseEntity.ok(service.getAllAuthors())

    @GetMapping("/get")
    fun getAuthor(@RequestParam id: Long): ResponseEntity<Any> =
        ResponseEntity.ok(service.getById(id))

    @PostMapping("/create")
    fun createAuthor(@RequestBody dto: AuthorDto): ResponseEntity<Any> =
        ResponseEntity.ok(service.createAuthor(dto))

    @DeleteMapping("/delete")
    fun deleteAuthor(@RequestParam id: Long): ResponseEntity<Any> {
        service.deleteAuthor(id)
        return ResponseEntity.ok("Автор успешно удалён")
    }

    @PutMapping("/update")
    fun updateAuthor(@RequestParam id: Long, @RequestBody dto: AuthorDto): ResponseEntity<Any> =
        ResponseEntity.ok(service.updateAuthor(id, dto))
}