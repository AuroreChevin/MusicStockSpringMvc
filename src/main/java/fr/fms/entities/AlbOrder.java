package fr.fms.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @RequiredArgsConstructor @ToString
public class AlbOrder{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	@NonNull
	private Date date;
	@NonNull
	private double amount;
	@NonNull
	@ManyToOne
	private Customer customer;
	@ToString.Exclude
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "albOrder")
	private Collection<OrderItem> orderItems;
	
}
