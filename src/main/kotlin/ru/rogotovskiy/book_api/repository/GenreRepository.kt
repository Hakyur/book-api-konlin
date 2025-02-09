package ru.rogotovskiy.book_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.rogotovskiy.book_api.entity.Genre

@Repository
interface GenreRepository : JpaRepository<Genre, Long> {
    fun existsByName(name: String): Boolean
}