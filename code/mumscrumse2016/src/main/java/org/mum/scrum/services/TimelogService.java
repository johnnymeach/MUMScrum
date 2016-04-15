package org.mum.scrum.services;

import java.util.List;

import org.mum.scrum.entities.Timelog;

public interface TimelogService {
	public void save(Timelog timelog);
	public List<Timelog> findTimelogByUserstoryId(int id);
}
