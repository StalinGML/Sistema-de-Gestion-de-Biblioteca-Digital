package com.mycompany.sistemadegestionbibliotecadigital;

import java.util.Objects;

public final class Libro {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String categoria;

    // Constructor que inicializa todos los atributos y valida que no sean nulos o vacíos.
    public Libro(String isbn, String titulo, String autor, String categoria) {
        if (isbn == null || isbn.trim().isEmpty() || titulo == null || titulo.trim().isEmpty() ||
            autor == null || autor.trim().isEmpty() || categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Todos los campos del libro deben ser no nulos y no vacíos.");
        }
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Métodos 'get' para acceder a los atributos, ya que son privados.
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    // Sobreescribe toString() para una representación legible del objeto.
    @Override
    public String toString() {
        return "Libro{" +
               "isbn='" + isbn + '\'' +
               ", titulo='" + titulo + '\'' +
               ", autor='" + autor + '\'' +
               ", categoria='" + categoria + '\'' +
               '}';
    }

    // Sobreescribe equals() y hashCode() para que los libros sean comparados por su ISBN.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}