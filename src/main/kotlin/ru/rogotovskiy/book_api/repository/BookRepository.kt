package ru.rogotovskiy.book_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.rogotovskiy.book_api.entity.Book

interface BookRepository : JpaRepository<Book, Long> {
}