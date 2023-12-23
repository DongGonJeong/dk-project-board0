package com.dk.project_board0.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("view controller - 인증")
@WebMvcTest
public class AuthControllerTest {

    private final MockMvc mvc;

    public AuthControllerTest(@Autowired MockMvc mvc) {this.mvc = mvc;}

    @DisplayName("[view][GET] 로그인 page 정상 호출") // 여러 건
    @Test
    public void givenNothing_whenTryingToLogin_thenReturnsLoginView() throws Exception {


        mvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
//                .andExpect(view().name("articles/index"))
//                .andExpect(model().attributeExists("articles"));
    }

}
