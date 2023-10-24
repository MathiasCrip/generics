package org.backend.generics;

import org.backend.poointerfaces.modelo.Cliente;
import org.backend.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        /*MANERA COMUN DE DECLARAR UNA LISTA DE UN TIPO DE DATO*/
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Fernando", "Pereyra"));

        Cliente[] clientesArreglo = {new Cliente("Luci", "Martínez"),
                new Cliente("Andres", "Lázaro")};
        Integer[] enterosArreglo = {1, 2, 3};

        /*SE CREA UN LIST<CLIENTE> DE CLIENTES A PARTIR DE UN ARRAY */
        List<Cliente> clientesLista = pasarArrayAlista(clientesArreglo);
        /*SE CREA UN LIST<INTEGER> DE MUMEROS A PARTIR DE UN ARRAY */
        List<Integer> enterosLista = pasarArrayAlista(enterosArreglo);

        /*SE RECORREN LAS DOS LISTAS*/
        clientesLista.forEach(s -> System.out.print(s + " "));

        System.out.println("\n--------------------------------------------");

        enterosLista.forEach(s -> System.out.print(s + " "));

        System.out.println("\n--------------------------------------------");

        /*SE CREA UN LIST<STRING> DE NOMBRES A PARTIR DE UN ARRAY E IMPRIME,
         TANTO EL LIST CREADO, COMO  EL SEGUNDO PARAMETRO (enterosArreglo) */
        List<String> nombres = pasarArrayAlista(new String[]{"Andrés", "Pepe",
                "Luci", "Bea", "Jair"}, enterosArreglo);
        System.out.println("\n--------------------------------------------");

        /*SE RECORRE LA LISTA MEDIANTE EL FOREACH*/
        nombres.forEach(n -> System.out.print(n + " "));


        /*SE CREA UN LIST<CLIENTEPREMIUM> DE CLIENTES PREMIUM A PARTIR DE UN ARRAY */
        List<ClientePremium> clientesPremiumList = pasarArrayAlista(
                new ClientePremium[]{new ClientePremium("Paco", "Fernández")});

        System.out.println("\n--------------------------------------------");

        /*SE INVOCA EL METODO STATICO imprimirClientes(lIST<? EXTENDS CLIENTE>), recibe cualquier instancia de tipo Cliente*/
        imprimirClientes(clientes);
        System.out.println("\n--------------------------------------------");
        imprimirClientes(clientesLista);
        System.out.println("\n--------------------------------------------");
        imprimirClientes(clientesPremiumList);
        System.out.println("\n--------------------------------------------");

        /*INVOCA EL METODO STATICO maximo(T a, T b, T c), donde reciben 3 parametros de tipo generico
        y retorna tambien un tipo T generico. Hace una comparacion de valores y retorna el mas alto*/

        System.out.println("Máximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Máximo de 3.9, 11.6, 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Máximo de zanahoria, arándanos, manzana es: "
                + maximo("zanahoria", "arándano", "manzana"));
        System.out.println("\n--------------------------------------------");

    }

    /*METODO QUE TRANSFORMA CUALQUIER TIPO DE ARRAY A UN TIPO LISTA*/
    public static <T> List<T> pasarArrayAlista(T[] c) {
        return Arrays.asList(c);
    }

    /*METODO QUE TRANSFORMA CUALQUIER TIPO DE ARRAY QUE EXTIENDA DE NUMBER, A UN TIPO LISTA*/
    public static <T extends Number> List<T> pasarArrayAlista(T[] c) {
        return Arrays.asList(c);
    }

    /*METODO QUE TRANSFORMA CUALQUIER TIPO DE ARRAY QUE EXTIENDA DE CLIENTE E IMPLEMENTE
     LA INTERFAZ COMPARABLE, A UN TIPO LISTA*/
    public static <T extends Cliente & Comparable<T>> List<T> pasarArrayAlista(T[] c) {
        return Arrays.asList(c);
    }

    /*METODO DE TIPO DE DOS GENERICOS <T,G> QUE RECORRE UN ARRAY DE TIPO G Y LO IMPRIME,
     * MIENTRAS QUE TRANSFORMA EL DE TIPO T A UN TIPO LIST*/
    public static <T, G> List<T> pasarArrayAlista(T[] t, G[] g) {
        for (G elemento : g) {
            System.out.print(elemento + " ");
        }
        return Arrays.asList(t);
    }

    /*METODO QUE IMPRIME ALGUN TIPO DE LISTADO, QUE EXTIENDA DE CLIENTE*/
    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(c -> System.out.print(c + " "));
    }

    /*METODO QUE COMPARA UN TIPO DE DATO SIEMPRE Y CUANDO, IMPLEMENTE COMPARABLE<T>, RETORNA UN TIPO GENERICO T
     * Y TAMBIEN RECIBE 3 PARAMETROS GENERICOS T. RETORNA EL VALOR MAS ALTO O GRANDE*/
    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
