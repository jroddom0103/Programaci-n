package UD7.proyecto_UbriCines.utils;

//Bibliotecas
import UD7.proyecto_UbriCines.services.impl.ServiceCine;
import UD7.proyecto_UbriCines.services.impl.ServiceUser;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase AppUsuario.
 * Se encarga del funcionamiento del menú principal.
 */
public class AppUsuario {

    //Método principal.
    public static void main(String[] args) {
        //Inicialización y declaración del objeto Scanner.
        Scanner scan = new Scanner(System.in);

        //Inicialización y declaración de objeto de tipo ServiceUser, para usar los métodos de esa clase.
        ServiceUser servicio = new ServiceUser();
        //Llamada al método que leerá los datos del usuario en el txt.
        servicio.leerFicheroUsers();
        ServiceCine servicioCine = new ServiceCine("Cine1");

        boolean esLogin=false;

        //Declaración de entero que permitirá tomar elegir diferentes opciones en el menú.
        int opcion;

        //Estructura de bucle que se activará cuando el usuario no haya iniciado sesión, es decir, mientras esLogin sea negativa.
        while (!esLogin){
                System.out.println("\n1. Dar de alta");
                System.out.println("2. Login");
                System.out.println("0. Salir");
                //Controlador de excepciones que si se le introduce un número diferente a un entero, colocará un mensaje y podrás colocar la opción de nuevo.
                try {
                    //Recoge el valor introducido por teclado.
                    opcion = scan.nextInt();
                    scan.nextLine();
                }catch (InputMismatchException e) {
                    //Mensaje cuando se introduce un valor no correcto.
                    System.out.println("\nValor inválido. Por favor, seleccione un número entero.");
                    //Salto de línea para que no se quede en un bucle.
                    scan.nextLine();
                    //Provoca que el bucle vuelva al principio.
                    continue;
                }

                //Estructura condicional que permite escoger entre varias opciones.
                switch (opcion){

                    //Si opcion=1 se llamará al método altaUsuario() de la clase ServiceUser.
                    case 1:
                        servicio.altaUsuario();

                        break;

                    //Si opcion=2 se llamará al método loginUsuario() de la clase ServiceUser.
                    case 2:
                        if (servicio.loginUsuario()){
                            esLogin=true;
                        }
                        break;

                    //Si opcion=0 se colocará un mensaje de despedida, y se saldrá del bucle con un return, cerrándose el programa.
                    case 0:
                        System.out.println("Cerrando programa...");
                        return;
                    default:

                    //Si la opción es distinto de 1, 2, 0 y es un entero, se colocará un mensaje y se repetirá el bucle.
                        System.out.println("\nOpción no válida. Inténtelo de nuevo.");
                        break;
                }
        }

        //Mientras que esLogin sea true, se inicia el otro menú, pues ya el usuario ha iniciado sesión.
        while(esLogin){
            System.out.println("\n1. Mostrar butacas.");
            System.out.println("2. Comprar entrada.");
            System.out.println("3. Devolver entrada.");
            System.out.println("0. Salir");
            //Controlador de excepciones que si se le introduce un número diferente a un entero, colocará un mensaje y podrás colocar la opción de nuevo.
            try {
                //Recoge el valor introducido por teclado.
                opcion = scan.nextInt();
                scan.nextLine();
            }catch (InputMismatchException e) {
                //Mensaje cuando se introduce un valor no correcto.
                System.out.println("\nValor inválido. Por favor, seleccione un número entero.");
                //Salto de línea para que no se quede en un bucle.
                scan.nextLine();
                //Provoca que el bucle vuelva al principio.
                continue;
            }

            //Estructura condicional que permite escoger entre varias opciones.
            switch (opcion){

                //Si opcion=1 se llamará al método mostrarButacas.
                case 1:
                    servicioCine.mostrarButacas();

                    break;

                //Si opcion=2 se llamará al método
                case 2:
                    servicio.loginUsuario();
                    break;

                //Si opcion=0 se colocará un mensaje de despedida, y se saldrá del bucle con un return, cerrándose el programa.
                case 0:
                    System.out.println("Cerrando programa...");
                    return;
                default:

                    //Si la opción es distinto de 1, 2, 0 y es un entero, se colocará un mensaje y se repetirá el bucle.
                    System.out.println("\nOpción no válida. Inténtelo de nuevo.");
                    break;
            }

        }
    }
}
