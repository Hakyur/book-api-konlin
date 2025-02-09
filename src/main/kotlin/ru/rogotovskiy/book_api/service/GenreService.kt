package ru.rogotovskiy.book_api.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.rogotovskiy.book_api.dto.GenreDto
import ru.rogotovskiy.book_api.entity.Genre
import ru.rogotovskiy.book_api.exceptions.DuplicateGenreException
import ru.rogotovskiy.book_api.exceptions.GenreNotFoundException
import ru.rogotovskiy.book_api.mappers.GenreMapper
import ru.rogotovskiy.book_api.repository.GenreRepository

@Service
class GenreService(
    private val repository: GenreRepository,
    private val mapper: GenreMapper
) {

    fun getAllGenres(): List<GenreDto> =
        repository.findAll().map { mapper.toDto(it) }

    fun getGenreById(id: Long): Genre = repository.findByIdOrNull(id)
        ?: throw GenreNotFoundException("Жанр с id = $id не найден!")

    fun getById(id: Long): GenreDto = mapper.toDto(getGenreById(id))

    fun createGenre(dto: GenreDto): GenreDto {
        if (repository.existsByName(dto.name)) {
            throw DuplicateGenreException("Жанр с названием \"${dto.name}\" уже существует!")
        }
        val genre = repository.save(mapper.toEntity(dto))
        return mapper.toDto(genre)
    }

    fun deleteGenre(id: Long) {
        if (!repository.existsById(id)) throw GenreNotFoundException("Жанр с id = $id не найден!")
        repository.deleteById(id)
    }

    fun updateGenre(id: Long, dto: GenreDto): GenreDto {
        val genre = getGenreById(id)
        if (!dto.name.isEmpty()) {
            if (repository.existsByName(dto.name)) {
                throw DuplicateGenreException("Жанр с названием \"${dto.name}\" уже существует!")
            }
            genre.name = dto.name
        }
        if (dto.description != null && !dto.description.isEmpty()) {
            genre.description = dto.description
        }
        return mapper.toDto(repository.save(genre))
    }
}