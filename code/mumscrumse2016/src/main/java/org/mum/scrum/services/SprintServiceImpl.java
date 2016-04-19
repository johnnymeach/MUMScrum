
package org.mum.scrum.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.mum.scrum.dao.*;
import org.mum.scrum.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SprintServiceImpl implements SprintService
{
	@Autowired
	private UserStoryDao userstoryRepository;
	@Autowired
	private TimelogDao timelogRepository;
	
	@Autowired
	private SprintDao sprintRepository;

	@Autowired
	private ProjectDao projectRepository;
	
	@Override
	public List<Sprint> findAll() {
		
		return sprintRepository.findAll();
	}
	
	@Override
	public Sprint findSprintByID(int id) {
		
		return sprintRepository.findOne(id);
	}
	
	@Override
	public void save(Sprint sprint) {
		
		sprintRepository.save(sprint);
	}

	@Override
	public void deleteSprint(int id) {
		
		sprintRepository.delete(id);
	}

	@Override
	public List<Project> getAllProject() {
		
		return projectRepository.findAll();
	}

	@Override
	public List<Sprint> findSprintByProject(Project project) {
		
		return sprintRepository.findByProject(project);
	}
	
	@Override
	public List<Sprint> findSprintByProjectId(int id) {
		return sprintRepository.findByProjectId(id);
	}
	
	protected int getTotalEstimateTime(List<Userstory> list){
		int ret = 0;
		for(int i = 0; i < list.size(); i++){
			Userstory u = list.get(i);
			ret += u.getEstimatedTime();
		}
		return ret;
	}
	protected int getLoggedTimeByDate(List<Timelog> list, Date date){
		int hours = 0;
		for(int j = 0; j < list.size(); j++){
			Timelog tl = list.get(j);
			if(tl.getUpdatedDate().compareTo(date) < 0){
				hours += tl.getDuration();
			}
		}
		return hours;
	}
	protected int getRemainingTimeByDate(List<Timelog> list, Date date, int total){
		int ret = 0;
		ret = total - this.getLoggedTimeByDate(list, date);
		return ret;
	}
	public List<Integer> getExpectedTimeList(Sprint s){
		List<Integer> list = new ArrayList<Integer>();
		long ed = s.getEndDate().getTime();
		long sd = s.getStartDate().getTime();
		long daynum = (ed - sd)/(1000*60*60*24);
		List<Userstory> backlog = userstoryRepository.findBySprintId(s.getId());
		int total = this.getTotalEstimateTime(backlog);
		int g = (int) (total/daynum);
		for(int i = 0; i < daynum - 1; i++){
			list.add(total - g * i);
		}
		list.add(0);
		return list;
	}
	public List<Integer> getRemainingTimeList(Sprint s){
		List<Integer> list = new ArrayList<Integer>();
		List<Userstory> backlog = userstoryRepository.findBySprintId(s.getId());
		int total = this.getTotalEstimateTime(backlog);
		List<Timelog> timelogs = new ArrayList<Timelog>();
		for(int i = 0; i < backlog.size(); i++){
			Userstory u = backlog.get(i);
			List<Timelog> tmp = timelogRepository.findByUserstoryId(u.getId());
			timelogs.addAll(tmp);
		}
		long ed = s.getEndDate().getTime();
		long sd = s.getStartDate().getTime();
		long daynum = (ed - sd)/(1000*60*60*24);
		Date date = new Date(sd);
		long t = sd;
		for(int i = 0; i < daynum; i++){
			int h = this.getRemainingTimeByDate(timelogs, date, total);
			list.add(h);
			t += 24*60*60*1000;
			date.setTime(t);
		}
		return list;
	}
	public List<String> getRemainingTimeLabelList(Sprint s){
		List<String> list = new ArrayList<String>();
		long ed = s.getEndDate().getTime();
		long sd = s.getStartDate().getTime() ;
		long daynum = (ed - sd)/(1000*60*60*24);
		SimpleDateFormat dt = new SimpleDateFormat("MM-dd"); 
		for(int i = 1; i <= daynum; i++){
			Date n = new Date(sd);
			sd += (1000*60*60*24);
			list.add(dt.format(n));
		}
		return list;
	}
}

