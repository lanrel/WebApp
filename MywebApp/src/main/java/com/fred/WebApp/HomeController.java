package com.fred.WebApp;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	ModelAndView mv = new ModelAndView();
	
	@RequestMapping("home")
	public String home()
	{
		System.out.println("Hi");
		return "home";
		
	}
	
	//This is just like the above but in below method, we are passing data into server and printing it in our page unlike the above method that only display message from out jsp page and not passing any data.
	@RequestMapping("/home1")
	public String home1(@RequestParam("myName") String myName, HttpSession session)
	{
		System.out.println("Hi " + myName);
		session.setAttribute(myName, myName);
		return "home1";
		
	}
	
	//Another way of doing the above but with ModelAndView which is better and effective way of doing it is below:
		@RequestMapping("/home2")
		public ModelAndView home2(@RequestParam("name") String myName)
		{
			
			mv.addObject("name", myName);
			mv.setViewName("home2");
			return mv;
			
		}
		
		//We can even make it better by using object derived from out Alien class, this way, we can access all the properties of that class instead of passing different variables into our @RequestParam annotation which will become ineffective with time.
		@RequestMapping("/home3")
		public ModelAndView home3(Alien alien)//Again, here we are seeing how a class is instantiated and its obj. used
		{
			mv.addObject("obj", alien);
			mv.setViewName("home3");
			return mv;
			
		}
		
		//We can even make it better by using object derived from out Alien class, this way, we can access all the properties of that class instead of passing different variables into our @RequestParam annotation which will become ineffective with time.
		@RequestMapping("/home/alien")
		public ModelAndView alien(Alien alien)//Again, here we are seeing how a class is instantiated and its obj. used
		{
			mv.addObject("obj", alien);
			mv.setViewName("/home");
			return mv;
			
		}
		
		
		

}
