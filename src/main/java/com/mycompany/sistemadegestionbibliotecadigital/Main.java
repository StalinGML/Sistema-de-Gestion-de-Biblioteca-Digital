package com.mycompany.sistemadegestionbibliotecadigital;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("=== Sistema de Gestión de Biblioteca Digital ===\n");

        // Registrar usuarios
        System.out.println("--- Registrando usuarios ---");
        biblioteca.registrarUsuario(new Usuario("U1", "Ana"));
        biblioteca.registrarUsuario(new Usuario("U2", "Luis"));

        // Añadir libros al catálogo
        System.out.println("\n--- Añadiendo libros ---");
        biblioteca.añadirLibro(new Libro("ISBN-001", "Clean Code", "Robert C. Martin", "Software"));
        biblioteca.añadirLibro(new Libro("ISBN-002", "Effective Java", "Joshua Bloch", "Java"));

        // Prestar libros
        System.out.println("\n--- Libros prestados---");
        biblioteca.prestarLibro("U1", "ISBN-001");
        List<Libro> prestadosAna = biblioteca.listarPrestados("U1");
        for (Libro l : prestadosAna) {
            System.out.println("Libros prestados a Ana: " +
                    l.getIsbn() + " - " + l.getTitulo() + ", " + l.getAutor() + " - " + l.getCategoria());
        }

        // Devolver libros
        System.out.println("\n--- Libros devueltos---");
        biblioteca.devolverLibro("U1", "ISBN-001");
        System.out.println("Libro devuelto por Ana: ISBN-001");

        // Buscar libros por autor
        System.out.println("\n--- Buscando por autor 'Bloch' ---");
        List<Libro> librosPorAutor = biblioteca.buscarPorAutor("Bloch");
        for (Libro l : librosPorAutor) {
            System.out.println("Libro: " + l.getIsbn() + " - " + l.getTitulo() + ", " + l.getAutor() + " - " + l.getCategoria());
        }

        // Buscar libros por categoría
        System.out.println("\n--- Buscando por categoría 'Software' ---");
        List<Libro> librosPorCategoria = biblioteca.buscarPorCategoria("Software");
        for (Libro l : librosPorCategoria) {
            System.out.println("Libro: " + l.getIsbn() + " - " + l.getTitulo() + ", " + l.getAutor() + " - " + l.getCategoria());
        }
    }
}
