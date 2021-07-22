package com.example.clientesoap.soap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for SoapClient service.
 */
@SpringBootTest
class SoapClientTest {

    @Autowired
    private SoapClient soapClient;

    /**
     * Test that perform the transformation of value to words.
     */
    @Test
    void convertNumberToWordOk() {
        Assertions.assertEquals("one thousand", soapClient.convertNumberToWord("1000"));
    }
}