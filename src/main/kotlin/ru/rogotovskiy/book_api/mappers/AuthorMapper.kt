package ru.rogotovskiy.book_api.mappers

import org.springframework.stereotype.Component
import ru.rogotovskiy.book_api.dto.AuthorDto
import ru.rogotovskiy.book_api.entity.Author

@Component
class AuthorMapper {

    fun toDto(author: Author): AuthorDto {
        return AuthorDto(
            id = author.id,
            fullName = author.fullName
        )
    }

    fun toEntity(dto: AuthorDto): Author {
        return Author(fullName = dto.fullName)
    }
}
