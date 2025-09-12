package ar.edu.utn.frc.tup.piii.ba.services.impl;

import ar.edu.utn.frc.tup.piii.ba.models.DummyModel;
import ar.edu.utn.frc.tup.piii.ba.repositories.DummyRepository;
import ar.edu.utn.frc.tup.piii.ba.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    @Override
    public List<DummyModel> getDummys() {
        return List.of();
    }

    @Override
    public DummyModel getDummyByID(Long id) {
        return null;
    }

    @Override
    public DummyModel createDummy(DummyModel dummyModel) {
        return null;
    }

    @Override
    public DummyModel updateDummy(DummyModel dummyModel) {
        return null;
    }

    @Override
    public void deleteDummy(DummyModel dummyModel) {

    }
}
