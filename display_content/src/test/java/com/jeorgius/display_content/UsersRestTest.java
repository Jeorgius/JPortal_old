package com.jeorgius.display_content;


import com.jeorgius.cfg.Configuration.DatabaseConfiguration;
import com.jeorgius.cfg.Entities.Users.User;
import com.jeorgius.cfg.Entities.Users.UserFull;
import com.jeorgius.cfg.Entities.Users.UserPrivate;
import com.jeorgius.cfg.Repos.UserRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DisplayContentApplication.class)
@ComponentScan(basePackages = "com.jeorgius.cfg")
@ComponentScan(basePackages = "com.jeorgius.display_content")
@WebAppConfiguration
@Import(DatabaseConfiguration.class)
public class UsersRestTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserRepo userRepo;

    private MockMvc mockMvc;
    private Long user_id;


    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        User user = new User();
        UserFull uf = new UserFull();
        UserPrivate up = new UserPrivate();

        user.setName("Georgii");
        user.setSurname("Zykov");
        user.setNickname("Jeorgius");
        user.setAvatar_path("1.jpg");

        uf.setDescription("I am admin of this website. Testing configuration engaged");
        up.setEmail("V0tum-Separatum@yandex.ru");
        up.setPw("mypw");

        user.setUserFull(uf);
        user.setUserPrivate(up);
        up.setUser(user);
        uf.setUser(user);

        userRepo.save(user);

        this.user_id = userRepo.findFirstByOrderByIdDesc().getId();
    }

    @After
    public void tearDown() {
        userRepo.delete(userRepo.findFirstByOrderByIdDesc());
    }

    @Test
    public void usersRestTest() throws Exception {
        mockMvc.perform(put("/users/" + user_id))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json; charset=UTF-8"))
                .andExpect(jsonPath("$.nickname").value("Jeorgius"))
                .andExpect(jsonPath("$.avatar_path").value("1.jpg"));

        mockMvc.perform(put("/users/" + 0))
                .andDo(MockMvcResultHandlers.print());
    }

}
