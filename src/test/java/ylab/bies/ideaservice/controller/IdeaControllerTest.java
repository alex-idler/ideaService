package ylab.bies.ideaservice.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ylab.bies.ideaservice.entity.Idea;
import ylab.bies.ideaservice.service.impl.IdeaServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class IdeaControllerTest {

    @Autowired
    private IdeaServiceImpl ideaService;

}