package ylab.bies.ideaservice.mapper;

import org.mapstruct.Mapper;
import ylab.bies.ideaservice.dto.IdeaDraftDto;
import ylab.bies.ideaservice.dto.IdeaRequestDto;
import ylab.bies.ideaservice.dto.IdeaResponseDto;
import ylab.bies.ideaservice.entity.Idea;

@Mapper
public interface IdeaMapper {
    IdeaDraftDto ideaEntityToIdeaDraftDto(Idea idea);
    IdeaResponseDto ideaEntityToIdeaResponseDto(Idea idea);
    Idea requestDTOToIdeaEntity(IdeaRequestDto ideaRequestDTO);
}