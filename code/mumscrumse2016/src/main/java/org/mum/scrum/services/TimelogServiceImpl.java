package org.mum.scrum.services;

import java.util.Date;
import java.util.List;

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
	public List<Timelog> findTimelogByUserstoryId(int id){
		return timelogDao.findByUserstoryId(id);
	}
	
	public Timelog findByUserstoryIdAndUpdatedDate(int id, Date date){
		return timelogDao.findByUserstoryIdAndUpdatedDate(id, date);
	}
}
