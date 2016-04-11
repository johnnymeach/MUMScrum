package org.mum.scrum.dao;

import org.mum.scrum.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintDao extends JpaRepository<Sprint, Integer> {


}
