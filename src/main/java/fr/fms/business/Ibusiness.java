package fr.fms.business;

import java.util.List;
import java.util.Optional;

import fr.fms.entities.AlbOrder;
import fr.fms.entities.Album;
import fr.fms.entities.Customer;

public interface Ibusiness {
	public Optional<Album> readOneAlbum(Long id);
	public void addToCart (Album album);
	public void removeFromCart(Long id);
	public Optional<Customer> readOneCustomer(Long id);
	public Long order(Long id);
	public Optional<AlbOrder> readOneAlbOrder(Long id);
}
