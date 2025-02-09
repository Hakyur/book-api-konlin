package ru.rogotovskiy.book_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.rogotovskiy.book_api.entity.Book

@Repository
interface BookRepository : JpaRepository<Book, Long> {
}