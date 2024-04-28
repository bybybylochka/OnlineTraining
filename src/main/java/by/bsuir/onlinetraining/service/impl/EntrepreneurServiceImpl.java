package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.EntrepreneurMapper;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.repositories.EntrepreneurRepository;
import by.bsuir.onlinetraining.request.EntrepreneurEditRequest;
import by.bsuir.onlinetraining.response.EntrepreneurResponse;
import by.bsuir.onlinetraining.response.list.EntrepreneurListResponse;
import by.bsuir.onlinetraining.service.EntrepreneurService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public EntrepreneurResponse getAuthenticatedEntrepreneur() {
        Entrepreneur entrepreneur = doGetAuthenticatedEntrepreneur();

        return entrepreneurMapper.mapToEntrepreneurResponse(entrepreneur);
    }

    @Override
    public EntrepreneurResponse editEntrepreneur(EntrepreneurEditRequest request) {
        Entrepreneur entrepreneur = doGetAuthenticatedEntrepreneur();
        entrepreneurMapper.updateEntrepreneur(request, entrepreneur);
        Entrepreneur savedEntrepreneur = entrepreneurRepository.save(entrepreneur);

        return entrepreneurMapper.mapToEntrepreneurResponse(savedEntrepreneur);
    }

    @Override
    public EntrepreneurListResponse findAllEntrepreneurs() {
        return new EntrepreneurListResponse(entrepreneurRepository.findAll()
                .stream()
                .map(entrepreneurMapper::mapToEntrepreneurResponse)
                .toList());
    }

    public Entrepreneur doGetAuthenticatedEntrepreneur() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        return entrepreneurRepository.findByUsername(username)
                .orElseThrow();
    }
}
