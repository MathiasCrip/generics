package org.backend.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*CLASE GENERICA*/
public class Camion<T> implements Iterable<T> {

    /*LISTA CON TIPO DE DATOS GENERICOS*/
    private List<T> objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    /*METODO QUE AGREGA CUALQUIER TIPO DE OBJECTO, HASTA QUE SE CUMPLA LA CONDICION MAX*/
    public void add(T objeto){
        if(this.objetos.size() <= max) {
            this.objetos.add(objeto);
        } else {
            throw new RuntimeException("no hay más espacio.");
        }
    }

    /*SE SOBREESCRIBE EL METODO ITERATOR() PARA RECORRER LA LISTA DE OBJETOS*/
    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
