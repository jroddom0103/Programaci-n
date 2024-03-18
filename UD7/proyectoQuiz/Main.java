package UD7.proyectoQuiz;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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

                // Recorrer preguntas
                for (int i=0;i< preguntas.size();i++){
               //     System.out.println("Pregunta "+i+": "+preguntas.get(i));
                }

                //Recorrer respuestas
                for (int i=0;i< respuestas.size();i++){
             //       System.out.println("Respuesta "+i+": "+respuestas.get(i));
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
        /*
        Hacer un pequeño programa que te pregunte todas las preguntas,
        compruebe si la respuesta es correcta.
        (Opc) Que vaya sumando el nº de respuestas correctas y que muestre la puntuación al final
         */

        /**
        System.out.println("Bienvenido al juego de preguntas.");
        System.out.println("Responde las preguntas correctamente:");
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        String respuesta1 = "";
        int contador=0;
        Random r = new Random();
        int valorAleatorio;

        for (int i = 0;i< preguntas.size();i++){
            valorAleatorio = r.nextInt(0,3);
            System.out.println("Pregunta "+(valorAleatorio+1)+": "+preguntas.get(valorAleatorio));
            respuesta1 = scan.next();

            if (respuesta1.equalsIgnoreCase(respuestas.get(valorAleatorio))){
                System.out.println("La respuesta es correcta.\n");
                contador++;
            }else{
                System.out.println("La respuesta es incorrecta.");
                System.out.println("La respuesta correcta era "+respuestas.get(valorAleatorio)+".\n");
            }
        }
        System.out.println("Has acertado "+contador+" preguntas de 3.");

        */


        //Versión de Diego
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        int nCorrectasR = 0;
        String salir = "";
        int nRandom = r.nextInt(preguntas.size());
        while (!salir.equalsIgnoreCase("si")){

            String pregunta = preguntas.get(nRandom);
            String respuesta = preguntas.get(nRandom);
            System.out.println(preguntas.get(nRandom));
            String respuestaUsuarioR = scan.nextLine();


            if(respuestaUsuarioR.equalsIgnoreCase(respuestas.get(nRandom))) {

                System.out.println("Respuesta correcta.");
                nCorrectasR++;
            }else{
                System.out.println("Respuesta incorrecta, la respuesta correcta era... "+respuesta+".");
            }
            System.out.println("¿Seguir preguntando? si/no");
            salir = scan.nextLine();

        }

        System.out.println("Has acertado "+nCorrectasR+".");

    }

}

