package com.ecom.customer.rest;

import com.ecom.customer.models.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@RestController
public class CustomerController {

    private static String BASE_URL = "http://localhost:8091/order" ;
    private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    public void setRestTemplate(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/get", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE, MediaType.TEXT_XML_VALUE,MediaType.TEXT_PLAIN_VALUE, MediaType.TEXT_HTML_VALUE}, consumes = {"*/*"} )
    @ResponseBody
    public List<Customer> getCustomers(){
        final List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("C1", "GE", "New York, US"));
        customerList.add(new Customer("C2", "Reynolds", "New York, US"));
        customerList.add(new Customer("C3", "Thomson Reuters", "Toronto, Canada"));

        return customerList;
    }

    @GetMapping(value = "/get/order/{customerId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE, MediaType.TEXT_XML_VALUE,MediaType.TEXT_PLAIN_VALUE, MediaType.TEXT_HTML_VALUE}, consumes = {"*/*"} )
    @ResponseBody
    public Object[] getOrderByCustomerId(@PathVariable("customerId") final String customerId){
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_XHTML_XML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN, MediaType.TEXT_HTML));
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Object> entity = new HttpEntity<>(headers);
        final Map<String, String> pathParams = new HashMap<>();
        pathParams.put("customerId", customerId);
        if (environment != null && environment.getProperty("ORDER_SERVICE") != null) {
            if (environment.getProperty("ORDER_SERVICE").equalsIgnoreCase("order")) {
                BASE_URL = "http://" + environment.getProperty("ORDER_SERVICE") + "/order";
            } else {
                BASE_URL = environment.getProperty("ORDER_SERVICE") + "/order";
            }
        }
        LOGGER.debug("Base Url is :" + BASE_URL);
        final String url = UriComponentsBuilder.fromHttpUrl(BASE_URL).path("/get/{customerId}").buildAndExpand(pathParams).encode().toUriString();
        final ResponseEntity<Object[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object[].class);
        final Object[] objects = responseEntity.getBody();
        return objects ;
    }
}
