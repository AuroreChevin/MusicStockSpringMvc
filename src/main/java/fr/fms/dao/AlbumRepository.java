package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
