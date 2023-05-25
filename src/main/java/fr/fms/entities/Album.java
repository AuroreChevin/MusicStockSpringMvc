package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor @ToString
public class Album implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String albumName;
	@NonNull
	private String bandName;
	
	@NonNull
	private int releaseYear;
	@NonNull
	private double price;
	@ToString.Exclude
	@NonNull
	@ManyToOne
	private MusicGenre musicGenre;
	
}
