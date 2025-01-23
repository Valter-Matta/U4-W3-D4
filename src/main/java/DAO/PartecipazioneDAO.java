package DAO;

import entity.Evento;
import entity.Partecipazione;
import jakarta.persistence.EntityManager;
import entity.Persona;

import java.util.List;

public class PartecipazioneDAO  {

	private EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}


	public List<Partecipazione> getPartecipazioniDaConfermarePerEvento(Evento evento) {
		return em.createNamedQuery("Partecipazione.getPartecipazioniDaConfermarePerEvento", Partecipazione.class)
			.setParameter("evento", evento)
			.getResultList();
	}

}
