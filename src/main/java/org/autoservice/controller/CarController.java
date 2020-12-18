package org.autoservice.controller;

import org.autoservice.service.api.CarService;
import org.autoservice.service.api.OrderService;
import org.autoservice.service.dto.CarDto;
import org.autoservice.service.dto.OrderDto;
import org.autoservice.service.dto.OrderStatusDto;
import org.autoservice.service.exception.ValidatorException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<CarDto>> list() {
        List<CarDto> cars = carService.list();

        return ResponseEntity.ok().body(cars);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody CarDto carDto) throws ValidatorException {
        carService.saveOrUpdate(carDto);

        return ResponseEntity.ok().body("New Car added");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        carService.delete(id);

        return ResponseEntity.ok().body("Car was deleted");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody CarDto carDto) throws ValidatorException {
        carDto.setId(id);
        carService.saveOrUpdate(carDto);

        return ResponseEntity.ok().body("Car was updated");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<CarDto> get(@PathVariable("id") long id) {
        CarDto carDto = carService.get(id);

        return ResponseEntity.ok().body(carDto);
    }

    @RequestMapping(value = "/warranty", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<CarDto>> getCarsWithWarranty() {
        List<CarDto> cars = carService.getCarsWithWarranty();

        return ResponseEntity.ok().body(cars);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<String> getCarWithStatus(@RequestParam(name = "number") String number) {
        CarDto car = carService.getCarByNumber(number);
        List<OrderDto> orders = orderService.getOrdersByCarId(car.getId());
        OrderStatusDto status = orders.get(orders.size() - 1).getStatus();

        //Kinda weird, i guess
        String response = new JSONObject()
                .put("id", car.getId())
                .put("carNumber", car.getCarNumber())
                .put("warrantyDate", car.getWarrantyDate())
                .put("status", new JSONObject()
                        .put("id", status.getId())
                        .put("name", status.getName())
                )
                .toString();

        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/status/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<CarDto>> getCarsWithStatus(@PathVariable("id") long id) {
        List<OrderDto> orders = orderService.getOrdersByStatusId(id);
        List<CarDto> cars = orders.stream().map(OrderDto::getCar).collect(Collectors.toList());

        return ResponseEntity.ok().body(cars);
    }
}
