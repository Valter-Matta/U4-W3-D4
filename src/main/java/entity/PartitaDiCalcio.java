package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue ("PartitaDiCalcio")
@NamedQueries({
	@NamedQuery(
		name = "PartitaDiCalcio.getPartiteVinteInCasa",
		query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa"
	),
	@NamedQuery(
		name = "PartitaDiCalcio.getPartiteVinteInTrasferta",
		query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite"
	),
	@NamedQuery(
		name = "PartitaDiCalcio.getPartitePareggiate",
		query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente IS NULL"
	)
})
public class PartitaDiCalcio extends Evento {
	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente = null;
	private int golSquadraDiCasa;
	private int golSquadraOspite;


	public PartitaDiCalcio () {
	}

	public PartitaDiCalcio (String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,int numeropartecipanti, String squadraDiCasa, String squadraOspite, String squadraVincente, int golSquadraDiCasa, int golSquadraOspite) {
		super(titolo, dataEvento, descrizione, tipoEvento,numeropartecipanti);
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.golSquadraDiCasa = golSquadraDiCasa;
		this.golSquadraOspite = golSquadraOspite;
	}

	private String determinaVincitore () {
		if (golSquadraDiCasa > golSquadraOspite) {
			return squadraDiCasa;
		} else if (golSquadraDiCasa < golSquadraOspite) {
			return squadraOspite;
		} else {
			return null;
		}
	}

	public String getSquadraDiCasa () {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa (String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public String getSquadraOspite () {
		return squadraOspite;
	}

	public void setSquadraOspite (String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente () {
		return squadraVincente;
	}

	public void setSquadraVincente (String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public int getGolSquadraDiCasa () {
		return golSquadraDiCasa;
	}

	public void setGolSquadraDiCasa (int golSquadraDiCasa) {
		this.golSquadraDiCasa = golSquadraDiCasa;
	}

	public int getGolSquadraOspite () {
		return golSquadraOspite;
	}

	public void setGolSquadraOspite (int golSquadraOspite) {
		this.golSquadraOspite = golSquadraOspite;
	}
}
