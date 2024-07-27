package org.example.matricula.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.matricula.model.Career;
import org.example.matricula.repo.ICareerRepo;
import org.example.matricula.repo.IGenericRepo;
import org.example.matricula.service.ICareerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CareerServiceImpl extends CRUDImpl<Career, Integer> implements ICareerService {

    private final ICareerRepo repo;

    @Override
    protected IGenericRepo<Career, Integer> getRepo() { return repo;
    }
}
