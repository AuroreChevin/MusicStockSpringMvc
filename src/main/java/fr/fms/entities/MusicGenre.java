package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @RequiredArgsConstructor @ToString
public class MusicGenre {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@Size(min=1,max=50)
	private String name;
	@ToString.Exclude
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "musicGenre")
	private Collection<Album> albums;
}
