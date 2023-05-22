package ylab.bies.ideaservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ylab.bies.ideaservice.dto.response.IdeaResponseDto;
import ylab.bies.ideaservice.entity.Idea;
import ylab.bies.ideaservice.mapper.IdeaMapper;
import ylab.bies.ideaservice.repository.IdeaRepository;
import ylab.bies.ideaservice.service.IdeaService;
import ylab.bies.ideaservice.service.VoteService;
import ylab.bies.ideaservice.util.Decoder;
import ylab.bies.ideaservice.exception.IdeaNotFoundException;

import java.util.UUID;

@Slf4j
@Service
public class IdeaServiceImpl implements IdeaService {
    private final VoteService voteService;
    private final IdeaRepository ideaRepository;
    private final Decoder decoder;
    private final IdeaMapper ideaMapper = Mappers.getMapper(IdeaMapper.class);

    @Autowired
    public IdeaServiceImpl(VoteService voteService, IdeaRepository ideaRepository, Decoder decoder) {
        this.voteService = voteService;
        this.ideaRepository = ideaRepository;
        this.decoder = decoder;
    }

    @Override
    public IdeaResponseDto findById(String authHeader, Long id) throws IdeaNotFoundException {
        UUID userId = decoder.getUuidFromHeader(authHeader);
        Idea idea = ideaRepository.findById(id).orElseThrow(() -> new IdeaNotFoundException(id));
        IdeaResponseDto responseDto = ideaMapper.ideaEntityToIdeaResponseDto(idea);

        Boolean vote = voteService.getVoteOfUser(id, userId);
        if (vote == null) {  // если не голосовал
            responseDto.setUserLike(false);
            responseDto.setUserDislike(false);
        } else {  // если голосовал, то выставляются лайк и дизлайк
            responseDto.setUserLike(vote);
            responseDto.setUserDislike(!vote);
        }

        return responseDto;
    }
}
