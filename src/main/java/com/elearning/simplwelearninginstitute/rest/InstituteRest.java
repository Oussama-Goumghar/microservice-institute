package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import com.elearning.simplwelearninginstitute.vo.converter.InstituteConverter;
import com.elearning.simplwelearninginstitute.vo.intern.InstituteVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Api/institute")
public class InstituteRest {
    @Autowired
    private InstituteService instituteService;


    @PostMapping("/")
    public int save(@RequestBody Institute institute) {
        return instituteService.save(institute);
    }

    @GetMapping("/")
    public List<InstituteVo> findAll() {
        List<Institute> institutes=instituteService.findAll();
        InstituteConverter instituteConverter = new InstituteConverter();
        return instituteConverter.toVo(institutes);
    }

    @GetMapping("/{id}")
    public Institute findById(@PathVariable Long id) {
        return instituteService.findById(id);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return instituteService.delete(id);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody Institute institute,@PathVariable Long id) {
        return instituteService.update(institute, id);
    }

}
