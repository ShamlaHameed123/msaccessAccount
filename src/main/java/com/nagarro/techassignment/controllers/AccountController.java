package com.nagarro.techassignment.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.techassignment.dto.RequestDTO;
import com.nagarro.techassignment.dto.StatementDto;
import com.nagarro.techassignment.entity.Statement;
import com.nagarro.techassignment.repository.StatementRepository;
import com.nagarro.techassignment.service.StatementService;

@RestController
public class AccountController {
	
	@Autowired
	private StatementService statementService;
	
	
	  @GetMapping("/accounts/{accountId}") 
	  @ResponseBody
	  public List<Statement> usersStatusCheck(HttpServletRequest
	  request, @PathVariable("accountId") Long accountId) throws IOException, ParseException
	 
    					
    {
		Date date1=new SimpleDateFormat("dd.MM.yyyy").parse("09.08.2012");  
    	return statementService.getThreeMonthBackStatement(accountId, date1);
 	
    }
    
//    @GetMapping("/accounts/{accountId}")
//    public List<StatementDto> managersStatusCheck(@Valid @RequestParam(required=false) RequestDTO dateDto,
//    								@Valid @RequestParam float min_amount, 
//    								@Valid @RequestParam float max_amount, 
//    								@Valid @PathVariable("accountId") long accountId, 
//    							HttpServletRequest request) throws IOException {
//    	try {
//    		
//			System.out.println(request.getRequestURI());
//			
//			return "Authorized manager" + accountId;
//		}
//    	catch (Exception e) {
//			// TODO Auto-generated catch block
//			throw new Exception(HttpStatus.BAD_REQUEST.name());
//		}
//    	
//    }
    
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
