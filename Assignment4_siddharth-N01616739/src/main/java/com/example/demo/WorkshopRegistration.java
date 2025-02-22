package com.example.demo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class WorkshopRegistration {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "First Name is required")
	    private String firstName;

	    @NotBlank(message = "Last Name is required")
	    private String lastName;

	    @NotBlank(message = "Company/Institution is required")
	    private String company;

	    @NotBlank(message = "Address is required")
	    private String address;

	    public WorkshopRegistration() {
			
		}
	    
	    
		@NotBlank(message = "City is required")
	    private String city;

	    @NotBlank(message = "State is required")
	    private String state;

	    @NotBlank(message = "Country is required")
	    private String country;

	    @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is required")
	    private String email;


	    @NotBlank(message = "Phone number is required")
	    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	    private String phoneNumber;

	    private String mealPreference;
	    private String paymentMode;
	    private String chequeNumber;
	    private String bankName;
	    private String payableAt;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getMealPreference() {
			return mealPreference;
		}
		public void setMealPreference(String mealPreference) {
			this.mealPreference = mealPreference;
		}
		public String getPaymentMode() {
			return paymentMode;
		}
		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}
		public String getChequeNumber() {
			return chequeNumber;
		}
		public void setChequeNumber(String chequeNumber) {
			this.chequeNumber = chequeNumber;
		}
		public String getBankName() {
			return bankName;
		}
		public void setBankName(String bankName) {
			this.bankName = bankName;
		}
		public String getPayableAt() {
			return payableAt;
		}
		public void setPayableAt(String payableAt) {
			this.payableAt = payableAt;
		}

}
