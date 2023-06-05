package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Customer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId;
	@NonNull
	@NotNull
	@Size(min=1,max=50, message = "Adresse non valide")
	private String name;
	@NonNull
	@NotNull
	@Size(min=1,max=50, message = "Adresse non valide")
	private String surname;
	@NonNull
	@NotNull
	@Email(message = "Email non valide")
	private String email;
	@NonNull
	@NotNull
	@Size(min=1,max=50, message = "Adresse non valide")
	private String address;
	@NonNull
	@NotNull
	@Digits(fraction = 0, integer = 10, message = "Numéro de téléphone non valide")
	private String phone;
	@ToString.Exclude
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "customer")
	private Collection<AlbOrder> albOrders;
	
}
