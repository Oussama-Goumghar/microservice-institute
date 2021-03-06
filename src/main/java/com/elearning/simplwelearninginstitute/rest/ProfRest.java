package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.security.services.UserDetailsImpl;
import com.elearning.simplwelearninginstitute.service.ProfService;
import com.elearning.simplwelearninginstitute.vo.converter.InstituteConverter;
import com.elearning.simplwelearninginstitute.vo.converter.ProfConverter;
import com.elearning.simplwelearninginstitute.vo.intern.ProfVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Api/prof")
public class ProfRest {
    @Autowired
    private ProfService profService;

    @PostMapping("/instituteId/{instituteId}/parcourId/{parcourId}")
    public int save(@RequestBody ProfVo profVo, @PathVariable Long instituteId, @PathVariable Long parcourId) {
        ProfConverter profConverter = new ProfConverter();
        Prof prof = profConverter.toItem(profVo);
        return profService.save(prof, instituteId,parcourId);
    }

    @GetMapping("/")
    public List<Prof> findAll() {
        return profService.findAll();
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return profService.delete(id);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody ProfVo profVo, @PathVariable Long id) {
        ProfConverter profConverter = new ProfConverter();
        Prof prof = profConverter.toItem(profVo);
        return profService.update(prof, id);
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication auth) {
        ProfConverter profConverter = new ProfConverter();
        UserDetailsImpl user = (UserDetailsImpl)auth.getPrincipal();
        return ResponseEntity.ok(profConverter.toVo(profService.findById(user.getUser().getId())));
    }
}
