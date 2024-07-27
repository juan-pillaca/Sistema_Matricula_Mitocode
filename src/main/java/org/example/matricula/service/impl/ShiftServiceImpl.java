package org.example.matricula.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.matricula.model.Shift;
import org.example.matricula.repo.IShiftRepo;
import org.example.matricula.repo.IGenericRepo;
import org.example.matricula.service.IShiftService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShiftServiceImpl extends CRUDImpl<Shift, Integer> implements IShiftService {

    private final IShiftRepo repo;

    @Override
    protected IGenericRepo<Shift, Integer> getRepo() { return repo;
    }
}
