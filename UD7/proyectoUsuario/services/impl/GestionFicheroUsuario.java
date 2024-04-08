package UD7.proyectoUsuario.services.impl;

import UD7.proyectoUsuario.model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionFicheroUsuario {

    Scanner scan = new Scanner(System.in);


    public ArrayList<Usuario> leerFicheroUsuario(String ruta){
    ArrayList<Usuario> arrUsuarioTemporal = new ArrayList<>();

    try {
        //1º Abrir archivo
        File fichero = null;
        fichero = new File(ruta);

        if (fichero.exists()){
            //2º Abrir flujos
            FileReader fl = new FileReader(fichero);
            BufferedReader bl = new BufferedReader(fl);

            //3º Operar con el fichero
            String linea = bl.readLine();
            while (linea!=null){
                String id_user = "";
                String name_user = "";
                String pass_user = "";
                String es_admin_user = "";

                String[] valores = linea.split(":");

                id_user = valores[0];
                name_user = valores[1];
                pass_user = valores[2];
                es_admin_user = valores[3];

                boolean esAdmin = Boolean.parseBoolean(es_admin_user);

                Usuario u = new Usuario(id_user,name_user,pass_user,esAdmin);
                arrUsuarioTemporal.add(u);

                linea = bl.readLine();

            }
        }

    }catch (NullPointerException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }

    return arrUsuarioTemporal;
    }

    public void modificarFicheroUsuarios(String ruta, ArrayList<Usuario> u){

        //Se usa el try para que no de excepciones
        try {

            //Se crea el archivo
            File fichero = new File(ruta);

            if (fichero.exists() && fichero.isFile() && fichero.canWrite()){

                //Se abren los flujos de escritura
                FileWriter fw = new FileWriter(fichero);
                BufferedWriter bw = new BufferedWriter(fw);

                //Se usa un bucle for que recorrerá el arrayList de alojamientos e irá escribiendo en el archivo
                for (int i=0;i<u.size();i++){
                    //Método write para escribir
                    bw.write(u.get(i).getId() + ":" + u.get(i).getNombre() + ":" + u.get(i).getContrasena() + ":");
                    bw.write(u.get(i).getEsAdmin()+"");
                    bw.write("\n");
                }

                //Con .close se cierran los flujos
                bw.close();
                fw.close();
            }

            //Se capturan las excepciones
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void anadirFicheroUsuarios(String ruta){

        int numero = (int)(Math.random()*1000000000+1);
        String numeroString = Integer.toString(numero);
        System.out.println("\nEstablece un nombre de usuario:");
        String nombre = scan.nextLine();

        System.out.println("Establece una contraseña:");
        String contrasena = scan.nextLine();

        Usuario usuario = new Usuario(numeroString,nombre,contrasena,false);
        leerFicheroUsuario(ruta).add(usuario);
        System.out.println("El usuario ha sido añadido con éxito.\n");
    }

}

