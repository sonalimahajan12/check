package io.sonali.store;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.*;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import io.sonali.store.Store;
//import com.howtodoinjava.demo.exception.RecordNotFoundException; 

@RestController
@Validated
public class StoreController {
	
	@Autowired
	StoreServiceLayer serviceLayer;
	
	private String BAD_REQUEST = "BAD_REQUEST";
	private static Map<Integer, Store> storeRepo=new HashMap<>();
	static {
		Store honey=new Store();
		honey.setId(1);
		honey.setName("Honey");
		honey.setDescription("Tea");
		storeRepo.put(honey.getId(), honey);
				
		Store almond = new Store();
	      almond.setId(2);
	      almond.setName("Almond");
	      almond.setDescription("Coffee");
	      storeRepo.put(almond.getId(), almond);
	      
	}	
	@RequestMapping(value="/store")
	public ResponseEntity<Object> getStore()
	{
		return new ResponseEntity<>(storeRepo.values(),HttpStatus.OK);
	}
	
	
	
	
	
	 @RequestMapping(value="/store/{id}", method = RequestMethod.GET)
	 public @ResponseBody Store getStoreById(@PathVariable("id") Integer id) 
	 {
		 
		 	Store st=null;
				st=storeRepo.get(id);
				//if (!st.matches("-?\\d+(\\.\\d+)?"))
				
			 if(st != null ) {
					return st;
				} else {
					throw new RequestedEntityNotFound("RequestedEntityNotFoundException "+" Id: " +id+ " *** not found");
				}
			
				
	      
	 } 
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/store", method = RequestMethod.POST)
	   public ResponseEntity<Object> createStore(@RequestBody Store store) throws Exception
	 {
		 
		 //serviceLayer.perfromStore(store);
		 
		 
		// if(store.getId()==null)
//			 throw new Exception("ID cannot be empty");
		 int t=store.getId();
		
		 if (storeRepo.containsKey(t)) {
	          throw new IdAlreadyExists("This id already exists");
	        }
		 else if(t>=0 || t==0)
		 {
	      storeRepo.put(store.getId(), store);
	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
		 }
		 else {
			throw new NegativeNumberException("You can't enter negative no in Id");
		}
	     
	 }
}
