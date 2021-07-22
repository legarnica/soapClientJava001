package com.example.clientesoap.soap;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import webservicesserver.NumberToWords;
import webservicesserver.NumberToWordsResponse;

import java.math.BigInteger;

/**
 * Service class to consume NumberConversion Soap WS.
 */
@Service
@Component("NumberConversion")
public class SoapClient extends WebServiceGatewaySupport {

    /**
     * Web address to connect soap web service.
     */
    private String endpoint = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?wsdl";

    /**
     * Method that transform a number to the literal representation
     * of the number given.
     *
     * @param number number to transform
     * @return literal representation of the number.
     */
    public String convertNumberToWord(String number) {
        BigInteger bigNum = new BigInteger(number);
        NumberToWords request = new NumberToWords();
        request.setUbiNum(bigNum);
        NumberToWordsResponse response = null;

        try {
            response = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
        }catch (Exception e) {
            throw new RuntimeException("convertNumberToWord fails");
        }

        if(response == null) {
            throw new RuntimeException("convertNumberToWord fails");
        }

        return response.getNumberToWordsResult();
    }

}
