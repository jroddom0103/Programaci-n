package UD7.teoria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class actividadesRepasar {

    public static void main(String[] args) {

        escritura();
        escrituraLectura();
    }

    public static void escritura(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Dime un número del 1 al 10:");
        int n = scan.nextInt();

        File ficherotabla = new File("resources/archivosTema7/tabla-n.txt");
        if (ficherotabla.exists() && ficherotabla.isFile() && ficherotabla.canWrite()){

            FileWriter fw = null;

            try {

                fw = new FileWriter(ficherotabla);

                for (int i=1;i<=10;i++){
                    fw.write(n+"*"+i+"="+(n*i)+"\n");
                }

                fw.close();

            }catch (IOException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void escrituraLectura(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Dime un número del 1 al 10:");
        int n = scan.nextInt();

        File ficherotabla = new File("resources/archivosTema7/tabla-n.txt");
        if (ficherotabla.exists() && ficherotabla.isFile() && ficherotabla.canWrite()){

            FileWriter fw = null;

            try {

                fw = new FileWriter(ficherotabla);

                for (int i=1;i<=10;i++){
                    fw.write(n+"*"+i+"="+(n*i)+"\n");
                }

                fw.close();

            }catch (IOException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
