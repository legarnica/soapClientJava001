package com.example.clientesoap.controller;

import com.example.clientesoap.soap.SoapClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller class to consume books soap webservice.
 */
@RestController
@RequestMapping("/soapclient")
public class NumbersSoapClientServiceController {
    /**
     * Logger of the class
     */
    private static final Logger log = LoggerFactory.getLogger(NumbersSoapClientServiceController.class);

    /**
     * References to SoapClient service.
     */
    private final SoapClient soapClient;

    /**
     * Constructor of the class.
     * @param soapClient
     */
    public NumbersSoapClientServiceController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    /**
     * web service to get books.
     *
     * @return List<Book>, the list of books.
     */
    @GetMapping(value = "/towords")
    public ResponseEntity<String> getWords(@RequestParam String number) {
        log.info("[towords - init] [number] [{}]", number);
        try {
            String response = soapClient.convertNumberToWord(number);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("[towords]", e);
            return new ResponseEntity<>("error de servicio", HttpStatus.BAD_REQUEST);
        }
    }
}
