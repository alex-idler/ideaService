package ylab.bies.ideaservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ylab.bies.ideaservice.dto.response.IdeaResponseDto;
import ylab.bies.ideaservice.exception.IdeaNotFoundException;
import ylab.bies.ideaservice.service.IdeaService;

@Slf4j
@Tag(name = "Idea Controller", description = "REST operations with ideas")
@RestController
@RequestMapping(value = "/api/v1/ideas", produces = MediaType.APPLICATION_JSON_VALUE)
public class IdeaController {
    private final IdeaService ideaService;

    @Autowired
    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @GetMapping("/{id}")
    @Operation(security = @SecurityRequirement(name = "Bearer Token"))
    public ResponseEntity<IdeaResponseDto> findById(@RequestHeader("Authorization") String authHeader,
                                                    @PathVariable Long id) {
        try {
            return ResponseEntity.ok(ideaService.findById(authHeader, id));
        } catch (IdeaNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
