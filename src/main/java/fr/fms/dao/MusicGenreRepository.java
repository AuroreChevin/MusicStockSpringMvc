package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.MusicGenre;

public interface MusicGenreRepository extends JpaRepository<MusicGenre, Long>{

}
