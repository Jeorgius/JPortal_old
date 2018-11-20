package com.jeorgius.display_content;

import com.jeorgius.database.Configuration.DatabaseConfiguration;
import com.jeorgius.database.Entities.NewsItem;
import com.jeorgius.database.Entities.NewsItemFull;
import com.jeorgius.database.Repos.NewsRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DisplayContentApplication.class)
@WebAppConfiguration
@Import(DatabaseConfiguration.class)
public class NewsRestTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private NewsRepo newsRepo;

    private MockMvc mockMvc;
    private Long news_id;


    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        NewsItemFull nI = new NewsItemFull();
        nI.setFullText("Big text that breaks imagination. Maybe it's about Dr.Who fighting Macra or helping the mankind to succeed in this war");
        NewsItem newsItem = new NewsItem("testtitle", "Test short text for main screen", "1.jpg", nI);
        nI.setNewsItem(newsItem);
        newsRepo.save(newsItem);

        this.news_id = newsRepo.findFirstByOrderByIdDesc().getId();
    }

    @After
    public void tearDown() {
        newsRepo.delete(newsRepo.findFirstByOrderByIdDesc());
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void newsRestTest() throws Exception {
        mockMvc.perform(get("/news/" + news_id))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json; charset=UTF-8"))
                .andExpect(jsonPath("$.title").value("testtitle"))
                .andExpect(jsonPath("$.filename").value("1.jpg"));
        //String content = result.getResponse().getContentAsString();
        //System.out.println(content);
    }

}
