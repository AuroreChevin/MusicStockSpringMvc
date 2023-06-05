package fr.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.AlbOrder;

public interface AlbOrderRepository extends JpaRepository<AlbOrder, Long> {

}
