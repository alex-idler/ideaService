package ylab.bies.ideaservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ylab.bies.ideaservice.mapper.IdeaMapper;
import ylab.bies.ideaservice.repository.IdeaRepository;
import ylab.bies.ideaservice.service.IdeaService;

@Slf4j
@Service
public class IdeaServiceImpl implements IdeaService {
    private final IdeaRepository ideaRepository;
    private final IdeaMapper ideaMapper = Mappers.getMapper(IdeaMapper.class);

    @Autowired
    public IdeaServiceImpl(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

}
