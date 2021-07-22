package com.example.clientesoap.soap;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Component;

@SpringBootTest
class SoapClientTest {

    @Autowired
    SoapClient soapClient;

    /**
     * Test that perform the transformation of value to words.
     */
    @Test
    void convertNumberToWordOk() {
        Assertions.assertEquals("one thousand", soapClient.convertNumberToWord("1000"));
    }
}
