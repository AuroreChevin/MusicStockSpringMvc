package fr.fms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.fms.dao.MusicGenreRepository;

@Controller
public class MusicGenreController {
	@Autowired
	MusicGenreRepository musicGenreRepository;
}
