package by.bsuir.onlinetraining.controllers;

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
}
