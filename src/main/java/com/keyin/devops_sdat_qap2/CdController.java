package com.keyin.devops_sdat_qap2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cd")
public class CdController
{
    @Autowired
    CdService cdService;

    @PostMapping("/add")
    public Cd addCd(@RequestBody Cd cd)
    {
        return cdService.saveCd(cd);
    }

    @GetMapping("/getAllCds")
    public ResponseEntity<List<Cd>> getAllCds()
    {
        return ResponseEntity.ok(cdService.getAllCds());
    }

    @GetMapping("/getCdById/{id}")
    public ResponseEntity<Cd> getCdById(@PathVariable Long id)
    {
        return new ResponseEntity<>(cdService.getCdById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCdById(@PathVariable Long id)
    {
        cdService.deleteCdById(id);
        return new ResponseEntity<>("Cd with id " + id +" has been deleted", HttpStatus.OK);
    }

    @PostMapping("/seed")
    public ResponseEntity<List<Cd>> seedCds()
    {
        return new ResponseEntity<>(cdService.seedCds(), HttpStatus.CREATED);
    }
}
