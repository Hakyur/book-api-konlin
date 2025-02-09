package ru.rogotovskiy.book_api.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.rogotovskiy.book_api.dto.AuthorDto
import ru.rogotovskiy.book_api.entity.Author
import ru.rogotovskiy.book_api.exceptions.AuthorNotFoundException
import ru.rogotovskiy.book_api.mappers.AuthorMapper
import ru.rogotovskiy.book_api.repository.AuthorRepository

@Service
class AuthorService(
    private val repository: AuthorRepository,
    private val mapper: AuthorMapper
) {

    fun getAllAuthors(): List<AuthorDto> = repository.findAll().map { mapper.toDto(it) }

    fun getAuthorById(id: Long): Author = repository.findByIdOrNull(id)
        ?: throw AuthorNotFoundException("Автор с id = $id не найден!")

    fun getById(id: Long): AuthorDto = mapper.toDto(getAuthorById(id))

    fun createAuthor(dto: AuthorDto): AuthorDto = mapper.toDto(
        repository.save(mapper.toEntity(dto))
    )

    fun deleteAuthor(id: Long) {
        if (!repository.existsById(id)) throw AuthorNotFoundException("Автор с id = $id не найден!")
        repository.deleteById(id)
    }

    fun updateAuthor(id: Long, dto: AuthorDto): AuthorDto {
        val author = getAuthorById(id)
        author.fullName = dto.fullName
        return mapper.toDto(repository.save(author))
    }

}