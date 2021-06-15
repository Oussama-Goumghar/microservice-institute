package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Parcour;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.service.ParcourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Api/parcour")
public class ParcourRest {

    @Autowired
    ParcourService parcourService;

    @PostMapping("/instituteId/{instituteId}")
    public int save(@RequestBody Parcour parcour, @PathVariable Long instituteId) {
        return parcourService.save(parcour, instituteId);
    }

    @GetMapping("/")
    public List<Parcour> findAll() {
        return parcourService.findAll();
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return parcourService.delete(id);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody Parcour parcour, @PathVariable Long id) {
        return parcourService.update(parcour, id);
    }
}
