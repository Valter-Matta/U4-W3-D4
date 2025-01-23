package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue ("Concerto")
public class Concerto extends Evento {
	private genereMusicale genere;
	private boolean streaming;

	public Concerto () {
	}

	public Concerto (String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeropartecipanti, genereMusicale genere, boolean streaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeropartecipanti);
		this.genere = genere;
		this.streaming = streaming;
	}

	public enum genereMusicale {
		CLASSICO,
		ROCK,
		POP
	}


}
