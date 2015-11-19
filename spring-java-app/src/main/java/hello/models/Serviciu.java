package hello;

import java.util.List;
import java.util.ArrayList;

public class Serviciu {
  private String name;
  private int salariu;
  private int id;


  public Serviciu() {}

  public Serviciu(int id,  int salariu, String name) {
      this.name = name;
	  this.id = id;
	  this.salariu=salariu;
  }
 
  public String getName() {
      return this.name;
  }

  
  public int getId() {
    return this.id;
	}
  
  public setName(string n){
	  this.name = n;
  }
  
  public setID(int id){
	  this.id=id;
  }
  
  
  public setSalariu(int salariu){
	  this.salariu = salariu;
  }

}