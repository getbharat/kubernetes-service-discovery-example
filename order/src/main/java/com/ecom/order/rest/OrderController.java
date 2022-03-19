package com.ecom.order.rest;

import com.ecom.order.model.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController("/order")
public class OrderController {

    @GetMapping(value = "/get/{customerId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE, MediaType.TEXT_XML_VALUE,MediaType.TEXT_PLAIN_VALUE, MediaType.TEXT_HTML_VALUE}, consumes = {"*/*"})
    public ResponseEntity<List<Order>> getOrderById(@PathVariable("customerId") String customerId) {
        final List<Order> orderList = new ArrayList<>();
        switch (customerId){
            case "C1":
            case "C3":
            case "C2":
                getOrder(customerId, orderList);
                break;
            default:
                break;
        }
        return ResponseEntity.ok(orderList);
    }

    private void getOrder(final String customerId, final List<Order> orderList) {
        orderList.add(new Order("O1","Generic Order For Laptops", getDatFormattedDate(new GregorianCalendar(2022,1, 31))));
    }

    private String getDatFormattedDate(final GregorianCalendar calendarDate) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US);
        final String dateString = simpleDateFormat.format(calendarDate.getTime());
        return dateString ;
    }
}
