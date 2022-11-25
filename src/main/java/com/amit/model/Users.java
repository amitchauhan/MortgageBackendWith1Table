package com.amit.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="users")
@DynamicInsert
public class Users {
	
	@Id
	@Column(nullable=false, unique=true, length=45)
	@Email(message = "Email address is not valid !!")
	private String email;
	
	@Column(nullable=false, length = 30)
	@Size(min = 4, message = "Username must be min of 4 characters !!")
	private String name;
	
	@Column(nullable=false, unique=false, length = 30)
	private String address;	
	
	@Column(nullable=false, unique=true, length = 10)
	private String mobileNo;
	
	@Column(nullable=false, unique=false, length = 10)
	private String aincome;
	
	@Column(nullable=false, unique=false, length = 10)
	private String mexpense;
	
	@Column(nullable=false, unique=false, length = 10)
	private String deposit;
	
	@Column(nullable=false, unique=false, length = 10)
	private String propValue;
	
	@Column(nullable=false, unique=false, length = 10)
	private String age;
	
	@Column(nullable=false, length=64)
	private String password;
	
	@Column(nullable=false, length=64)
	@ColumnDefault("'Underwriting'")
	private String appStage;

	public Users() {
		super();
		
	}
	
	
	public Users(@Email(message = "Email address is not valid !!") String email,
			@Size(min = 4, message = "Username must be min of 4 characters !!") String name, String address,
			String mobileNo, String aincome, String mexpense, String deposit, String propValue, String age,
			String password, String appStage) {
		super();
		this.email = email;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.aincome = aincome;
		this.mexpense = mexpense;
		this.deposit = deposit;
		this.propValue = propValue;
		this.age = age;
		this.password = password;
		this.appStage=appStage;
	}





	public String getAincome() {
		return aincome;
	}





	public void setAincome(String aincome) {
		this.aincome = aincome;
	}





	public String getMexpense() {
		return mexpense;
	}





	public void setMexpense(String mexpense) {
		this.mexpense = mexpense;
	}





	public String getDeposit() {
		return deposit;
	}





	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}





	public String getPropValue() {
		return propValue;
	}





	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}





	public String getAge() {
		return age;
	}





	public void setAge(String age) {
		this.age = age;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}



	public String getAppStage() {
		return appStage;
	}


	public void setAppStage(String appStage) {
		this.appStage = appStage;
	}


	public void setPassword(String password) {
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		String encryptedPwd = pwdEncoder.encode(password);
		this.password = encryptedPwd;
	}
	

	
	public void setNewPassword(String password) {
//		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
//		String encryptedPwd = pwdEncoder.encode(password);
		this.password = password;
	}




	@Override
	public String toString() {
		return "Users [email=" + email + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo
				+ ", aincome=" + aincome + ", mexpense=" + mexpense + ", deposit=" + deposit + ", propValue="
				+ propValue + ", age=" + age + ", password=" + password + ", appStage=" + appStage + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(address,email, mobileNo, name, password, aincome, mexpense, deposit, propValue, age, appStage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(address, other.address) && 
				Objects.equals(email, other.email) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(aincome, other.aincome) && Objects.equals(mexpense, other.mexpense)
				&& Objects.equals(deposit, other.deposit) && Objects.equals(propValue, other.propValue)
				&& Objects.equals(age, other.age) && Objects.equals(appStage, other.appStage);
				
	}
	
}
