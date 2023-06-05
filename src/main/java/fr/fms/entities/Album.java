package fr.fms.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Album implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@NotNull
	@Size(min=1,max=50)
	private String albumName;
	@NonNull
	@NotNull
	@Size(min=1,max=50)
	private String bandName;
	@NonNull
	@DecimalMin("1960")
	private int releaseYear;
	@NonNull
	@DecimalMin("0.1")
	private double price;
	
	
	private int quantity =1;
	@NonNull
	@NotNull
	@ManyToOne
	private MusicGenre musicGenre;
	@ToString.Exclude
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "album")
	private Collection<OrderItem> orderItems;
	

	
	
	
}
