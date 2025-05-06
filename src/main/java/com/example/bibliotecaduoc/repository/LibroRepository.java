package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {

    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerLibros(){

        return listaLibros;
    }

    public Libro buscarPorId(int id){

        for (Libro libro : listaLibros) {
            if (libro.getId() == id){
                return libro;
            }
        }

        return null;
    }

    public Libro buscarPorIsbn(String isbn){

        for (Libro libro : listaLibros) {
            if(libro.getIsbn() == isbn){
                return libro;
            }
        }
        return null;
    }

    public Libro guardarLibro(Libro nuevoLibro){
        for (Libro libro : listaLibros) {
            if(libro.getId() == nuevoLibro.getId()){
                System.out.println("El libro ya existe!");
                return null;
            }
        }
        listaLibros.add(nuevoLibro);
        System.out.println("Libro agregado!");
        return nuevoLibro;
    }

    public Libro actualizarLibro(Libro nuevoLibro){
        for (Libro libro : listaLibros) {
            if(libro.getId() == nuevoLibro.getId()){
                libro.setId(nuevoLibro.getId());
                libro.setTitulo(nuevoLibro.getTitulo());
                libro.setAuthor(nuevoLibro.getAuthor());
                libro.setFechaPublicacion(nuevoLibro.getFechaPublicacion());
                libro.setEditorial(nuevoLibro.getEditorial());
                libro.setIsbn(nuevoLibro.getIsbn());
                return libro;
            }
        }
        System.out.println("El libro no existe!, usar guardar libro!");
        return null;
    }

    public void eliminarLibro(Libro libro){
        Libro libroEliminar = this.buscarPorId(libro.getId());
        if (libroEliminar != null){
            this.listaLibros.remove(libroEliminar);
            System.out.println("Libro eliminado");
        } else {
            System.out.println("Libro no existe!");
        }
    }

}
