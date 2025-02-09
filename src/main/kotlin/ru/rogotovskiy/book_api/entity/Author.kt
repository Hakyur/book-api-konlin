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
@Table(name = "authors")
class Author() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, name = "full_name")
    lateinit var fullName: String

    @OneToMany(mappedBy = "author", cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE], orphanRemoval = true)
    var books: MutableList<Book> = mutableListOf()

    constructor(fullName: String): this() {
        this.fullName = fullName
    }
}