package ru.rogotovskiy.book_api.mappers

import org.springframework.stereotype.Component
import ru.rogotovskiy.book_api.dto.GenreDto
import ru.rogotovskiy.book_api.entity.Genre

@Component
class GenreMapper {

    fun toDto(genre: Genre): GenreDto {
        return GenreDto(
            id = genre.id,
            name = genre.name,
            description = genre.description
        )
    }

    fun toEntity(genreDto: GenreDto): Genre {
        return Genre(
            name = genreDto.name,
            description = genreDto.description
        )
    }
}