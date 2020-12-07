package org.autoservice.controller;

import org.autoservice.service.api.MasterService;
import org.autoservice.service.dto.MasterDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/master")
public class MasterController {
    @Autowired
    private MasterService masterService;

    @RequestMapping(value = "/free", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<MasterDto>> free() {
        List<MasterDto> masters = masterService.getFreeMasters();

        return ResponseEntity.ok().body(masters);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<MasterDto>> list() {
        List<MasterDto> masters = masterService.list();

        return ResponseEntity.ok().body(masters);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody MasterDto masterDto) throws ValidatorException {
        masterService.saveOrUpdate(masterDto);

        return ResponseEntity.ok().body("New master added");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        masterService.delete(id);

        return ResponseEntity.ok().body("Master was deleted");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody MasterDto masterDto) throws ValidatorException {
        masterDto.setId(id);
        masterService.saveOrUpdate(masterDto);

        return ResponseEntity.ok().body("Master was updated");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<MasterDto> get(@PathVariable("id") long id) {
        MasterDto masterDto = masterService.get(id);

        return ResponseEntity.ok().body(masterDto);
    }
}
