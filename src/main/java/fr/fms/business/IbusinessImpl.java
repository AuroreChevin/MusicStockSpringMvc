package fr.fms.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fms.dao.AlbOrderRepository;
import fr.fms.dao.AlbumRepository;
import fr.fms.dao.CustomerRepository;
import fr.fms.dao.OrderItemRepository;
import fr.fms.entities.AlbOrder;
import fr.fms.entities.Album;
import fr.fms.entities.Customer;
import fr.fms.entities.OrderItem;
@Service
public class IbusinessImpl implements Ibusiness{
	@Autowired
	AlbumRepository albumRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AlbOrderRepository albOrderRepository;
	@Autowired
	OrderItemRepository orderItemRepository;
	private HashMap<Long, Album> cart;
	@Override
	public Optional<Album> readOneAlbum(Long id) {
		return albumRepository.findById(id);
	}
	public IbusinessImpl(HashMap<Integer, Album> cart) {
		this.cart = new HashMap<Long, Album>();
	}
	public void setCart(HashMap<Long, Album> cart) {
		this.cart = cart;
	}
	@Override
	public void addToCart(Album album) {
		Album alb = cart.get(album.getId());
		if(alb != null)
			{alb.setQuantity(alb.getQuantity()+1);
			}
		else
		cart.put(album.getId(), album);
	}
	public ArrayList<Album> getCart() {
		return new ArrayList<Album> (cart.values());
	}
	public double getTotal() {
		double []total = {0};
		cart.values().forEach((a) -> total[0] += a.getPrice() * a.getQuantity()); 	
		return total[0];
	}
	@Override
	public void removeFromCart(Long id) {
		Album album = cart.get(id);
		if(album != null) cart.remove(id);
		
	}
	 public boolean isEmpty() {
	        return cart.isEmpty();
	    }
	@Override
	public Optional<Customer> readOneCustomer(Long id) {
		return customerRepository.findById(id);
	}
	@Override
	public Long order(Long id) {
		Optional<Customer> cst = readOneCustomer(id);
		if(cst.isPresent()) {
		Customer customer = cst.get();		
		AlbOrder albOrder;
		albOrder= new AlbOrder(new Date(),getTotal(),customer);
			if(albOrderRepository.save(albOrder)!=null) {	
				for(Album album : cart.values()) {	
					orderItemRepository.save(new OrderItem(album, album.getQuantity(), album.getPrice(), albOrder));
				}
				return albOrder.getOrderId();
			}
		}
		return (long) 0;
	}
	@Override
	public Optional<AlbOrder> readOneAlbOrder(Long id) {
		return albOrderRepository.findById(id);
	}
	
}
