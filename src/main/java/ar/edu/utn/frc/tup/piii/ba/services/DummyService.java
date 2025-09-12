package ar.edu.utn.frc.tup.piii.ba.services;
import ar.edu.utn.frc.tup.piii.ba.models.DummyModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DummyService {
    List<DummyModel> getDummys();

    DummyModel getDummyByID(Long id);

    DummyModel createDummy(DummyModel dummyModel);

    DummyModel updateDummy(DummyModel dummyModel);

    void deleteDummy(DummyModel dummyModel);
}
