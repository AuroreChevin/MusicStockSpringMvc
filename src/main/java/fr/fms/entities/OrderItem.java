package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @RequiredArgsConstructor @ToString
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderItemId;
	@NonNull
	@ManyToOne
	private Album album;
	@NonNull
	private int quantity;
	@NonNull
	private double price;
	@NonNull
	@ManyToOne
	private AlbOrder albOrder;
	
}
