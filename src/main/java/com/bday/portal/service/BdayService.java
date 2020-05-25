package com.bday.portal.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;


import java.util.Comparator;
import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bday.portal.model.Bday;
import com.bday.portal.repository.BdayRepository;


@Service
public class BdayService {

	@Autowired
	private EntityManager entity;
	@Autowired
	private BdayRepository bdayRepo;
	
	public List<Bday> getAllEmployees() {
		Date today=new Date();
		Date yesterday=new Date(System.currentTimeMillis()-24*60*60*1000);
		List<Bday> xlist=new ArrayList<>();
		xlist=bdayRepo.findAll();	
	xlist.sort(Comparator.comparing(Bday::getDob));
		
	List<Bday> List1=new ArrayList<>();
	for(Bday x:xlist) {
		
		x.getDob().setYear(today.getYear());
		List1.add(x);
	}
//	System.out.println(yesterday.toString());
	List1.sort(Comparator.comparing(Bday::getDob));
	List<Bday> l1=new ArrayList<>();
	List<Bday> l2=new ArrayList<>();
	for(Bday b:List1) {
		if(b.getDob().after(yesterday)) {
			l1.add(b);
		}
		else l2.add(b);
	}
	
	l1.sort(Comparator.comparing(Bday::getDob));
	l2.sort(Comparator.comparing(Bday::getDob));
	for(Bday b:l2) {
		l1.add(b);
	}
	
	
	for(Bday z:l1) {
		String o="";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
		o+=simpleDateFormat.format(z.getDob()) +" - ";
		o+=z.getDob().getDate();
		z.setDate1(o);
	}
	
	
	
	return l1;
	}
	
	public Bday addEmployee(Bday bday) {
		return bdayRepo.save(bday);
	}

	public String delete(Long eid) {
		bdayRepo.deleteById(eid);
		return "Deleted";
	}
	
	public List<Bday> getBdaySearch(String xyz){
		List<Bday> empty=new ArrayList<>();
		System.out.println("-x--"+ xyz +"-----");
		if(xyz.isEmpty()) {
			return empty;
		}
		List<Bday> xlist=new ArrayList<>();
		xlist=bdayRepo.findAll();	
		
		List<Bday> l1=new ArrayList<>();
		for(Bday b:xlist) {
				l1.add(b);
			}
			
			for(Bday z:l1) {
				String o="";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
				o+=simpleDateFormat.format(z.getDob()) +" - ";
				o+=z.getDob().getDate();
				z.setDate1(o);
				
			}
			
			List<Bday> l2=new ArrayList<>();
			for(Bday b:l1) {
				if(b.getDate1().toLowerCase().contains(xyz.toLowerCase())|| 
						b.getEmail().toLowerCase().equals(xyz.toLowerCase()) || 
						String.valueOf(b.getEid()).equals(xyz.toLowerCase()) || 
						b.getName().toLowerCase().contains(xyz.toLowerCase())) {
					l2.add(b);
				}
			}
			
			System.out.println(l2.toString());
		return l2;
	}
	

	
	
}
