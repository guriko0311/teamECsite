package com.internousdev.texas.dto;

public class DestinationInfoDTO {

	public int id;

	public String userId;

	public String familyName;

	public String firstName;

	public String familyNameKana;

	public String firstNameKana;

	public String email;

	public String telNumber;

	public String userAddress;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getFamilyName(){
		return familyName;
	}

	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName =firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana = firstNameKana;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getTelNumber(){
		return telNumber;
	}

	public void setTelNumber(String telNumber){
		this.telNumber = telNumber;
	}

	public String getUserAddress(){
		return userAddress;
	}

	public void setUserAddress(String userAddress){
		this.userAddress = userAddress;
	}

}
