package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Api/etudiant")
public class EtudiantRest {
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/instituteId/{instituteId}/parcourId/{parcourId}")
    public int save(@RequestBody Etudiant etudiant , @PathVariable Long instituteId, @PathVariable Long parcourId) {
        return etudiantService.save(etudiant, instituteId,parcourId);
    }

    @GetMapping("/")
    public List<Etudiant> findAll() {
        return etudiantService.findAll();
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return etudiantService.delete(id);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody Etudiant etudiant, @PathVariable Long id) {
        return etudiantService.update(etudiant, id);
    }
}
