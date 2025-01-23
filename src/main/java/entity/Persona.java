package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Persona {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (nullable = false)
	private String nome;

	@Column (nullable = false)
	private String cognome;

	@Column (nullable = false, unique = true)
	private String email;

	@Column (name = "data_nascita", nullable = false)
	private LocalDate dataNascita;

	@Column (nullable = false)
	private char sesso;


	// Costruttori
	public Persona (String name, String cognome) {
	}

	public Persona (String nome, String cognome, String email, LocalDate dataNascita, char sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
	}

	// Getters e Setters
	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getNome () {
		return nome;
	}

	public void setNome (String nome) {
		this.nome = nome;
	}

	public String getCognome () {
		return cognome;
	}

	public void setCognome (String cognome) {
		this.cognome = cognome;
	}

	public String getEmail () {
		return email;
	}

	public void setEmail (String email) {
		this.email = email;
	}

	public LocalDate getDataNascita () {
		return dataNascita;
	}

	public void setDataNascita (LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public char getSesso () {
		return sesso;
	}

	public void setSesso (char sesso) {
		this.sesso = sesso;
	}


}
