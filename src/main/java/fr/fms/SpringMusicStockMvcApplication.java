package fr.fms;
/**
 * @author ChevinA
 * 
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.business.IbusinessImpl;
import fr.fms.dao.AlbumRepository;
import fr.fms.dao.OrderItemRepository;
import fr.fms.dao.MusicGenreRepository;
import fr.fms.entities.Album;
import fr.fms.entities.OrderItem;
import fr.fms.entities.MusicGenre;

@SpringBootApplication
public class SpringMusicStockMvcApplication implements CommandLineRunner{
	@Autowired 
	AlbumRepository albumRepository;
	@Autowired
	MusicGenreRepository musicGenreRepository;
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	IbusinessImpl business;
	public static void main(String[] args) {
		SpringApplication.run(SpringMusicStockMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		generateAlbums();
		//generateOrderItem();
		//albumRepository.findAll().stream().forEach(System.out::println);
		//musicGenreRepository.findAll().stream().forEach(System.out::println);
		//System.out.println(albumRepository.findByMusicGenreId((long)2));
		//MusicGenre mg = new MusicGenre("math core");
		//System.out.println(mg.getName());
		//Album alb = new Album("Tocsin", "Year of no light", 2013, 12, mg);
		//System.out.println(alb.getBandName());
		//oderItemRepository.findAll().stream().forEach(System.out::println);
		//orderRepository.findAll().stream().forEach(System.out::println);
		//business.addToCart(alb);
		//for(Album a : business.getCart()) System.out.println(a);
	}
	/**
	 * Méthode qui génère les albums dans la table
	 */
	public void generateAlbums() {
			MusicGenre mathCore = musicGenreRepository.save(new MusicGenre("Math Core"));
			MusicGenre sludgeMetal = musicGenreRepository.save(new MusicGenre("Sludge/Stoner Metal"));
			MusicGenre trashMetal = musicGenreRepository.save(new MusicGenre("Trash Metal"));
			MusicGenre postMetal = musicGenreRepository.save(new MusicGenre("Post Metal"));
			
			albumRepository.save(new Album("Tocsin", "Year of no light", 2013, 12, postMetal));
			albumRepository.save(new Album("Reign in blood", "Slayer", 1986, 9.99, trashMetal));
			albumRepository.save(new Album("From beale street of oblivion", "Clutch", 2007, 15, sludgeMetal));
			albumRepository.save(new Album("Blues for the red sun", "Kyuss", 1992, 12, sludgeMetal));
			albumRepository.save(new Album("One of us is the killer", "The dillinger escape plan", 2013, 15.6, mathCore));
			albumRepository.save(new Album("Somewhere along the way", "Cult of Luna", 2006, 17, postMetal));
			albumRepository.save(new Album("Burn my eyes", "Machine Head", 1994, 6.5, trashMetal));
			albumRepository.save(new Album("Cowboys from hell", "Pantera", 1990, 8.5, trashMetal));
			albumRepository.save(new Album("The hunter", "Mastodon", 2011, 16.5, sludgeMetal));
			albumRepository.save(new Album("Houdini", "Melvins", 1993, 7, sludgeMetal));
			albumRepository.save(new Album("All we love we leave behind", "Converge", 2012, 15, mathCore));
			albumRepository.save(new Album("Mass IIII", "Amenra", 2008, 20, postMetal));
			albumRepository.save(new Album("Delivrance", "Corrosion of conformity", 1994, 6.99, sludgeMetal));
			albumRepository.save(new Album("Nola", "Down", 1995, 13, sludgeMetal));
			albumRepository.save(new Album("Roots", "Sepultura", 1996, 9.99, trashMetal));
			albumRepository.save(new Album("Station", "Russian Circles", 2008, 19, postMetal));
		
		
	}
	public void generateOrderItem() {
		MusicGenre postMetal = musicGenreRepository.save(new MusicGenre("Post Metal"));
		Album alb =albumRepository.save(new Album("Station", "Russian Circles", 2008, 19, postMetal));
		
		//orderItemRepository.save(new OrderItem(alb,0,0));
	}
}
