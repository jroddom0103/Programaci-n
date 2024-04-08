package UD7.proyectoAirbnb.services;

import UD7.proyectoAirbnb.model.Alojamiento;
import UD7.proyectoAirbnb.model.Propietario;

import java.io.*;
import java.util.*;

//Clase GestionFicheroAirbnb
public class GestionFicheroAirbnb {

    //Declaración de objeto de tipo Scanner
    Scanner scan = new Scanner(System.in);

    /**
     * Método que lee los datos concretos de un archivo y devuelve un array de alojamientos
     * @param ruta del archivo
     * @return ArrayList<Alojamiento> con los alojamientos creados con los datos
     */
    public ArrayList<Alojamiento> leerFicheroAlojamientos(String ruta){

        //Creación de arrayList para almacenar los alojamientos
        ArrayList<Alojamiento> arrDeInformacion = new ArrayList<>();

        //Se crea el fichero
        File fichero = new File(ruta);

        //Comprobador que verifica si el archivo existe, si es un archivo y si se puede leer
        if (fichero.exists() && fichero.isFile() && fichero.canRead()){

            //Se instancia el flujo de lectura
            FileReader fl;
            //Se instancia el flujo de lectura del buffer
            BufferedReader bl;

            //Se mete todo en un try para que no de errores
            try {

                //Se abre el flujo de lectura del archivo
                fl = new FileReader(fichero);
                //Se abre el flujo de lectura del buffer
                bl = new BufferedReader(fl);

                //Se declara la variable de tipo String que guarda la información por cada línea
                String lineaDelFichero = bl.readLine();

                //Declaración de variable para el if
                int i = 0;

                //Se declaran variables para los datos
                String id;
                String name;
                String host_id;
                String host_name;
                double price;

                //Bucle while que termina cuando encuentra una línea sin información
                while (lineaDelFichero != null) {

                    //Si i=0, entonces se incrementa i, porque en la primera línea no hay datos
                    if (i==0){
                        i++;
                    //Si es diferente de i se empiezan a almacenar valores. Se usa la expresión regular para separar, en este caso por "," y se almacenan en un array de String
                    }else{
                        String[] valores = lineaDelFichero.split(",");
                        //Según la separación de comas, cada valor se asignará según la posición del array que le corresponda
                        id = valores[0];
                        name = valores[1];
                        host_id = valores[2];
                        host_name = valores[3];
                        String priceString = valores[9];
                        priceString = priceString.trim();

                        //Con esto se cambia el valor de String del precio a double, para que sea compatible con el objeto que se formará luego
                        if (priceString.matches("-?\\d+(\\.\\d+)?")) {
                            try {
                                price = Double.parseDouble(priceString);
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                price = 0.0; // Manejar la excepción asignando un valor por defecto
                            }
                        } else {
                            // Si no es numérica, asignar un valor por defecto
                            price = 0.0;
                        }

                        //Se crea un objeto de tipo Propietario que almacenará la información correspondiente
                        Propietario p = new Propietario(host_id,host_name);

                        //Se crea un objeto de tipo Alojamiento que almacenará la información correspondiente
                        Alojamiento a = new Alojamiento(id,name,p,price);

                        //Si el propietario no tiene un alojamiento, entonces se añade al arrayList de alojamientos
                        if (!arrDeInformacion.contains(a)) {
                            arrDeInformacion.add(a);
                        }
                    }

                    //Con esto se pasa a la siguiente línea para leer
                    lineaDelFichero = bl.readLine();
                }

                //Se cierran los flujos
                bl.close();
                fl.close();

            //Se captura la excepción
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        //Se devuelve el arrayList de alojamientos
        return arrDeInformacion;
    }

    /**
     * Método que escribe en el fichero datos_malaga.csv
     * @param ruta del archivo donde se escribirá
     * @param alojamientos, que es el array de alojamientos
     */
    public void escribirFichero(String ruta, ArrayList<Alojamiento> alojamientos) {

        //Se usa el try para que no de excepciones
        try {

            //Se crea el archivo
            File fichero = new File(ruta);

            if (fichero.exists() && fichero.isFile() && fichero.canWrite()){

                //Se abren los flujos de escritura
                FileWriter fw = new FileWriter(fichero);
                BufferedWriter bw = new BufferedWriter(fw);

                //Se escriben los nombres de los datos para identificarlos
                bw.write("id,name,host_id,host_name,price\n");

                //Se usa un bucle for que recorrerá el arrayList de alojamientos e irá escribiendo en el archivo
                for (int i=0;i<alojamientos.size();i++){
                    //Método write para escribir
                    bw.write(alojamientos.get(i).getId() + "," +
                            alojamientos.get(i).getName() + "," +
                            alojamientos.get(i).getPropietario().getHost_id() + "," +
                            alojamientos.get(i).getPropietario().getHost_name() + "," +
                            alojamientos.get(i).getPrecio() + "\n");
                }

                //Con .close se cierran los ciclos
                bw.close();
                fw.close();
            }

        //Se capturan las excepciones
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método que muestra por pantalla los alojamientos más baratos
     * @param alojamientos, arrayList de alojamientos
     */
    public void mostrarAlojamientosMasBaratos(ArrayList<Alojamiento> alojamientos) {
        Collections.sort(alojamientos, Comparator.comparingDouble(Alojamiento::getPrecio));
        imprimirAlojamientos(alojamientos, 20);
    }

    /**
     * Método que muestra por pantalla los alojamientos más caros
     * @param alojamientos, arrayList de alojamientos
     */
    public void mostrarAlojamientosMasCaros(ArrayList<Alojamiento> alojamientos) {
        Collections.sort(alojamientos, Comparator.comparingDouble(Alojamiento::getPrecio).reversed());
        //Llamada al método que imprime los alojamientos
        imprimirAlojamientos(alojamientos, 20);
    }

    /**
     * Método que muestra los alojamientos que cumplen el presupuesto
     * @param alojamientos, arrayList de alojamientos
     */
    public void mostrarAlojamientosPorPresupuesto(ArrayList<Alojamiento> alojamientos) {
        double presupuestoMaximo=0;
        System.out.print("Introduce el presupuesto máximo: ");
        //Controla la excepción en la que se introduce algo diferente a un double
        try {
            presupuestoMaximo = scan.nextDouble();
        }catch (InputMismatchException e){
            e.printStackTrace();
            System.out.println("Opción no válida.\n");
        }

        //Creación un arrayList de alojamientos que guarde los alojamientos que van por debajo o igual del presupuesto
        ArrayList<Alojamiento> alojamientosFiltrados = new ArrayList<>();

        //Estructura de bucle for que añade los alojamientos al array cuando cumplen el requisito
        for (int i=0;i<alojamientos.size();i++) {
            if (alojamientos.get(i).getPrecio() <= presupuestoMaximo) {
                alojamientosFiltrados.add(alojamientos.get(i));
            }
        }
        //Llamada al método que imprime los alojamientos
        imprimirAlojamientos(alojamientosFiltrados, alojamientosFiltrados.size());
    }

    /**
     * Método que imprime los alojamientos
     * @param alojamientos, arrayList de alojamientos
     * @param cantidad, cantidad de alojamientos que se van a imprimir
     */
    public void imprimirAlojamientos(ArrayList<Alojamiento> alojamientos, int cantidad) {
        //Estructura de bucle for que va imprimiendo por pantalla la información del alojamiento
        for (int i = 0; i < cantidad && i < alojamientos.size(); i++) {
            Alojamiento alojamiento = alojamientos.get(i);
            System.out.println("ID: "+alojamiento.getId()+", Nombre: "+alojamiento.getName()+", Precio: "+alojamiento.getPrecio());
        }
    }
}

