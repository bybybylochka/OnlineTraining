package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.EntrepreneurEditRequest;
import by.bsuir.onlinetraining.response.EntrepreneurResponse;
import by.bsuir.onlinetraining.response.list.EntrepreneurListResponse;
import by.bsuir.onlinetraining.service.EntrepreneurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entrepreneurs")
public class EntrepreneurController {

    private final EntrepreneurService entrepreneurService;

    @GetMapping
    public EntrepreneurListResponse findAllEntrepreneurs() {
        return entrepreneurService.findAllEntrepreneurs();
    }

    @GetMapping("/data")
    public EntrepreneurResponse getAuthenticatedEntrepreneur() {return entrepreneurService.getAuthenticatedEntrepreneur(); }

    @PutMapping
    public EntrepreneurResponse editEntrepreneur(@RequestBody EntrepreneurEditRequest request) {
        return entrepreneurService.editEntrepreneur(request);
    }
}
