package com.elearning.simplwelearninginstitute.service;

import com.elearning.simplwelearninginstitute.entities.ProfRequeste;

import java.util.List;

public interface ProfRequesteService {

    int save(ProfRequeste profRequeste, Long instituteId, Long parcourId);

    int delete(Long id);

    int update(ProfRequeste profRequeste, Long id);

    int aprouveRequest(Long id);

    List<ProfRequeste> findAll();

    ProfRequeste findById(Long id);

    List<ProfRequeste> findProfRequestApproved();

    List<ProfRequeste> findProfRequestByInstitute(Long id);

    ProfRequeste findProfRequestApprovedById(Long id);

    int saveProfAapproved(Long id);
}
