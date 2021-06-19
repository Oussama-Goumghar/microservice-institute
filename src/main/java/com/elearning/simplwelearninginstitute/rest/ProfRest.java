package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.service.ProfService;
import com.elearning.simplwelearninginstitute.vo.converter.ProfConverter;
import com.elearning.simplwelearninginstitute.vo.intern.ProfVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
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
}
