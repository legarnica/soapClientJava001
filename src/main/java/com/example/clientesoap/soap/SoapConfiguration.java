package com.example.clientesoap.soap;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

/**
 * Configuration class, sets the properties to services class.
 */
@Configuration
public class SoapConfiguration {

    /**
     * Literal representation of the context.
     */
    private final static String CONTEXT_PATH = "webservicesserver";

    /**
     * References to SoapClient service.
     */
    private final SoapClient client;

    /**
     * Constructor of the class
     * @param client {@link #client}
     */
    public SoapConfiguration(SoapClient client) {
        this.client = client;
    }

    /**
     * Set the context for the service.
     *
     * @return Jaxb2Marshaller.
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(CONTEXT_PATH);

        return marshaller;
    }

    /**
     * Method that configure and return  HttpComponentsMessageSender to performance the POST.
     *
     * @return HttpComponentsMessageSender object.
     */
    @Bean
    public HttpComponentsMessageSender getMessageSender() {
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
        messageSender.setCredentials(new UsernamePasswordCredentials("username", "password"));
        return messageSender;
    }

    /**
     * Set the client configuration, like endpoint url.
     *
     * @param marshaller Jaxb to marshaller.
     * @return configured client soap service.
     */
    @Bean
    public SoapClient soapClient(Jaxb2Marshaller marshaller) {
        client.setMessageSender(getMessageSender());
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
