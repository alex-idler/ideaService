package ylab.bies.ideaservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdeaDto {

    private Long id;
    private String userId;
    private String name;
    private String text;
    private Long statusId;
    private Integer rating;

}
