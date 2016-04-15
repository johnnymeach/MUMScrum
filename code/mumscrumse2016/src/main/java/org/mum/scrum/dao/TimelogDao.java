package org.mum.scrum.dao;

import java.util.List;

import org.mum.scrum.entities.Timelog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelogDao extends JpaRepository<Timelog, Integer> {
	List<Timelog> findByUserstoryId(int id);
}
