package com.mycompany.sistemadegestionbibliotecadigital;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private final String id;
    private final String nombre;
    private final List<String> isbnsPrestados;

    // Constructor que valida y asigna ID y nombre, e inicializa la lista de préstamos.
    public Usuario(String id, String nombre) {
        if (id == null || id.trim().isEmpty() || nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID y el nombre del usuario deben ser no nulos y no vacíos.");
        }
        this.id = id;
        this.nombre = nombre;
        this.isbnsPrestados = new ArrayList<>();
    }

    // Getters para acceder a los atributos.
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // Devuelve una copia de la lista para proteger la encapsulación.
    public List<String> getIsbnsPrestados() {
        return new ArrayList<>(isbnsPrestados);
    }

    // Métodos para gestionar la lista de libros prestados.
    public void agregarLibroPrestado(String isbn) {
        isbnsPrestados.add(isbn);
    }

    public void quitarLibroPrestado(String isbn) {
        isbnsPrestados.remove(isbn);
    }
    
    // Sobreescribe toString(), equals() y hashCode() para una correcta representación y comparación.
    @Override
    public String toString() {
        return "Usuario{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", isbnsPrestados=" + isbnsPrestados +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}