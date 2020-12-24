package com.nagarro.techassignment.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.techassignment.entity.Statement;
import com.nagarro.techassignment.exception.RecordNotFoundException;
import com.nagarro.techassignment.repository.StatementRepository;
import com.nagarro.techassignment.service.StatementService;

@RestController
public class AccountController {
	
	@Autowired
	private StatementService statementService;
	
	@Autowired
	StatementRepository statementRepository;
	
	
	  @GetMapping("/accounts/{accountId}") 
	  @ResponseBody
	  public ResponseEntity<List<Statement>> usersStatusCheck(HttpServletRequest
	  request, @Valid @PathVariable("accountId") Long accountId) throws Exception
	 
    					
    {
		try {
			return new ResponseEntity<>(statementService.getThreeMonthBackStatement(accountId), HttpStatus.OK);

		} catch (RecordNotFoundException rne) {
			throw new RecordNotFoundException("Record not found");
		}
		catch (Exception e) {
			throw new Exception("Some error has occured, we are fixing on it");
		}
 	
    }
    
    @GetMapping("/accounts/{accountId}/filter")
    public ResponseEntity<List<Statement>> adminStatusCheck(
    								@Valid @RequestParam(defaultValue="") String Amount1, 
    								@Valid @RequestParam(defaultValue="") String Amount2,
    								@Valid @RequestParam String Date1, 
    								@Valid @RequestParam String Date2,
    								@Valid @PathVariable("accountId") long accountId, 
    							HttpServletRequest request) throws Exception {

    	List<Statement> statements = new ArrayList();
    	try {
    		if ((!Date1.isEmpty() && !Date2.isEmpty()) && (Date1!=null && Date2!=null)) {
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    			LocalDate fromDate=LocalDate.parse(Date1, formatter);
    			LocalDate toDate=LocalDate.parse(Date2, formatter);
    			if(!Amount1.isEmpty() && !Amount2.isEmpty() && (Amount1 != null && Amount2 != null)) {
    				float fromAmount = Float.parseFloat(Amount1);
    				float toAmount = Float.parseFloat(Amount2);
    				statements = statementService.getAdvancedFilteredStatement(accountId, fromDate, toDate, fromAmount, toAmount);
    			}
    			else {
    			
    			statements = statementService.getFilterByDateStatement(accountId, fromDate, toDate);
    			
    			}
    		}
    		else if(!Amount1.isEmpty() && !Amount2.isEmpty() && (Amount1 != null && Amount2 != null)) {
				float fromAmount = Float.parseFloat(Amount1);
				float toAmount = Float.parseFloat(Amount2);
				statements =  statementService.getFilterByAmountStatement(accountId, fromAmount, toAmount);
			}
    		else {
    			throw new RecordNotFoundException("Satisfying record was not found");
    			}	
		}
    	catch (Exception e) {

			throw new Exception(HttpStatus.BAD_REQUEST.name());
		}
		return new ResponseEntity<>(statements, HttpStatus.OK);
    	
    }
    
    @GetMapping("/welcome")
    public String welcome() {
        return "Greetings";
    }
      
}
