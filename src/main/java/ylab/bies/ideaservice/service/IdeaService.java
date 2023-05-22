package ylab.bies.ideaservice.service;

import ylab.bies.ideaservice.dto.response.IdeaResponseDto;
import ylab.bies.ideaservice.exception.IdeaNotFoundException;

public interface IdeaService {
    IdeaResponseDto findById(String authHeader, Long id) throws IdeaNotFoundException;
}
