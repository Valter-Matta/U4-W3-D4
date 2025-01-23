package DAO;

import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


public class EventoDAO {
	@PersistenceContext
	private EntityManager em;

	public EventoDAO (EntityManager em) {
		this.em = em;
	}

	//metodo 1
	public List<Concerto> getConcertiInStreaming (boolean streaming) {
		String jpql = "SELECT c FROM Concerto c WHERE c.streaming = :streaming";
		return em.createQuery(jpql, Concerto.class)
			.setParameter("streaming", streaming)
			.getResultList();
	}

	public List<Concerto> getConcertiPerGenere (Concerto.genereMusicale genere) {
		String jpql = "SELECT c FROM Concerto c WHERE c.genere = :genere";
		return em.createQuery(jpql, Concerto.class)
			.setParameter("genere", genere)
			.getResultList();
	}


	//metodo 2
	public List<PartitaDiCalcio> getPartiteVinteInCasa () {
		return em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class)
			.getResultList();
	}

	public List<PartitaDiCalcio> getPartiteVinteInTrasferta () {
		return em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class)
			.getResultList();
	}

	public List<PartitaDiCalcio> getPartitePareggiate () {
		return em.createNamedQuery("PartitaDiCalcio.getPartitePareggiate", PartitaDiCalcio.class)
			.getResultList();
	}

	public List<GaraDiAtletica> getGareDiAtleticaPerVincitore (Persona vincitore) {
		return em.createNamedQuery("GaraDiAtletica.getGareDiAtleticaPerVincitore", GaraDiAtletica.class)
			.setParameter("vincitore", vincitore)
			.getResultList();
	}

	public List<GaraDiAtletica> getGareDiAtleticaPerPartecipante (Persona partecipante) {
		return em.createNamedQuery("GaraDiAtletica.getGareDiAtleticaPerPartecipante", GaraDiAtletica.class)
			.setParameter("partecipante", partecipante)
			.getResultList();
	}

	public List<Evento> getEventiSoldOut () {
		return em.createNamedQuery("Evento.getEventiSoldOut", Evento.class)
			.getResultList();
	}
}
