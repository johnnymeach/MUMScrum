
package org.mum.scrum.services;

import java.util.List;
import org.mum.scrum.entities.Sprint;

public interface SprintService {

	public List<Sprint> findAll();
	
	public Sprint findSprintByID(int id);
	
	public void save(Sprint sprint);
	
	public void deleteSprint(int id);

}
