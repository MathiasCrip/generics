package org.backend.genericsclass;


/*ESTA CLASE EMULA A UN CAMION DE CARGA QUE TRANSPORTA DISTINTOS TIPOS DE OBJETOS, EN ESTE CASO,
ANIMALES, AUTOMOVILES Y MAQUINARIAS*/
public class EjemploGenericos {

    /*IMPRIME EL LISTADO DE OBJETOS DEPENDIENDO LA INSTANCIA*/
    public static <T> void imprimirCamion(Camion<T> camion){
        for(T a: camion){
            if(a instanceof Animal) {
                System.out.println(((Animal)a).getNombre() + " tipo: " + ((Animal)a).getTipo());
            }
            else if(a instanceof Automovil){
                System.out.println(((Automovil)a).getMarca());
            } else if(a instanceof Maquinaria){
                System.out.println(((Maquinaria)a).getTipo());
            }
        }
    }
    public static void main(String[] args) {

        /*SE PASA POR PARAMETROS LA CANTIDAD MAXIMA A TRANSPORTAR*/
        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        imprimirCamion(transporteCaballos);

        /*SE PASA POR PARAMETROS LA CANTIDAD MAXIMA A TRANSPORTAR*/
        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grúa Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinas);

        /*SE PASA POR PARAMETROS LA CANTIDAD MAXIMA A TRANSPORTAR*/
        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        imprimirCamion(transAuto);
    }
}
