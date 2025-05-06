package com.example.bibliotecaduocv2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduocv2.model.Libro;
import com.example.bibliotecaduocv2.repository.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.guardaLibro(libro);
    }

    public Libro getLibroid(int id){
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizarLibro(libro);
    }

    public Libro buscarPorIsbn(String isbn){
        return libroRepository.buscarPorIsbn(isbn);
    }

    public int librosPorAnio(int anio){
        List<Libro> libros = libroRepository.obtenerLibros();
        int contador = 0;
        for (Libro libro : libros) {
            if(libro.getFechaPublicacion() == anio){
                contador++;
            }
        }
        return contador;
    }

    public List<Libro> libroPorAutor(String autor){
        List<Libro> libros = libroRepository.obtenerLibros();
        List<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : libros) {
            if(libro.getAutor().equals(autor)){
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    // LA ACCION LA HACE EL SERVICE
    public int totalLibros(){
        return libroRepository.obtenerLibros().size();
    }

    // LA ACCION LA HACE EL MODELO
    public int totalLibrosV2(){
        return libroRepository.totalLibros();
    }

    public String deleteLibro(int id){
        libroRepository.eliminarLibro(id);
        return "Libro eliminado";
    }

}
