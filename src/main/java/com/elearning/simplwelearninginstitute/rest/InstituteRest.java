package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import com.elearning.simplwelearninginstitute.vo.converter.InstituteConverter;
import com.elearning.simplwelearninginstitute.vo.intern.institute.InstituteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Api/institute")
public class InstituteRest {
    @Autowired
    private InstituteService instituteService;


    @PostMapping("/")
    public int save(@RequestBody InstituteVo instituteVo) {
        InstituteConverter instituteConverter = new InstituteConverter();
        Institute institute = instituteConverter.toItem(instituteVo);
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

}
