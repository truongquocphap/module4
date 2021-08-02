package smart_phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import smart_phone.model.entity.Smartphone;
import smart_phone.model.repository.ISmartphoneRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SmartphoneRestController {
    @Autowired
    private ISmartphoneRepository smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Smartphone>> getAllSmartphonePage() {
        List<Smartphone> smartphones=smartphoneService.findAll();
        return new ResponseEntity<>(smartphones,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.deleteById(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Smartphone> updateSmartphone(@PathVariable Long id,@RequestBody Smartphone smartphone) {
        Smartphone smartphone1=smartphoneService.findById(id).orElse(null);
        if (smartphone==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
        }
    }
    @GetMapping("/smartphone/{id}")
    public ResponseEntity<Smartphone>  getSmartphone(@PathVariable("id") Long id) {
       Smartphone smartphone=smartphoneService.findById(id).orElse(null);
       if (smartphone==null){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }else {
           return new ResponseEntity<>(smartphone,HttpStatus.OK);
       }
    }
}
