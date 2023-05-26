package fr.fms.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.AlbumRepository;
import fr.fms.entities.Album;
import javassist.expr.NewArray;
@Controller
public class AlbumController {
	@Autowired
	AlbumRepository albumRepository;
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name="page", defaultValue = "0") int page,
									@RequestParam(name="keyword", defaultValue = "") String kw) {
		Page<Album> albums = albumRepository.findByAlbumNameContains(kw, PageRequest.of(page, 5));
		model.addAttribute("listAlbums", albums.getContent());
		model.addAttribute("pages", new int[albums.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", kw);
		return "albums";
	}
	@GetMapping("/delete")
	public String delete(Long id, int page, String keyword) {
		albumRepository.deleteById(id);
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}
	@GetMapping("/album")
	public String album(Model model) {
		model.addAttribute("album", new Album());
		return "album";
	}
	@PostMapping("/save")
	public String save(Model model, @Valid Album album, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "album";
		albumRepository.save(album);
		return "redirect:/index";
	}
}
