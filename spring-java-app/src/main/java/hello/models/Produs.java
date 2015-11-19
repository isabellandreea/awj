package hello;

import java.util.List;
import java.util.ArrayList;

public class Produs {
  private String name;
  private int Pret;
  private int id;

  public Produs() {}

  public Produs(int id, String name, int Pret) {
      this.name = name;
	  this.pret=pret;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

    public int getPret() {
      return this.Pret;
  }
  public int getId() {
    return this.id;
  }

   public setName(string n){
	  this.name=n;
  }
  
  public setPret(int p){
	  this.pret=p;
  }
  
  public setID(int id){
	  this.id=id;
  }
}