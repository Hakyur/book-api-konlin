package ru.rogotovskiy.book_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.rogotovskiy.book_api.entity.Genre

interface GenreRepository : JpaRepository<Genre, Long> {
}