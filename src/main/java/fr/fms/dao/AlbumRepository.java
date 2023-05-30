package fr.fms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fr.fms.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{
	
	public Page<Album> findByAlbumNameContains(String albumName, Pageable pageable);
	public Page<Album> findByMusicGenreId(Long musicGenreId, Pageable pageable);
	@Transactional
	@Modifying
	@Query("update Album a set a.albumName = ?2 , a.bandName = ?3, a.releaseYear = ?4, a.price = ?5 where a.id = ?1")
	public int updateAlbumById(Long id, String albumName, String bandName, int releaseYear, double price);
}
