package UD8.proyectoLoginUI.services;

//Bibliotecas

import UD7.proyectoUsuario.model.Usuario;

import java.io.*;
import java.util.ArrayList;

//Clase GestionFicheroUsuario
public class GestionFicheroUsuario {


    /**
     * Método leerFicheroUsuario.
     * Método que lee el fichero de usuarios y añade esos usuarios al ArrayList.
     * @param ruta Ruta del archivo de usuarios.
     * @return arrUsuarioTemporal, un ArrayList de los usuarios del archivo de texto de usuarios.
     */
    public ArrayList<Usuario> leerFicheroUsuario(String ruta){
        ArrayList<Usuario> arrUsuarioTemporal = new ArrayList<>();

        //Estructura de control de incidencias
        try {
            //1º Abrir archivo
            File fichero = new File(ruta);

            if (fichero.exists() && fichero.isFile() && fichero.canRead()){
                //2º Abrir flujos
                FileReader fl = new FileReader(fichero);
                BufferedReader bl = new BufferedReader(fl);

                //3º Operar con el fichero

                //Línea para usarlo de salto de línea.
                String linea = bl.readLine();

                //Estructura condicional bucle que no terminará hasta que haya una línea vacía.
                while (linea!=null){

                    //Declaración de variables del usuario
                    String id_user;
                    String name_user;
                    String pass_user;
                    String es_admin_user;

                    //Se separa cada campo por :
                    String[] valores = linea.split(":");

                    //Se asigna a cada variable uno de los campos separados por :
                    id_user = valores[0];
                    name_user = valores[1];
                    pass_user = valores[2];
                    es_admin_user = valores[3];

                    //Se cambia esAdmin de String, pues se tiene que poder leer del archivo, a boolean.
                    boolean esAdmin = Boolean.parseBoolean(es_admin_user);

                    //Creación del nuevo usuario
                    Usuario u = new Usuario(id_user,name_user,pass_user,esAdmin);

                    //Se añade el usuario al ArrayList
                    arrUsuarioTemporal.add(u);

                    //Se pasa a la siguiente línea
                    linea = bl.readLine();

                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return arrUsuarioTemporal;
    }

    /**
     * Método modificarFicheroUsuarios
     * Método que añade todos los usuarios del ArrayList de usuarios al archivo de texto de usuarios.
     * @param u ArrayList de usuarios
     */
    public void modificarFicheroUsuarios(ArrayList<Usuario> u){

        //Se usa el try para que no de excepciones.
        try {

            //Se crea el archivo
            File fichero = new File("C:\\Users\\jroddom0103\\Desktop\\1-DAW\\Programacion_Bien\\src\\UD7\\proyecto_UbriCines\\resources\\users.txt");

            //Se comprueba si existe, si es de tipo archivo y si se puede escribir.
            if (fichero.exists() && fichero.isFile() && fichero.canWrite()){

                //Se abren los flujos de escritura
                FileWriter fw = new FileWriter(fichero);
                BufferedWriter bw = new BufferedWriter(fw);

                //Se usa un bucle for que recorrerá el arrayList de alojamientos e irá escribiendo en el archivo.
                for (int i=0;i<u.size();i++){
                    //Método write para escribir
                    bw.write(u.get(i).getId() + ":" + u.get(i).getNombre() + ":" + u.get(i).getContrasena() + ":");
                    bw.write(u.get(i).getEsAdmin()+"");
                    bw.write("\n");
                }

                //Con .close se cierran los flujos.
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
     * Método anadirFicheroUsuarios.
     * Método que añade un usuario al archivo de texto de usuarios.
     * @param usuario Usuario que se almacena en el archivo.
     * @param ruta Ruta del archivo.
     */
    public void anadirFicheroUsuarios(Usuario usuario, String ruta){

        //Controlador de excepciones
        try {

            //Se crea el archivo
            File fichero = new File(ruta);

            //Se comprueba si existe, si es de tipo archivo y si se puede escribir.
            if (fichero.exists() && fichero.isFile() && fichero.canWrite()) {

                //Se abren los flujos de escritura
                FileWriter fw = new FileWriter(fichero, true);
                BufferedWriter bw = new BufferedWriter(fw);

                //Se usa un bucle for que recorrerá el arrayList de alojamientos e irá escribiendo en el archivo

                //Método write para escribir
                bw.write("\n");
                bw.write(usuario.getId() + ":" + usuario.getNombre() + ":" + usuario.getContrasena() + ":");
                bw.write(usuario.getEsAdmin() + "");


                //Con .close se cierran los flujos
                bw.close();
                fw.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}