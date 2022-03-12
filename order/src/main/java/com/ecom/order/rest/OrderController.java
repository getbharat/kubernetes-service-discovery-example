package com.ecom.order.rest;

import com.ecom.order.model.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController("/order")
public class OrderController {

    @GetMapping(value = "/get/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getOrderById(@PathVariable("orderId") String orderId) {
        final List<Order> orderList = new ArrayList<>();
        switch (orderId){
            case "C1":
            case "C3":
            case "C2":
                getOrder(orderId, orderList);
                break;
            default:
                break;

        }

        return ResponseEntity.ok(orderList);

    }

    private void getOrder(final String orderId, final List<Order> orderList) {

        orderList.add(new Order("O1","Generic Order For Laptops", getDatFormattedDate(LocalDate.of(2022, 02, 12))));
    }

    private String getDatFormattedDate(final LocalDate date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
        final String dateString = simpleDateFormat.format(date);
        return dateString ;
    }
}
