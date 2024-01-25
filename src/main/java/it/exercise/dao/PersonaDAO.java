package it.exercise.dao;

import it.exercise.classes.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em){
        this.em = em;
    }

    public void savePerson(Persona persona){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("La persona '" + persona.getNome() + "' è stato aggiunto alla tabella.");
    }

    public Persona getPersonById(long id){
        return em.find(Persona.class, id);
    }

    public void deleteById(long id){
        Persona foundPerson = this.getPersonById(id);
        if(foundPerson != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPerson);
            transaction.commit();
            System.out.println(foundPerson.getNome() + " è stato eliminato.");
        } else System.out.println("Non ci sono persone con ID: " + id);
    }
}
