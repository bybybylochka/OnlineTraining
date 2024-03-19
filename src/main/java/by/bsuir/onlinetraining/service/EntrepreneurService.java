package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.response.list.EntrepreneurListResponse;

public interface EntrepreneurService {
    Entrepreneur findEntrepreneurEntityById(Long entrepreneurId);

    EntrepreneurListResponse findAllEntrepreneurs();
}
