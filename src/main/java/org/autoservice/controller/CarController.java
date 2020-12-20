package org.autoservice.controller;

import org.autoservice.service.api.CarService;
import org.autoservice.service.dto.CarDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/", headers = "Accept=application/json")
    public ResponseEntity<List<CarDto>> list() {
        List<CarDto> cars = carService.list();

        return ResponseEntity.ok().body(cars);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> save(@RequestBody CarDto carDto) throws ValidatorException {
        carService.saveOrUpdate(carDto);

        return ResponseEntity.ok().body("New Car added");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        carService.delete(id);

        return ResponseEntity.ok().body("Car was deleted");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody CarDto carDto) throws ValidatorException {
        carDto.setId(id);
        carService.saveOrUpdate(carDto);

        return ResponseEntity.ok().body("Car was updated");
    }

    @GetMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<CarDto> get(@PathVariable("id") long id) {
        CarDto carDto = carService.get(id);

        return ResponseEntity.ok().body(carDto);
    }

    @GetMapping(value = "/warranty", headers = "Accept=application/json")
    public ResponseEntity<List<CarDto>> getCarsWithWarranty() {
        List<CarDto> cars = carService.getCarsWithWarranty();

        return ResponseEntity.ok().body(cars);
    }

    @GetMapping(value = "/status", headers = "Accept=application/json")
    public ResponseEntity<CarDto> getCarByNumber(@RequestParam(name = "number") String number) {
        CarDto car = carService.getCarByNumber(number);

        return ResponseEntity.ok().body(car);
    }

    @GetMapping(value = "/status/{id}", headers = "Accept=application/json")
    public ResponseEntity<List<CarDto>> getCarsByStatus(@PathVariable("id") long id) {
        List<CarDto> cars = carService.getCarsByStatusId(id);

        return ResponseEntity.ok().body(cars);
    }
}
