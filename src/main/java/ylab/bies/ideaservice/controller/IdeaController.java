package ylab.bies.ideaservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ylab.bies.ideaservice.mapper.IdeaMapper;
import ylab.bies.ideaservice.service.IdeaService;
import ylab.bies.ideaservice.util.Decoder;

@Slf4j
@Tag(name = "Idea Controller", description = "REST operations with ideas")
@RestController
@RequestMapping(value = "/api/v1/ideas", produces = MediaType.APPLICATION_JSON_VALUE)
public class IdeaController {
    private final IdeaService ideaService;
    private final IdeaMapper ideaMapper = Mappers.getMapper(IdeaMapper.class);
    private final Decoder decoder;

    @Autowired
    public IdeaController(IdeaService ideaService, Decoder decoder) {
        this.ideaService = ideaService;
        this.decoder = decoder;
    }

}
