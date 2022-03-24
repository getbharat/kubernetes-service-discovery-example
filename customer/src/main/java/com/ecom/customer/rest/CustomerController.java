package com.ecom.customer.rest;

import com.ecom.customer.models.Customer;
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

    private static String BASE_URL = "http://order:8091/order" ;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment environment;

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
        final HttpEntity<Object> entity = new HttpEntity<>(headers);
        final Map<String, String> pathParams = new HashMap<>();
        pathParams.put("customerId", customerId);
        if(environment != null && environment.getProperty("order") != null){
            BASE_URL = environment.getProperty("order")+"/order";
        }
        final String url = UriComponentsBuilder.fromHttpUrl(BASE_URL).path("/get/{customerId}").buildAndExpand(pathParams).encode().toUriString();
        final ResponseEntity<Object[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object[].class);
        final Object[] objects = responseEntity.getBody();
        return objects ;
    }
}
