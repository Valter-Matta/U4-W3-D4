package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue ("GaraDiAtletica")
@NamedQueries ({
	@NamedQuery (
		name = "GaraDiAtletica.getGareDiAtleticaPerVincitore",
		query = "SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore"
	),
	@NamedQuery (
		name = "GaraDiAtletica.getGareDiAtleticaPerPartecipante",
		query = "SELECT g FROM GaraDiAtletica g WHERE :partecipante MEMBER OF g.setAtleti"
	)
})
public class GaraDiAtletica extends Evento {

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "gara_id") // Nome della colonna FK nella tabella Persona
	private Set<Persona> setAtleti;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "vincitore_id") // Nome della colonna FK nella tabella GaraDiAtletica
	private Persona vincitore;

	public GaraDiAtletica () {
	}

	public GaraDiAtletica (String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeropartecipanti, Set<Persona> setAtleti, Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeropartecipanti);
		this.setAtleti = setAtleti;
		this.vincitore = vincitore;
	}

	public Set<Persona> getSetAtleti () {
		return setAtleti;
	}

	public void setSetAtleti (Set<Persona> setAtleti) {
		this.setAtleti = setAtleti;
	}

	public Persona getVincitore () {
		return vincitore;
	}

	public void setVincitore (Persona vincitore) {
		this.vincitore = vincitore;
	}
}
