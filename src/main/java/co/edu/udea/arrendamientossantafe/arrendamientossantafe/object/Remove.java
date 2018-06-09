package co.edu.udea.arrendamientossantafe.arrendamientossantafe.object;



public class Remove {
	  private int code;
	  private String message;
	  private Agency agency;

	  public Remove(Agency agency, int code, String message){
	    this.code=code;
	    this.message=message;
	    this.agency = agency;
	  }
	  public int getCode() {
		  return this.code;
	  }
	  public String getMessage() {
		  return this.message;
	  }
	  public void setCode(int code) {
		  this.code=code;
	  }
	  public void setMessage(String message) {
		  this.message=message;
	  }
	  
	  
	  public Agency getAgency() {
	    return agency;
	  }
	  public void setAgency(Agency agency){
	    this.agency = agency;
	  }
	}