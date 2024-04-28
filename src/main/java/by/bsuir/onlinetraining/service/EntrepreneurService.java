package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.request.EntrepreneurEditRequest;
import by.bsuir.onlinetraining.response.EntrepreneurResponse;
import by.bsuir.onlinetraining.response.list.EntrepreneurListResponse;

public interface EntrepreneurService {
    Entrepreneur findEntrepreneurEntityById(Long entrepreneurId);

    EntrepreneurResponse getAuthenticatedEntrepreneur();

    Entrepreneur doGetAuthenticatedEntrepreneur();

    EntrepreneurResponse editEntrepreneur(EntrepreneurEditRequest request);

    EntrepreneurListResponse findAllEntrepreneurs();
}
