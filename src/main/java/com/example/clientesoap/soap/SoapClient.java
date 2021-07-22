package com.example.clientesoap.soap;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import webservicesserver.NumberToWords;
import webservicesserver.NumberToWordsResponse;

import java.math.BigInteger;

@Service
@Component("NumberConversion")
public class SoapClient extends WebServiceGatewaySupport {

    private String endpoint = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?wsdl";

    public String convertNumberToWord(String number) {
        BigInteger bigNum = new BigInteger(number);

        NumberToWords request = new NumberToWords();
        request.setUbiNum(bigNum);
        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint,
                request);
        return response.getNumberToWordsResult();
    }

}
