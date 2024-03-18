package UD7.proyectoQuiz;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // Vamos a leer un fichero que va a contener preguntas y respuestas, separadas por :
        String ls = File.separator;
        File fichero = new File("resources"+ls+"archivosTema7"+ls+"proyectoQuiz"+ls+"preguntas_respuestas.txt");

        ArrayList<String> preguntas = new ArrayList<>();
        ArrayList<String> respuestas = new ArrayList<>();


        try {
            //1ºComprobar si el fichero existe
            if (fichero.exists() && fichero.isFile() && fichero.canRead()){

                //2º Abrir los flujos de lectura (Vamos a trabajar con un Buffered)
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);

                //3º Operar con el fichero
                String pregunta = "";
                String respuesta = "";

                String linea = br.readLine();
                while (linea!=null){
                    //System.out.println(linea);
                    String[] lineaSeparada = linea.split(":");
                    pregunta = lineaSeparada[0];
                    respuesta = lineaSeparada[1];
                    preguntas.add(pregunta);
                    respuestas.add(respuesta);
                    //System.out.println("Pregunta: "+pregunta);
                    //System.out.println("Respuesta: "+respuesta);
                    linea = br.readLine();
                }

                //4ºCerrar flujos
                br.close();
                fr.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al operar con el fichero");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error general... eliminando todos sus archivos");

        }

        // Empieza en programa
        // Hacer 10 preguntas random
        // Almacenar la puntuación del usuario
        // Escribir el nombre del usuario junto con su puntuación

        //Código para escoger 10 preguntas al azar
        ArrayList<String> preguntasParaJuego = new ArrayList<>();
        ArrayList<String> respuestasParaJuego = new ArrayList<>();
        Random r = new Random();
        while (preguntasParaJuego.size()<10){
            int nRandom = r.nextInt(preguntas.size()); //Genera un numero Random entre 0 y el 1
            String pregunta = preguntas.get(nRandom);
            String respuesta = respuestas.get(nRandom);

            if (preguntasParaJuego.contains(pregunta)){
                System.out.println("Pregunta duplicada.");
            }else{
                preguntasParaJuego.add(pregunta);
                respuestasParaJuego.add(respuesta);
            }
        }

        // JUEGO NORMAL -> Hacer las 10 preguntas (preguntad el nombre al usuario)
            int puntuacion = 0;
            String respuestaNUsuario;

            System.out.println("Dime tu nombre.");
            String nombreUsuario = scan.nextLine();

            for (int i=0;i<preguntasParaJuego.size();i++){

                System.out.println(preguntasParaJuego.get(i));
                respuestaNUsuario = scan.nextLine();

                if (respuestasParaJuego.get(i).equals(respuestaNUsuario)){
                    System.out.println("Respuesta correcta.");
                    puntuacion++;
                }else{
                    System.out.println("Respuesta incorrecta.");
                    System.out.println("La respuesta correcta era "+respuestasParaJuego.get(i));
                }
            }
            System.out.println(nombreUsuario+", has acertado "+puntuacion+" preguntas de 10.");


        // Escribir en el fichero el NOMBRE:PUNTUACIÓN (Atención a no sobreescribir los datos)
        // OJO 1: No sobreescribir la información que haya en el fichero (Lo del append true)
        // OJO 2: El fichero quizá no existe... si no existe deberíais crearlo (Lo del .mkdir())

        File fichero2 = new File("resources" + ls + "archivosTema7" + ls + "proyectoQuiz" + ls + "almacenarPuntuacion");
        if (!fichero2.exists()){
            try {
                fichero2.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
                System.exit(0);
            }
        }

        try{


            if (fichero.exists() && fichero.isFile() && fichero.canRead()) {


                //2º Abrir los flujos de lectura (Vamos a trabajar con un Buffered)
                FileWriter fe = new FileWriter(fichero2,true);
                BufferedWriter be = new BufferedWriter(fe);

                fe.write(nombreUsuario+":"+puntuacion+"\n");

                fe.close();
                be.close();


            }

        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al operar con el fichero");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error general... eliminando todos sus archivos");

        }

    }
}
