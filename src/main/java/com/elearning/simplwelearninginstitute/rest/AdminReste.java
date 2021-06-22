package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Parcour;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import com.elearning.simplwelearninginstitute.service.ParcourService;
import com.elearning.simplwelearninginstitute.vo.converter.InstituteConverter;
import com.elearning.simplwelearninginstitute.vo.converter.ParcourConverter;
import com.elearning.simplwelearninginstitute.vo.intern.ParcourVo;
import com.elearning.simplwelearninginstitute.vo.intern.institute.InstituteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Api2/institute")
public class AdminReste {
    @Autowired
    private InstituteService instituteService;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ParcourService parcourService;


    @PostMapping("/")
    public int save(@RequestBody InstituteVo instituteVo) {
        InstituteConverter instituteConverter = new InstituteConverter();
        Institute institute = instituteConverter.toItem(instituteVo);
        institute.setPassword(encoder.encode(institute.getPassword()));
        return instituteService.save(institute);
    }
    @GetMapping("/")
    public List<InstituteVo> findAll() {
        List<Institute> institutes=instituteService.findAll();
        InstituteConverter instituteConverter = new InstituteConverter();
        return instituteConverter.toVo(institutes);
    }

    @GetMapping("/{id}")
    public InstituteVo findById(@PathVariable Long id)
    {
        InstituteConverter instituteConverter = new InstituteConverter();
        Institute institute= instituteService.findById(id);
        return instituteConverter.toVo(institute);

    }


    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return instituteService.delete(id);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody InstituteVo instituteVo,@PathVariable Long id) {
        InstituteConverter instituteConverter = new InstituteConverter();
        Institute institute = instituteConverter.toItem(instituteVo);
        return instituteService.update(institute, id);
    }

    @GetMapping("/instituteId/{instituteId}")
    public List<ParcourVo> findByInstitute(@PathVariable Long instituteId) {
        ParcourConverter parcourConverter = new ParcourConverter();
        List<Parcour> parcours= parcourService.findByInstitute(instituteId);
        return parcourConverter.toVo(parcours);
    }

    @PostMapping("/saveParcour/instituteId/{instituteId}")
    public int save(@RequestBody ParcourVo parcourVo, @PathVariable Long instituteId) {
        ParcourConverter parcourConverter = new ParcourConverter();
        Parcour parcour = parcourConverter.toItem(parcourVo);
        return parcourService.save(parcour, instituteId);
    }

}
