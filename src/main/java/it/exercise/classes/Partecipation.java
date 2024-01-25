package it.exercise.classes;

import it.exercise.enums.PartecipationStatus;

import javax.persistence.*;

@Entity
@Table (name = "partecipazioni")
public class Partecipation {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private PartecipationStatus partecipazione;

    public Partecipation(){}

    public Partecipation(Persona persona, Evento evento) {
        this.persona = persona;
        this.evento = evento;
        this.partecipazione = PartecipationStatus.DA_CONFERMARE;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public PartecipationStatus getPartecipazione() {
        return partecipazione;
    }

    public void setPartecipazione(PartecipationStatus partecipazione) {
        this.partecipazione = partecipazione;
    }

    @Override
    public String toString() {
        return "Partecipation{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", partecipazione=" + partecipazione +
                '}';
    }
}
