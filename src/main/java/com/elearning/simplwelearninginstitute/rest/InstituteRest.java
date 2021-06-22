package com.elearning.simplwelearninginstitute.rest;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.security.services.UserDetailsImpl;
import com.elearning.simplwelearninginstitute.service.EtudiantService;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import com.elearning.simplwelearninginstitute.service.ProfService;
import com.elearning.simplwelearninginstitute.vo.converter.EtudiantConverter;
import com.elearning.simplwelearninginstitute.vo.converter.InstituteConverter;
import com.elearning.simplwelearninginstitute.vo.converter.ProfConverter;
import com.elearning.simplwelearninginstitute.vo.intern.EtudiantVo;
import com.elearning.simplwelearninginstitute.vo.intern.ProfVo;
import com.elearning.simplwelearninginstitute.vo.intern.institute.InstituteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Api/institute")
public class InstituteRest {
    @Autowired
    private InstituteService instituteService;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private ProfService profService;
    @Autowired
    PasswordEncoder encoder;


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

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication auth) {
        InstituteConverter instituteConverter = new InstituteConverter();
        UserDetailsImpl user = (UserDetailsImpl)auth.getPrincipal();
        return ResponseEntity.ok(instituteConverter.toVo(instituteService.findById(user.getUser().getId())));
    }


    @GetMapping("/login/{login}/password/{password}")
    public InstituteVo findById(@PathVariable String login,@PathVariable String password)
    {
        InstituteConverter instituteConverter = new InstituteConverter();
        Institute institute = instituteService.login(login, password);
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

    @PostMapping("/saveEtudiant/instituteId/{instituteId}/parcourId/{parcourId}")
    public int save(@RequestBody EtudiantVo etudiantVo , @PathVariable Long instituteId, @PathVariable Long parcourId) {
        Etudiant etudiant = new EtudiantConverter().toItem(etudiantVo);
        etudiant.setPassword(encoder.encode(etudiant.getPassword()));
        return etudiantService.save(etudiant, instituteId,parcourId);
    }

    @PostMapping("/saveProf/instituteId/{instituteId}/parcourId/{parcourId}")
    public int save(@RequestBody ProfVo profVo, @PathVariable Long instituteId, @PathVariable Long parcourId) {
        ProfConverter profConverter = new ProfConverter();
        Prof prof = profConverter.toItem(profVo);
        prof.setPassword(encoder.encode(prof.getPassword()));
        return profService.save(prof, instituteId,parcourId);
    }

}
