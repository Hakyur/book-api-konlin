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
import ru.rogotovskiy.book_api.dto.GenreDto
import ru.rogotovskiy.book_api.service.GenreService

@RestController
@RequestMapping("/genre")
class GenreController (
    private val service: GenreService
) {

    @GetMapping("/get/all")
    fun getAllGenres(): ResponseEntity<Any> = ResponseEntity.ok(service.getAllGenres())

    @GetMapping("/get")
    fun getGenre(@RequestParam id: Long): ResponseEntity<Any> = ResponseEntity.ok(
        service.getById(id)
    )

    @PostMapping("/create")
    fun createGenre(@RequestBody dto: GenreDto): ResponseEntity<Any> = ResponseEntity.ok(
        service.createGenre(dto)
    )

    @DeleteMapping("/delete")
    fun deleteGenre(@RequestParam id: Long): ResponseEntity<Any> {
        service.deleteGenre(id)
        return ResponseEntity.ok("Жанр успешно удалён")
    }

    @PutMapping("/update")
    fun updateGenre(@RequestParam id: Long, @RequestBody dto: GenreDto): ResponseEntity<Any> =
        ResponseEntity.ok(service.updateGenre(id, dto))
}