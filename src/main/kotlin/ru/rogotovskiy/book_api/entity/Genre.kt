package ru.rogotovskiy.book_api.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "genres")
class Genre() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, unique = true)
    lateinit var name: String

    @Column(columnDefinition = "TEXT")
    var description: String? = null

    @OneToMany(mappedBy = "genre", cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE], orphanRemoval = true)
    var books: MutableList<Book> = mutableListOf()

    constructor(name: String, description: String?): this() {
        this.name = name
        this.description = description
    }
}