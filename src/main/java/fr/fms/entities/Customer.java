package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private String name;
	@NonNull
	private String surname;
	@NonNull
	private String email;
	@NonNull
	private String address;
	@NonNull
	private String phone;
	@ToString.Exclude
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "customer")
	private Collection<AlbOrder> albOrders;
	
}
