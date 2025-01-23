package entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery (
	name = "Evento.getEventiSoldOut",
	query = "SELECT e FROM Evento e WHERE e.numeroPartecipanti = e.numeroMassimoPartecipanti"
)
public abstract class Evento {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (nullable = false)
	private String titolo;

	@Column (name = "data_evento", nullable = false)
	private LocalDate dataEvento;

	@Column (length = 500)
	private String descrizione;

	@Enumerated (EnumType.STRING)
	@Column (name = "tipo_evento", nullable = false)
	private TipoEvento tipoEvento;

	@Column (name = "numero_partecipanti")
	private int numeroPartecipanti;

	@Column (name = "numero_massimo_partecipanti")
	private int numeroMassimoPartecipanti;


	// Costruttori

	public Evento () {
	}

	public Evento (String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroPartecipanti) {
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroPartecipanti = numeroPartecipanti;
		this.numeroMassimoPartecipanti = 100; // Valore predefinito
	}



	// Getters e Setters
	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getTitolo () {
		return titolo;
	}

	public void setTitolo (String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento () {
		return dataEvento;
	}

	public void setDataEvento (LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione () {
		return descrizione;
	}

	public void setDescrizione (String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento () {
		return tipoEvento;
	}

	public void setTipoEvento (TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getNumeroMassimoPartecipanti () {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti (int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public int getNumeroPartecipanti () {
		return numeroPartecipanti;
	}

	public void setNumeroPartecipanti (int numeroPartecipanti) {
		this.numeroPartecipanti = numeroPartecipanti;
	}

	public enum TipoEvento {
		PUBBLICO,
		PRIVATO
	}
}

