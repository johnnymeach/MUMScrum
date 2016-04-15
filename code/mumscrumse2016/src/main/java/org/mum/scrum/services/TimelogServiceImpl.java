package org.mum.scrum.services;

import org.mum.scrum.dao.TimelogDao;
import org.mum.scrum.entities.Timelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TimelogServiceImpl implements TimelogService{

	@Autowired
	private TimelogDao timelogDao;
	
	@Override
	public void save(Timelog timelog) {
		timelogDao.save(timelog);		
	}
}
