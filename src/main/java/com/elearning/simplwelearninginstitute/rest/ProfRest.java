package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Api/prof")
public class ProfRest {
    @Autowired
    private ProfService profService;

    @PostMapping("/instituteId/{instituteId}")
    public int save(@RequestBody  Prof prof, @PathVariable Long instituteId) {
        return profService.save(prof, instituteId);
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
    public int update(@RequestBody Prof prof, @PathVariable Long id) {
        return profService.update(prof, id);
    }
}
