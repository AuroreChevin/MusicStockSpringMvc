package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.dao.AlbumRepository;
import fr.fms.entities.Album;
@Controller
public class AlbumController {
	@Autowired
	AlbumRepository albumRepository;
	@GetMapping("/index")
	public String index(Model model) {
		List<Album> albums = albumRepository.findAll();
		model.addAttribute("listAlbums", albums);
		return "albums";
	}
}
