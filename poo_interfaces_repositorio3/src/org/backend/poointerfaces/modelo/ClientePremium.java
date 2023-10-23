package org.backend.poointerfaces.modelo;

public class ClientePremium extends Cliente implements Comparable<ClientePremium> {
    public ClientePremium(String nombre, String apellido) {
        super(nombre, apellido);
    }

    /*EN ESTE EJEMPLO, compareTo(), NO CUMPLE NINGUNA FUNCIÓN, SOLAMENTE ES A MANERA DEMOSTRATIVA*/
    @Override
    public int compareTo(ClientePremium o) {
        return 0;
    }
}
