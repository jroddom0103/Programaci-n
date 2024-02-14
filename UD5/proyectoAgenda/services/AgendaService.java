package UD5.proyectoAgenda.services;

import UD5.proyectoAgenda.clases.Persona;

import java.util.ArrayList;

public class AgendaService{

    private static ArrayList<Persona> agenda = null;
    public boolean addPersona(Persona persona) {
        //Hay que comprobar si existe esa persona, y si no existe, se añade.

        try {
            if (this.checkPersona(persona.getDni())){
                AgendaService.agenda.add(persona);
                return checkPersona(persona.getDni());
            }
        }catch(NullPointerException e){
            System.out.println("Error en los datos...");
            return false;
        }

        return false;

    }

    public boolean deletePersona(Persona persona){
        //Hay que comprobar si esa persona está en el ArrayList, si está, se elimina
        int posicionAEliminar=-1;
        for (int i=0;i<AgendaService.agenda.size();i++){
            if (AgendaService.agenda.get(i).getDni().equals(persona.getDni())){
                posicionAEliminar = i;
                AgendaService.agenda.remove(posicionAEliminar);
                return true;
            }
        }
        return false;

    }

    public boolean checkPersona(String dni){

        //Comprueba si la persona está en el ArrayList o no
        boolean personaExiste = false;

        for (int i=0;i<AgendaService.agenda.size();i++){
            if (AgendaService.agenda.get(i).getDni().equals(dni)){
                personaExiste = true;
                break;
            }
        }
        return personaExiste;

    }
}
