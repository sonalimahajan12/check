package io.sonali.store;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class Store {
	@NotEmpty(message = "Id must not be empty")
	@NotNull
	private Integer id;
	private String name;
	private String description;
	
	
	public Store() {
		super();
	}
	

	public Store(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	
	
	

}
