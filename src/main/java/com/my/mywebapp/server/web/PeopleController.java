package com.my.mywebapp.server.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.my.mywebapp.shared.models.People;
import com.my.mywebapp.server.services.PeopleService;

@RestController
//@RequestMapping("/rest/getall/")
public class PeopleController {
	
	final static Logger logger = LoggerFactory.getLogger(PeopleController.class);
        PeopleService peopleService = new PeopleService();
	
//	List<Todo> todoList = new ArrayList<>();
	
	public PeopleController(){
//		todoList.add(new Todo("Todo #1"));
//		todoList.add(new Todo("Todo #2"));
//		todoList.add(new Todo("Todo #3"));
	}
    @RequestMapping(value = "/rest/getall/",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<People> Getall() {
        List<People> peoples = peopleService.findAllPeoples();
        return peoples;
    }
    @RequestMapping(value = "/rest/save/",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestParam String surname, @RequestParam String name, @RequestParam String patr) {
        People ppp = new People(surname,name,patr);
        peopleService.savePeople(ppp);
    }
    @RequestMapping(value = "/rest/update/",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //public void update(@RequestParam(value = "id", required = false) int id) {
    public void update( @RequestParam(value = "id", required = true) int id, 
                        @RequestParam(value = "surname", required = true) String surname, 
                        @RequestParam(value = "name", required = true) String name, 
                        @RequestParam(value = "patr", required = true) String patr) {
        People ppp = peopleService.findPeople(id);
        ppp.setSurname(surname);
        ppp.setName(name);
        ppp.setPatronymic(patr);
        peopleService.updatePeople(ppp);
    }
    @RequestMapping(value = "/rest/delete/",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //public void update(@RequestParam(value = "id", required = false) int id) {
    public void update( @RequestParam int id ) {
        People ppp = peopleService.findPeople(id);
        peopleService.deletePeople(ppp);
    }

}
