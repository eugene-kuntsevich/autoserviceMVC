package org.autoservice.controller;

import org.autoservice.service.api.CarService;
import org.autoservice.service.api.OrderService;
import org.autoservice.service.dto.OrderDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CarService carService;

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody OrderDto orderDto) throws ValidatorException {
        OrderDto order = orderService.get(id);
        if (orderDto.getStatus().getId() == 5 && order.getStatus().getId() == 4) {
            carService.setWarranty(order.getCar().getId());
        }

        orderDto.setId(id);
        orderService.saveOrUpdate(orderDto);

        return ResponseEntity.ok().body("Order was updated");
    }
}
