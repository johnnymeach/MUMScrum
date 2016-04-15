package org.mum.scrum.dao;

import org.mum.scrum.entities.Timelog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelogDao extends JpaRepository<Timelog, Integer> {

}
