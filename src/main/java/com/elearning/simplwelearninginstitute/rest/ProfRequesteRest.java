package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.ProfRequeste;
import com.elearning.simplwelearninginstitute.service.ProfRequesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Api/profRequest")
public class ProfRequesteRest {

    @Autowired
    ProfRequesteService profRequesteService;

    @PostMapping("/instituteId/{instituteId}")
    public int save(@RequestBody ProfRequeste profRequeste, @PathVariable Long instituteId) {
        return profRequesteService.save(profRequeste, instituteId);
    }

    @GetMapping("/")
    public List<ProfRequeste> findAll() {
        return profRequesteService.findAll();
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return profRequesteService.delete(id);
    }

    @PutMapping("/approve/{id}")
    public int update( @PathVariable Long id) {
        return profRequesteService.aprouveRequest(id);
    }


    @GetMapping("/approved/")
    public List<ProfRequeste> findRequestApproved() {
        return profRequesteService.findProfRequestApproved();
    }

    @GetMapping("/approved/id/{id}")
    public ProfRequeste findRequestApproved(@PathVariable Long id) {
        return profRequesteService.findProfRequestApprovedById(id);
    }

    @GetMapping("/saveApproved/{id}")
    public int saveProfAapproved(@PathVariable Long id) {
        return profRequesteService.saveProfAapproved(id);
    }
}