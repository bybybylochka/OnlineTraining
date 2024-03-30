package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.EntrepreneurMapper;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.repositories.EntrepreneurRepository;
import by.bsuir.onlinetraining.response.list.EntrepreneurListResponse;
import by.bsuir.onlinetraining.service.EntrepreneurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntrepreneurServiceImpl implements EntrepreneurService {
    private final EntrepreneurRepository entrepreneurRepository;
    private final EntrepreneurMapper entrepreneurMapper;

    @Override
    public Entrepreneur findEntrepreneurEntityById(Long entrepreneurId) {
        return entrepreneurRepository.findById(entrepreneurId)
                .orElseThrow(() -> new EntityNotFoundException(entrepreneurId, Entrepreneur.class));
    }

    @Override
    public EntrepreneurListResponse findAllEntrepreneurs() {
        return new EntrepreneurListResponse(entrepreneurRepository.findAll()
                .stream()
                .map(entrepreneurMapper::mapToEntrepreneurResponse)
                .toList());
    }
}
