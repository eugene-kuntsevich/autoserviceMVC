package org.autoservice.controller;

import org.autoservice.service.api.MasterService;
import org.autoservice.service.dto.MasterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MasterController {
    @Autowired
    private MasterService masterService;

    @RequestMapping(value = "/masters/free", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<MasterDto>> free() {
        List<MasterDto> masters = masterService.getFreeMasters();

        return ResponseEntity.ok().body(masters);
    }

    @RequestMapping(value = "/masters", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<MasterDto>> list() {
        List<MasterDto> masters = masterService.list();

        return ResponseEntity.ok().body(masters);
    }

    @RequestMapping(value = "/master", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody MasterDto masterDto) {
        masterService.save(masterDto);

        return ResponseEntity.ok().body("New master added");
    }

    @RequestMapping(value = "/master/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        masterService.delete(id);

        return ResponseEntity.ok().body("Master was deleted");
    }

    @RequestMapping(value = "/master/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody MasterDto masterDto) {
        masterDto.setId(id);
        masterService.update(masterDto);

        return ResponseEntity.ok().body("Master was updated");
    }

    @RequestMapping(value = "/master/{id}", method = RequestMethod.GET)
    public ResponseEntity<MasterDto> get(@PathVariable("id") long id) {
        MasterDto masterDto = masterService.get(id);

        return ResponseEntity.ok().body(masterDto);
    }
}
