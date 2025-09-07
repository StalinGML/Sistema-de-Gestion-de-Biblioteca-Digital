package com.mycompany.sistemadegestionbibliotecadigital;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private final Map<String, Libro> catalogoPorIsbn;
    private final Map<String, Usuario> usuariosPorId;
    private final Set<String> isbnsPrestados;

    public Biblioteca() {
        // Inicializa colecciones vacías
        this.catalogoPorIsbn = new HashMap<>();
        this.usuariosPorId = new HashMap<>();
        this.isbnsPrestados = new HashSet<>();
    }

    // Añade un libro al catálogo
        public void añadirLibro(Libro libro) {
        catalogoPorIsbn.put(libro.getIsbn(), libro);
        System.out.println("Libro añadido: [" + libro.getIsbn() + "] " + libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getCategoria());
    }

    // Registra un usuario
    public void registrarUsuario(Usuario u) {
        usuariosPorId.put(u.getId(), u);
        System.out.println("Usuario registrado: " + u.getNombre());
    }

    // Presta un libro a un usuario
    public void prestarLibro(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = catalogoPorIsbn.get(isbn);

        if (usuario != null && libro != null && !isbnsPrestados.contains(isbn)) {
            usuario.agregarLibroPrestado(isbn);
            isbnsPrestados.add(isbn);
        }
    }

    // Devuelve un libro prestado
    public void devolverLibro(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        if (usuario != null && usuario.getIsbnsPrestados().contains(isbn)) {
            usuario.quitarLibroPrestado(isbn);
            isbnsPrestados.remove(isbn);
        }
    }

    // Busca libros por autor
    public List<Libro> buscarPorAutor(String texto) {
        return catalogoPorIsbn.values().stream()
                .filter(l -> l.getAutor().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Busca libros por categoría
    public List<Libro> buscarPorCategoria(String texto) {
        return catalogoPorIsbn.values().stream()
                .filter(l -> l.getCategoria().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Lista los libros prestados a un usuario
    public List<Libro> listarPrestados(String idUsuario) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        if (usuario == null) return List.of();
        return usuario.getIsbnsPrestados().stream()
                .map(catalogoPorIsbn::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}