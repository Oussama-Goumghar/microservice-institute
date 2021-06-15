package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.EtudiantRequest;
import com.elearning.simplwelearninginstitute.entities.ProfRequeste;
import com.elearning.simplwelearninginstitute.service.EtudiantRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Api/etudiantRequest")
public class EtudiantRequestRest {
    @Autowired
    EtudiantRequestService etudiantRequestService;

    @PostMapping("/instituteId/{instituteId}")
    public int save(@RequestBody EtudiantRequest etudiantRequest, @PathVariable Long instituteId) {
        return etudiantRequestService.save(etudiantRequest, instituteId);
    }

    @GetMapping("/")
    public List<EtudiantRequest> findAll() {
        return etudiantRequestService.findAll();
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return etudiantRequestService.delete(id);
    }

    @PutMapping("/approve/{id}")
    public int update( @PathVariable Long id) {
        return etudiantRequestService.aprouveRequest(id);
    }

    @GetMapping("/approved/")
    public List<EtudiantRequest> findRequestApproved() {
        return etudiantRequestService.findEtudiantRequesteApproved();
    }

    @GetMapping("/saveApproved/{id}")
    public int saveEtudiantAapproved(@PathVariable Long id) {
        return etudiantRequestService.saveEtudianteApproved(id);
    }

}
