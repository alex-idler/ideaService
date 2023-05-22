package ylab.bies.ideaservice.controller;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ylab.bies.ideaservice.dto.response.IdeaResponseDto;
import ylab.bies.ideaservice.exception.IdeaNotFoundException;
import ylab.bies.ideaservice.service.IdeaService;

@RunWith(SpringRunner.class)
@SpringBootTest
class IdeaControllerTest {

    @Autowired
    private IdeaService ideaService;
    private String authHeader;

    @Before
    public void init() {
        authHeader = "test header";
    }

    @Test
    void findById() throws IdeaNotFoundException {
        IdeaResponseDto responseDto = ideaService.findById(authHeader, 1L);
        Assertions.assertEquals("a81bc81b-dead-4e5d-abff-90865d1e13b1", responseDto.getUserId());
        Assertions.assertEquals(1L, (long) responseDto.getId());
        Assertions.assertEquals("idea-1-name", responseDto.getName());
        Assertions.assertEquals("idea-1-text", responseDto.getText());
        Assertions.assertEquals(2, responseDto.getRating());
        Assertions.assertEquals(2, responseDto.getStatusId());
        Assertions.assertFalse(responseDto.getUserLike());
        Assertions.assertFalse(responseDto.getUserDislike());
    }

    @Test
    void ideaNotFoundException() {
        Assertions.assertThrows(IdeaNotFoundException.class,
                () -> ideaService.findById(authHeader, 0L));
    }
}