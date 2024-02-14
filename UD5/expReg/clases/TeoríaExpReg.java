package UD5.expReg.clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TeoríaExpReg {

    public static void main(String[] args) {
        //Para poder usar expresiones regulares en java se necesitan dos clases: Pattern y Matcher
        //La clase Pattern: Pattern pattern = Pattern.compile("La expresión regular");
        Pattern pattern1 = Pattern.compile("\\d{8}(\\s|-)?[a-zA-Z]"); //Expresión regular para DNI

        //La clase Matcher:
        String dni = "75837164F";
        Matcher matcher1 = pattern1.matcher(dni);

        //Para ya comprobar en si... osea,... un método que os diga true o false -> .find()
        if(matcher1.find()){
            System.out.println("El DNI es válido");
        }else{
            System.out.println("El DNI no es válido");
        }

        //Haced una expresión regular para comprobar una IP válida de formato
        //192.168.189.190

        Pattern pattern2 = Pattern.compile("^(\\d{3}.){3}\\d{3}$"); //Expresión regular para DNI

        //La clase Matcher:
        String ip = "192.168.189.190";
        Matcher matcher2 = pattern2.matcher(ip);
        if (matcher2.find()){
            System.out.println("Es una ip válida.");
        }else{
            System.out.println("No es una ip válida.");
        }

        //Hagáis dos exp reg.
        // 1 Para un número de teléfono
        // 950475192 -> válido
        // 950 47 51 92 -> válido

        Pattern pattern3 = Pattern.compile("^\\d{3}((\\s|-)?\\d{3}){2}|\\d{3}((\\s|-)?\\d{2}){3}|\\d{9}$");
        String telefono = "748 29 10 03";
        String telefono2 = "748917421";
        Matcher matcher3 = pattern3.matcher(telefono);
        if (matcher3.find()){
            System.out.println("Es un teléfono válido.");
        }else{
            System.out.println("No es un teléfono válido.");
        }

        Matcher matcher4 = pattern3.matcher(telefono2);
        if (matcher4.find()){
            System.out.println("El segundo teléfono válido");
        }else{
            System.out.println("El segundo teléfono no es válido");
        }

        // 2 Para una dirección de correo electrónico
        // cualquier carácter seguido de un @ seguido de un gmail o hotmail seguido de . seguido de com o es
        Pattern patronEmail = Pattern.compile("^.+@(gmail|hotmail)\\.(com|es)$");
        String correo = "elreshulon6969@gmail.com";
        Matcher matcher5 = patronEmail.matcher(correo);
        if (matcher5.find()){
            System.out.println("Es un correo válido.");
        }else{
            System.out.println("No es un correo válido.");
        }

        Pattern patronAndalucia = Pattern.compile("^(04|41|14|18|29|21|11|23)\\d{3}$");
        String cp = "11600";
        Matcher matcher6 = patronAndalucia.matcher(cp);
        if (matcher6.find()){
            System.out.println("Es un código postal de Andalucía.");
        }else{
            System.out.println("No es un código postal de Andalucía.");
        }

    }
}