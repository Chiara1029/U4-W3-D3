package it.exercise.dao;

import it.exercise.classes.Partecipation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipationDAO {
    private final EntityManager em;

    public PartecipationDAO(EntityManager em){
        this.em = em;
    }

    public void savePartecipation(Partecipation partecipation){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipation);
        transaction.commit();
        System.out.println(partecipation.getPersona().getNome() + partecipation.getPersona().getCognome() + "per l'evento '" + partecipation.getEvento().getTitle() + "' ha status: " + partecipation.getPartecipazione());
    }

    public Partecipation getPartecipationById(long id){
        return em.find(Partecipation.class, id);
    }

    public void deleteById(long id){
        Partecipation foundPartecipation = this.getPartecipationById(id);
        if(foundPartecipation != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPartecipation);
            transaction.commit();
            System.out.println(foundPartecipation + " è stato eliminato.");
        } else System.out.println("Non ci sono partecipation con ID: " + id);
    }
}
