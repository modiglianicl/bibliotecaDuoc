package com.example.bibliotecaduoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    
    public List<Libro> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public Libro getLibroId(int id){
        return libroRepository.buscarPorId(id);
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.guardarLibro(libro);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizarLibro(libro);
    }

    public String deleteLibro(Libro libro){
        libroRepository.eliminarLibro(libro);
        
        return "Libro eliminado";
    }
}
