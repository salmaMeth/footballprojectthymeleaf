
  package Tournoi.Via.Web.Controller;
  
  import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import
  org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Tournoi.Via.Web.Model.User;
import Tournoi.Via.Web.Repository.UserRepository;


  
  @Controller 

  public class LoginController {
  
	  
	  @Autowired
	    private UserRepository userRepository;
	     
	  
	
		  @RequestMapping("/login")
			public String showLoginPage(Model model, @RequestParam(name = "username" ,required=false) String username,
	        		 @RequestParam(name = "password", required=false) String password,RedirectAttributes attr)  {
		        User user = userRepository.getUserByUsernamePassword(username,password);
		        
					if(user==null)
					{  
						
						
			            return "login";

						
						 } 
					model.addAttribute("username", username);
					model.addAttribute("password", password);
					 		return "redirect:tableTeams";
 }
		
					
				
			
	/*
	 * @RequestMapping("/login") public String showLoginPage() { Authentication
	 * authentication=SecurityContextHolder.getContext().getAuthentication();
	 * if(authentication==null || authentication instanceof
	 * AnonymousAuthenticationToken) { return "login"; } return
	 * "/pages/landing_page"; }
	 */
	      
	  }

	  
 