package com.example.demo.ex1;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
	public class PersonForm {

		@NotNull
		@Size(min=2, max=30)
		private String name;

		@NotNull
		@Min(18)
		private Integer age;

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String toString() {
			return "Person(Name: " + this.name + ", Age: " + this.age + ")";
		}
		
		
		@NotBlank
	    @Email(message = "Email should be valid")
	    private String email;

	    @Pattern(regexp = "0\\d{1,2}-\\d{1,4}-\\d{4}" , message = "xxx-xxxx-xxxx 형식")
	    private String phone;
	    
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date startdate;
	 	   
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date enddate;
	    
	    @AssertTrue (message ="시작날짜가 작아야 합니다.")
	    public Boolean getEndDateAfterStartDate() {
	    	if ( enddate != null && startdate != null )
	    		return this.enddate.after(startdate);
	    	else 
	    		return true;
	    }
	}

