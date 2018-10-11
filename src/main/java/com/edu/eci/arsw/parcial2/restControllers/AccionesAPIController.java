package com.edu.eci.arsw.parcial2.restControllers;

import com.edu.eci.arsw.parcial2.services.HttpConnectionServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/acciones")
public class AccionesAPIController {

    @RequestMapping(method = RequestMethod.GET,path = "/diaria")
    public ResponseEntity<?> handlerGetResourceAcciones(){
        try {
            HttpConnectionServices hcs = new HttpConnectionServices();
            return new ResponseEntity<>(hcs.getAcciones(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(AccionesAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error, diaria",HttpStatus.NOT_FOUND);
        }
    }

}
