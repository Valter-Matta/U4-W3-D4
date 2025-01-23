package entity;

import jakarta.persistence.*;

@Entity
@NamedQuery (
	name = "Partecipazione.getPartecipazioniDaConfermarePerEvento",
	query = "SELECT p FROM Partecipazione p WHERE p.evento = :evento AND p.confermata = false"
)
public class Partecipazione {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Evento evento;

	private boolean confermata;

	// Getters e Setters
	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}


	public Evento getEvento () {
		return evento;
	}

	public void setEvento (Evento evento) {
		this.evento = evento;
	}


	public Partecipazione (boolean confermata) {
		this.confermata = confermata;
	}

	public Partecipazione (Evento evento, boolean confermata) {
		this.confermata = confermata;
		this.evento = evento;


	}

	public enum StatoPartecipazione {
		CONFERMATA, DA_CONFERMARE;
	}
}

