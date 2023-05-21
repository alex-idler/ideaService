package ylab.bies.ideaservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * DTO для получения информации об идее
 */
@Getter
@Setter
public class IdeaRequestDto {
    private Long id;
    private UUID userId;
    private String name;
    private String text;
}
