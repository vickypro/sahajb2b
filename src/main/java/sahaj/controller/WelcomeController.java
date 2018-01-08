package sahaj.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 


@Controller
public class WelcomeController {

	
	/*@RequestMapping(value = "/PostFormDataJSONArray", method = RequestMethod.POST)
	public @ResponseBody List<Person> PostFormDataJSONArray(@RequestBody List<Person> person) {	
		System.out.println("ABCDEFGHIJKLMn");
		for(Person abc:person)
		{
			System.out.println("name:"+abc.getName());
			System.out.println("loaction:"+abc.getLocation());
		}
		return person;
	
	}*/

	@RequestMapping("/getData")
	public void showUpload1() {
		System.out.println("ABCd---");
	}
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("loginPage");
		return model;
	}
	
	@RequestMapping(value = { "item"}, method = RequestMethod.GET)
	public ModelAndView item() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome123");
		return model;
	}
	
	
	@RequestMapping(value = { "create"}, method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView model = new ModelAndView();
		model.setViewName("create");
		return model;
	}


	@RequestMapping(value = { "temp"}, method = RequestMethod.GET)
	public ModelAndView temp() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;}
		
	 
	
	@RequestMapping(value = { "/homePage","/welcome"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!.");
			
		}

		if (logout != null) {
			 
			 
			model.addObject("message", "You've been logged out successfully.");
		}

		model.setViewName("loginPage");
		return model;
	}
/*	@RequestMapping(value = { "/homePage","/welcome"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		Database d=new Database();
		d.database();
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	*/
	}
