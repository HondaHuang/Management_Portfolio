package com.hh.demo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hh.demo.dao.ClientPocDAO;
import com.hh.demo.dao.ConsultantDAO;
import com.hh.demo.model.ClientPOC;
import com.hh.demo.model.Consultant;
import com.hh.demo.model.Portfolio;
import com.hh.demo.model.Project;
import com.hh.demo.service.PortfolioService;
import com.hh.demo.service.ProjectService;

@SpringBootApplication
public class ManagementPortfolioApplication implements CommandLineRunner{

	@Autowired
	private ConsultantDAO consultantDAO;
	@Autowired
	private ClientPocDAO pocDAO;
	@Autowired
	private PortfolioService portfolioService;
	@Autowired
	private ProjectService projectService;
	
	private static List<Consultant> consultantList;
	private static List<ClientPOC> clientPOCList;
	
	private static List<Consultant> consultantList2;
	private static List<ClientPOC> clientPOCList2;
	private static List<Project> projectList;
	
	public static void main(String[] args) {
		
		SpringApplication.run(ManagementPortfolioApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		consultantDAO.save(new Consultant("Mike", "Engineer", 2));
		consultantDAO.save(new Consultant("Derek", "Engineer", 3));
		consultantDAO.save(new Consultant("Honda", "Engineer", 1));
		consultantDAO.save(new Consultant("Aaron", "Tester", 4));
		consultantDAO.save(new Consultant("Joseph", "DevOps", 5));
		consultantDAO.save(new Consultant("Kelly", "UI Design", 6));
		consultantDAO.save(new Consultant("Randy", "DBA", 7));
		consultantDAO.save(new Consultant("Larry", "Analyst", 8));
		pocDAO.save(new ClientPOC("Hasib", "Hasib@aol.com"));
		pocDAO.save(new ClientPOC("Chang", "Chang@aol.com"));
		pocDAO.save(new ClientPOC("Tom", "Tom@gmail.com"));
		pocDAO.save(new ClientPOC("Rick", "Rick@yahoo.com"));
		pocDAO.save(new ClientPOC("Frank", "Frank@aol.com"));
		pocDAO.save(new ClientPOC("Patrick", "Patrick@hotmail.com"));
		pocDAO.save(new ClientPOC("Amanda", "Amanda@aol.com"));
		pocDAO.save(new ClientPOC("Charlie", "Charlie@mphasis.com"));
		
		////////////
		// since you need to add lists of people into project, those need to be made first
		// need to make these lists STRICTLY from people already in the db
		////////////
		consultantList = new ArrayList<Consultant>();//returns a list object
		consultantList.add(consultantDAO.getOne(1));
		consultantList2 = new ArrayList<Consultant>();//returns a list object
		consultantList2.add(consultantDAO.getOne(3));
		
		clientPOCList = new ArrayList<ClientPOC>();
		clientPOCList.add(pocDAO.getOne(2));
		
		clientPOCList2 = new ArrayList<ClientPOC>();
		clientPOCList2.add(pocDAO.getOne(1));
		
		////////////
		// making dummy project
		////////////
		projectService.create(new Project(
				"CBRE",
				"Dummy Type",
				Date.valueOf("2019-01-01"),
				Date.valueOf("2019-12-12"),
				12,
				"Active",
				"Agile",
				"This is a dummy project",
				"Hammer, Screwdriver, Wrench",
				"PM",
				"DM",
				"Dummy Client",
				10000000,
				10,
				consultantList,
				clientPOCList
				));
		
		projectService.create(new Project(
				"FEDEX",
				"Dummy Type",
				Date.valueOf("2019-01-01"),
				Date.valueOf("2019-12-12"),
				12,
				"Active",
				"Agile",
				"This is a dummy project",
				"Hammer, Screwdriver, Wrench",
				"PM",
				"DM",
				"Dummy Client",
				10000000,
				10,
				consultantList2,
				clientPOCList2
				));
		
		projectList = new ArrayList<Project>();
		projectList.add(projectService.get(1));

		projectList.add(projectService.get(2));
		
		/////////
		//dummy portfolio
		/////////
		portfolioService.create(new Portfolio(
				"Delivery",
				12345.67, 
				"Vinay", 
				projectList
				));
	}

}
