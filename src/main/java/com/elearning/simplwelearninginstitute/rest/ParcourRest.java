package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Parcour;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.service.ParcourService;
import com.elearning.simplwelearninginstitute.vo.converter.ParcourConverter;
import com.elearning.simplwelearninginstitute.vo.intern.ParcourVo;
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
    public int save(@RequestBody ParcourVo parcourVo, @PathVariable Long instituteId) {
        ParcourConverter parcourConverter = new ParcourConverter();
        Parcour parcour = parcourConverter.toItem(parcourVo);
        return parcourService.save(parcour, instituteId);
    }

    @GetMapping("/")
    public List<ParcourVo> findAll() {
        ParcourConverter parcourConverter = new ParcourConverter();
        List<Parcour> parcours= parcourService.findAll();
        return parcourConverter.toVo(parcours);
    }

    @GetMapping("/instituteId/{instituteId}")
    public List<ParcourVo> findByInstitute( @PathVariable Long instituteId) {
        ParcourConverter parcourConverter = new ParcourConverter();
        List<Parcour> parcours= parcourService.findByInstitute(instituteId);
        return parcourConverter.toVo(parcours);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return parcourService.delete(id);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody ParcourVo parcourVo, @PathVariable Long id) {
        ParcourConverter parcourConverter = new ParcourConverter();
        Parcour parcour = parcourConverter.toItem(parcourVo);
        return parcourService.update(parcour, id);
    }
}
