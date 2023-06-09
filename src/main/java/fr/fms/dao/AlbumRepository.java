package fr.fms.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{
	
	public Page<Album> findByAlbumNameContains(String albumName, Pageable pageable);
	public Page<Album> findByMusicGenreId(Long musicGenreId, Pageable pageable);	
}
