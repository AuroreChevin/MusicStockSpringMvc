package fr.fms.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import fr.fms.business.IbusinessImpl;
import fr.fms.dao.AlbOrderRepository;
import fr.fms.dao.AlbumRepository;
import fr.fms.dao.CustomerRepository;
import fr.fms.dao.OrderItemRepository;
import fr.fms.dao.MusicGenreRepository;
import fr.fms.entities.AlbOrder;
import fr.fms.entities.Album;
import fr.fms.entities.Customer;
import fr.fms.entities.OrderItem;
import fr.fms.entities.MusicGenre;
@Controller
public class AlbumController {
	@Autowired
	AlbumRepository albumRepository;
	@Autowired
	MusicGenreRepository musicGenreRepository;
	@Autowired
	OrderItemRepository orderItemRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AlbOrderRepository albOrderRepository;
	@Autowired
	IbusinessImpl business;
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name="page", defaultValue = "0") int page,
									@RequestParam(name="keyword", defaultValue = "") String kw,
									@RequestParam(name="musicGenreId", defaultValue = "0") Long musicGenreId) {
		List<MusicGenre> musicGenres = musicGenreRepository.findAll();
		Page<Album> albums;
		if(musicGenreId==0)
			albums = albumRepository.findByAlbumNameContains(kw, PageRequest.of(page, 5));
		else {
			albums = albumRepository.findByMusicGenreId(musicGenreId, PageRequest.of(page, 5));
		}
		model.addAttribute("listMusicGenres", musicGenres);
		model.addAttribute("listAlbums", albums.getContent());
		model.addAttribute("pages", new int[albums.getTotalPages()]);
		model.addAttribute("musicGenreId", musicGenreId);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", kw);
		return "albums";
	}
	@GetMapping("/delete")
	public String delete(Long id, int page, String keyword) {
		albumRepository.deleteById(id);
		System.out.println("Supprimé");
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}
	@GetMapping("/album")
	public String album(Model model) {
		model.addAttribute("album", new Album());
		List<MusicGenre> musicGenres = musicGenreRepository.findAll();
		model.addAttribute("listMusicGenres", musicGenres);
		return "album";
	}
	@PostMapping("/save")
	public String save(@Valid Album album, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "album";
			albumRepository.save(album);	
		System.out.println(album);
		System.out.println("Enregistré");
		return "redirect:/index";
	}
	@GetMapping("/edit")
	public String edit(Long id, Model model) {
		Optional<Album> alb = business.readOneAlbum(id);
		if(alb.isPresent())		System.out.println(alb.get());
		Album album = alb.get();
		model.addAttribute("album", album);
		List<MusicGenre> musicGenres = musicGenreRepository.findAll();
		model.addAttribute("listMusicGenres", musicGenres);
		return "album";
	}
	@GetMapping("/cart")
	public String cart(Model model) {
		double total = 0;
		ArrayList<Album> cart = business.getCart();
		System.out.println(cart);
		total = business.getTotal();
		if(business.isEmpty())
			model.addAttribute("cartEmpty", cart);
		else {
		model.addAttribute("cart", cart);
		model.addAttribute("total", total);}
		return "cart";
	}
	@GetMapping("/addCart")
	public String addCart(Long id) {		
		Optional<Album> alb = business.readOneAlbum(id);
		if(alb.isPresent())		System.out.println(alb.get());
		Album album = alb.get();
		business.addToCart(album);		
		return "redirect:/index";
	}
	@GetMapping("/deleteAlbumCart")
	public String delete(Long id) {
		Optional<Album> alb = business.readOneAlbum(id);
		if(alb.isPresent())		System.out.println(alb.get());
		Album album = alb.get();
		business.removeFromCart(album.getId());
		System.out.println("Supprimé");
		return "redirect:/cart";
	}
	
	@GetMapping("/customerform")
	public String customerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerform";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid Customer customer, BindingResult bindingResult, Model model) {		
		if(bindingResult.hasErrors()) return "customerform";
		customerRepository.save(customer);
	System.out.println(customer.getCustomerId());
	System.out.println("Enregistré");	
	model.addAttribute("customerOk", customer);
		return "order";
	}
	@GetMapping("/saveOrder")
	public String saveOrder(Model model, Long customerId) {	
		Long orderId = business.order(customerId);
		Optional<AlbOrder> ord = business.readOneAlbOrder(orderId);
		if(ord.isPresent())		System.out.println(ord.get());
		AlbOrder albOrder = ord.get();
		model.addAttribute("albOrder", albOrder);
		return "index";
	}
}
