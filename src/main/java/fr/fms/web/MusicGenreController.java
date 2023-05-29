package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.dao.MusicGenreRepository;
import fr.fms.entities.MusicGenre;

@Controller
public class MusicGenreController {
	@Autowired
	MusicGenreRepository musicGenreRepository;
	@GetMapping("/music")
	public String music(Model model) {
	List<MusicGenre> musicGenres = musicGenreRepository.findAll();
	model.addAttribute("listMusicGenres", musicGenres);
		return "musicGenres";
	}
}
