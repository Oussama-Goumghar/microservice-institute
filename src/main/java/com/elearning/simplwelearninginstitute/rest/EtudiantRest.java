package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.security.services.UserDetailsImpl;
import com.elearning.simplwelearninginstitute.service.EtudiantService;
import com.elearning.simplwelearninginstitute.vo.converter.EtudiantConverter;
import com.elearning.simplwelearninginstitute.vo.converter.InstituteConverter;
import com.elearning.simplwelearninginstitute.vo.intern.EtudiantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Api/etudiant")
public class EtudiantRest {
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/instituteId/{instituteId}/parcourId/{parcourId}")
    public int save(@RequestBody EtudiantVo etudiantVo , @PathVariable Long instituteId, @PathVariable Long parcourId) {
        Etudiant etudiant = new EtudiantConverter().toItem(etudiantVo);
        return etudiantService.save(etudiant, instituteId,parcourId);
    }

    @GetMapping("/")
    public List<EtudiantVo> findAll() {
        EtudiantConverter etudiantConverter = new EtudiantConverter();
        List<Etudiant> etudiants= etudiantService.findAll();
        return etudiantConverter.toVo(etudiants);

    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication auth) {
        EtudiantConverter etudiantConverter = new EtudiantConverter();
        UserDetailsImpl user = (UserDetailsImpl)auth.getPrincipal();
        return ResponseEntity.ok(etudiantConverter.toVo(etudiantService.findById(user.getUser().getId())));
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return etudiantService.delete(id);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody EtudiantVo etudiantVo, @PathVariable Long id) {
        Etudiant etudiant = new EtudiantConverter().toItem(etudiantVo);
        return etudiantService.update(etudiant, id);
    }
}
