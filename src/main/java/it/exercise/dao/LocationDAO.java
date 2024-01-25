package it.exercise.dao;

import it.exercise.classes.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em){
        this.em = em;
    }

    public void saveLocation(Location location){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("La location '" + location.getNome() + "' è stato aggiunto alla tabella.");
    }

    public Location getLocationById(long id){
        return em.find(Location.class, id);
    }

    public void deleteById(long id){
        Location foundLocation = this.getLocationById(id);
        if(foundLocation != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundLocation);
            transaction.commit();
            System.out.println(foundLocation.getNome() + " è stato eliminato.");
        } else System.out.println("Non ci sono location con ID: " + id);
    }
}
