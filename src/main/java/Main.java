import DAO.EventoDAO;
import DAO.PartecipazioneDAO;
import entity.Evento;
import entity.GaraDiAtletica;
import entity.PartitaDiCalcio;
import entity.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;




public class Main {
	public static void main (String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventiPU");
		EntityManager em = emf.createEntityManager();

		EventoDAO eventoDAO = new EventoDAO(em);
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

		Persona atleta1 = new Persona("Usain", "Bolt");
		Persona atleta2 = new Persona("Yohan", "Blake");
		Set<Persona> listaPartecipanti = new HashSet<>();
		listaPartecipanti.add(atleta1);
		listaPartecipanti.add(atleta2);


		GaraDiAtletica garaDiAtletica = new GaraDiAtletica("Corsa 100 metri", LocalDate.of(2021, 5, 15), "Staffetta", Evento.TipoEvento.PUBBLICO, 100, listaPartecipanti, atleta1);
		PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio("Derby", LocalDate.of(2025, 5, 12), "Torino-juve", Evento.TipoEvento.PUBBLICO, 100, "Juve", "Toro", "Juve", 3, 0);



		try {
			em.getTransaction().begin();
			em.persist(garaDiAtletica);
			em.persist(partitaDiCalcio);

			// Recupero tutte le partite vinte in casa
			System.out.println("Partite vinte in casa:");
			eventoDAO.getPartiteVinteInCasa().forEach(partita ->
				System.out.println(partita.getTitolo() + " - Vincitore: " + partita.getSquadraVincente())
			);

			// Trovo gare di atletica per un certo partecipante
			Persona partecipante = em.find(Persona.class, 1L);

			if (partecipante != null) {
				System.out.println("Gare di atletica con partecipante " + partecipante.getNome() + ":");
				eventoDAO.getGareDiAtleticaPerPartecipante(partecipante).forEach(gara ->
					System.out.println(gara.getTitolo() + " - Data: " + gara.getDataEvento())
				);
			}

			// Recupera tutti gli eventi sold out
			System.out.println("Eventi sold out:");
			eventoDAO.getEventiSoldOut().forEach(evento ->
				System.out.println(evento.getTitolo() + " - Data: " + evento.getDataEvento())
			);

			// Ottieni partecipazioni non confermate di un evento specifico
			Evento evento = em.find(Evento.class, 2L);

			if (evento != null) {
				System.out.println("Partecipazioni da confermare per l'evento: " + evento.getTitolo());
				partecipazioneDAO.getPartecipazioniDaConfermarePerEvento(evento).forEach(partecipazione ->
					System.out.println("Partecipante ID: " + partecipazione.getId())
				);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
