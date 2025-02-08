package ru.rogotovskiy.book_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.rogotovskiy.book_api.entity.Author

interface AuthorRepository : JpaRepository<Author, Long> {
}