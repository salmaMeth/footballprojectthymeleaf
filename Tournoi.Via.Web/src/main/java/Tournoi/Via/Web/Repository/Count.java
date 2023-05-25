package Tournoi.Via.Web.Repository;

import java.util.Date;

class Count {
	 private Date dateBut;
	 private long count;
	 
	 //This constructor will be used by Spring Data JPA 
	 //for creating this class instances as per result set
	 public Count(Date dateBut,long count){

	   this.dateBut = dateBut;
	   this.count = count;

	 }
	}
