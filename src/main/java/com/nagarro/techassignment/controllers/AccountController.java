package com.nagarro.techassignment.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.techassignment.entity.Statement;
import com.nagarro.techassignment.repository.StatementRepository;

@RestController
public class AccountController {
	
	@Autowired
	StatementRepository statementRepository;
	
    @GetMapping("/accounts/{accountId}")
    @ResponseBody
    public long usersStatusCheck(HttpServletRequest request, @PathVariable("accountId") String accountId) throws Exception 
    					
    {
//    	try {
//			System.out.println(request.getRequestURI());
//			return statementRepository.count();
//		} 
//    	
//    	catch (Exception e) {
//			// TODO Auto-generated catch block
//			throw new Exception(HttpStatus.BAD_REQUEST.name());
//		}
    	return statementRepository.count();
    	
    }
    
    @GetMapping("/accounts/{accountId}/admin")
    public String managersStatusCheck(HttpServletRequest request, @PathVariable("accountId") String accountId) throws Exception {
    	try {
			System.out.println(request.getRequestURI());
			return "Authorized manager" + accountId;
		}
    	catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception(HttpStatus.BAD_REQUEST.name());
		}
    	
    }
    
    @GetMapping("/welcome")
    public String welcome() {
        return "Greetings";
    }
    
//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){    
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//    }
//    
}
