package dev.intranet.exampleapp.controllers;

import dev.intranet.exampleapp.application.domain.Phone;
import dev.intranet.exampleapp.application.domain.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/phones")
public class PhonesController {

    @Autowired
    private PhoneRepository phoneRepository;

    public PhonesController() {

    }

    @PostConstruct
    private void feedPhones() {

        long countRegisteredPhones = phoneRepository.countPhones();

        if (phoneRepository.countPhones() == 0) {
            Phone p1 = new Phone("(11)9898-1234");
            Phone p2 = new Phone("(11)9898-4321");
            Phone p3 = new Phone("(21)1234-7654");
            Phone p4 = new Phone("(21)9899-8787");
            Phone p5 = new Phone("(81)6565-1234");
            Phone p6 = new Phone("(11)7378-8777");

            phoneRepository.save(p1);
            phoneRepository.save(p2);
            phoneRepository.save(p3);
            phoneRepository.save(p4);
            phoneRepository.save(p5);
            phoneRepository.save(p6);
        }

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> all(@RequestBody List<String> numbers){

        try {
            List<Phone> phones = phoneRepository.byNumbers(new HashSet<>(numbers));
            return ResponseEntity.ok().body(phones);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("There was an error searching the phones.");
        }

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody Phone phone) {
        try {
            return ResponseEntity.ok(phoneRepository.save(phone));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("There was an error saving the phone.");
        }
    }

}
