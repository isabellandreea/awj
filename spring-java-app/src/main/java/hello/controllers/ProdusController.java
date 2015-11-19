package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;

@RestController
public class ProdusController {
  private List<Produs> produs = new ArrayList<Produs>();

  ProdusController() {
    Produs p1 = new Produs(1, "Pix", 2);
    Produs p2 = new Produs(2, "Caiet",7);
    Produs p3 = new Produs(3, "Stilou",15);

    produs.add(p1);
    produs.add(p2);
    produs.add(p3);
  }

  @RequestMapping(value="/produs", method = RequestMethod.GET)
  public List<Produs> index() {
    return this.produs;
  }
	
	@RequestMapping(value="/produs", method = RequestMethod.POST)
  public ResponseEntity post() {
    
	  Produs pp = new Produs(4, "Carte", 27);
	  produs.add(pp);
    
    return new ResponseEntity<Produs>(pp, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
	

	@RequestMapping(value="/produs/{id}", method = RequestMethod.PUT)
	public ResponseEntity put(@PathVariable("id") int id) {
	for(Produs p : this.produs) {
      if(p.getId() == id) {
		  p.setID(5);
		  p.setName("Penar");
		  p.setPret(50);
		  
		return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


   @RequestMapping(value="/produs/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Produs p : this.produs) {
      if(p.getId() == id) {
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
  
  @RequestMapping(value="/persoana/{id}", method = RequestMethod.DEL)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Produs p : this.produs) {
      if(p.getId() == id) {
        this.produs.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}