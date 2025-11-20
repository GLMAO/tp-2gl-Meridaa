package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observateurs = new ArrayList<>();

    // Ajouter un observateur
    public void attach(Observer o) {
        observateurs.add(o);
    }
    // Supprimer un observateur
    public void detach(Observer o) {
        observateurs.remove(o);
    }
    // Notifier tous les observateurs
    public void notifyObservers(String message) {
        for (Observer o : observateurs) {
            o.update(message);
        }
    }

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        // TODO: C'est ici qu'il faudrait notifier les étudiants (Observer pattern)
        String message = "Nouveau cours ajouté : " + cours.getDescription();
        System.out.println(message);
        notifyObservers(message);
    }

    public void modifierCours(ICours cours, String messageChangement ) {
        // Logique de modification...
        // TODO: Notifier les observateurs ici aussi
        String message = "Cours modifié : " + cours.getDescription() + "=> " + messageChangement;
        System.out.println(message);
        notifyObservers(message);
    }

    public void setChangement(String message) {
        // TODO Auto-generated method stub
        notifyObservers(message);
    }
}