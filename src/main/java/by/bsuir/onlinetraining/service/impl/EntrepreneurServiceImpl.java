package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.mapper.EntrepreneurMapper;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.repositories.EntrepreneurRepository;
import by.bsuir.onlinetraining.service.EntrepreneurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntrepreneurServiceImpl implements EntrepreneurService {
    private final EntrepreneurRepository entrepreneurRepository;
    private final EntrepreneurMapper entrepreneurMapper;
    @Override
    public Entrepreneur findEntrepreneurById(Long entrepreneurId) {
        return entrepreneurRepository.findById(entrepreneurId)
                .orElseThrow(()->new IllegalArgumentException("Entrepreneur was not fount by id!"));
    }
}
