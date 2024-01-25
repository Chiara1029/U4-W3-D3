package it.exercise;

import it.exercise.classes.Evento;
import it.exercise.classes.Location;
import it.exercise.classes.Partecipation;
import it.exercise.classes.Persona;
import it.exercise.dao.EventoDAO;
import it.exercise.dao.LocationDAO;
import it.exercise.dao.PartecipationDAO;
import it.exercise.dao.PersonaDAO;
import it.exercise.enums.EventType;
import it.exercise.enums.Gender;
import it.exercise.enums.PartecipationStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {
        System.out.println("--- Esercizio U4-W3-D2 ---");

        EntityManager em = emf.createEntityManager();
        EventoDAO evDao = new EventoDAO(em);
        PersonaDAO persDAO = new PersonaDAO(em);
        PartecipationDAO partDAO = new PartecipationDAO(em);
        LocationDAO locDAO = new LocationDAO(em);

        System.out.println("--- EVENTO ---");

        Evento galleriaBorghese = new Evento("Mostra Galleria Borghese", LocalDate.of(2024, 12, 31), "Mostra Galleria Borghese", EventType.PUBBLICO, 400);
        Evento pompei = new Evento("Parco Archeologico di Pompei", LocalDate.of(2024, 1, 23), "Parco Archeologico di Pompei", EventType.PUBBLICO, 1000);
        Evento vanGoghMi = new Evento("Van Gogh", LocalDate.of(2024, 1, 28), "Mostra presso AI Mudec di Milano", EventType.PUBBLICO, 300);
        Evento vgExp = new Evento("Open - Van Gogh Experience", LocalDate.of(2024, 3,31), "Mostra multimediale a Roma", EventType.PRIVATO, 50);

//        evDao.saveEvent(galleriaBorghese);
//        evDao.saveEvent(pompei);
//        evDao.saveEvent(vanGoghMi);
//        evDao.saveEvent(vgExp);

        long id = 2;
        Evento searchEv = evDao.getEventById(id);
        if(searchEv != null){
            System.out.println("Evento trovato: " + searchEv.getTitle());
        } else System.out.println("Evento non trovato");

//        evDao.deleteById(1);

        System.out.println("--- PERSONA ---");

        Persona chiara = new Persona("Chiara", "Puleio", "chiara@puleio.it", LocalDate.of(1994,10,29), Gender.F);
        Persona calvino = new Persona("Italo", "Calvino", "italo@calvino.it", LocalDate.of(1923,10,15), Gender.M);
        Persona mario = new Persona("Mario", "Rossi", "mario@rossi.it", LocalDate.of(1982, 7,7), Gender.M);
//        persDAO.savePerson(chiara);
//        persDAO.savePerson(calvino);
//        persDAO.savePerson(mario);

        long idPers = 3;
        Persona searchPers = persDAO.getPersonById(idPers);
        if(searchPers != null){
            System.out.println("Persona trovata: " + searchPers.getNome() + searchPers.getCognome());
        } else System.out.println("Persona non trovata");

//        persDAO.deleteById(3);
//
        System.out.println("--- LOCATION ---");

        Location gallBorgh = new Location("Galleria Borghese", "Roma");
        Location aimudec = new Location("AI Mudec", "Milano");
        Location parcPpompei = new Location("Parco Archeologico di Pompei", "Pompei");
//        locDAO.saveLocation(gallBorgh);
//        locDAO.saveLocation(aimudec);
//        locDAO.saveLocation(parcPpompei);

        long idLoc = 1;
        Location searchLoc = locDAO.getLocationById(idLoc);
        if(searchLoc != null){
            System.out.println("Location trovata: " + searchLoc.getNome() + " a " + searchLoc.getCity());
        } else System.out.println("Location non trovata");

//        locDAO.deleteById(2);
//
        System.out.println("--- PARTECIPATION ---");

        Partecipation newpart = new Partecipation(chiara.getNome(), pompei.getTitle());
        Partecipation newpart2 = new Partecipation(calvino.getNome(), galleriaBorghese.getTitle());
//        partDAO.savePartecipation(newpart);
//        partDAO.savePartecipation(newpart2);

        long partLoc = 1;
        Partecipation searchPart = partDAO.getPartecipationById(partLoc);
        if(searchPart != null){
            System.out.println("Partecipazione trovata: " + searchPart.getPartecipazione());
        } else System.out.println("Partecipazione non trovata");

//        partDAO.deleteById(2);


        em.close();
        emf.close();
    }
}
