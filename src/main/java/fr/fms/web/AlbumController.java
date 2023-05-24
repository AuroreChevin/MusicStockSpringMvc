package fr.fms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.dao.AlbumRepository;
@Controller
public class AlbumController {
	@Autowired
	AlbumRepository albumRepository;
	@GetMapping("/index")
	public String index() {
		return "albums";
	}
}
