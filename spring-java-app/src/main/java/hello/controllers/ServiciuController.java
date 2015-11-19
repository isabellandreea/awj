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
public class ServiciuController {
  private List<Serviciu> servicii = new ArrayList<Serviciu>();

  ServiciuController() {
    Serviciu p1 = new Serviciu(1,700,"Ospatar");
    Serviciu p2 = new Serviciu(2,900,"Bucatar" );
    Serviciu p3 = new Serviciu(3,1200,"Doctor");

    serviciu.add(p1);
    serviciu.add(p2);
    serviciu.add(p3);
  }

  @RequestMapping(value="/serviciu", method = RequestMethod.GET)
  public List<Serviciu> index() {
    return this.serviciu;
  }

@RequestMapping(value="/serviciu", method = RequestMethod.POST)
  public ResponseEntity post() {
      Serviciu pp = new Serviciu(5,800,"Profesor" );
	  serviciu.add(pp);
    return new ResponseEntity<Serviciu>(pp, new HttpHeaders(), HttpStatus.OK);
  }
  

@RequestMapping(value="/serviciu/{id}", method = RequestMethod.PUT)
public ResponseEntity put(@PathVariable("id") int id) {
	for(Serviciu p : this.servicii) {
      if(p.getId() == id) {
		  p.setId(7);
		  p.setName("Inginer");
		  p.setSalariu(2000);
		return new ResponseEntity<Serviciu>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
  @RequestMapping(value="/serviciu/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Serviciu p : this.servicii) {
      if(p.getId() == id) {
        return new ResponseEntity<Serviciu>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
  @RequestMapping(value="/serviciu/{id}", method = RequestMethod.DEL)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Serviciu p : this.servicii) {
      if(p.getId() == id) {
        this.servicii.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
