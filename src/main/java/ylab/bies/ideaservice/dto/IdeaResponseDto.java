package ylab.bies.ideaservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * DTO для отправки информации об идее
 */
@Data
@NoArgsConstructor
public class IdeaResponseDto {
    private Long id;
    private UUID userId;
    private String name;
    private String text;
    private Long statusId;
    private Integer rating;
    private Boolean userLike;
    private Boolean userDislike;
}
