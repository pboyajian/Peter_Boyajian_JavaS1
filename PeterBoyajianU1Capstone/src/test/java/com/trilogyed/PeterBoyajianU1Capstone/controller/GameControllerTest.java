package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.PeterBoyajianU1Capstone.model.Game;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public
class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServiceLayer serviceLayer;
    private JacksonTester<Game> gameJacksonTester;
    private JacksonTester<List<Game>> gameListJacksonTester;
    private Game game;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());
        game=new Game();
        game.setPrice(BigDecimal.valueOf(7.77));
        game.setDescription("default description");
        game.setEsrbRating("bad");
        game.setStudio("Studio 1");
        game.setTitle("gameName");
        game.setQuantity(6);
    }
    @Test
    public void shouldGetAllGames() throws Exception {
        game.setId(1);
        given(serviceLayer.getAllGames())
                .willReturn(new ArrayList<Game>(){
                    {add(game);}});

        MockHttpServletResponse response = mockMvc.perform(
                get("/game")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<Game> games =new ArrayList<Game>(){
            {add(game);}};

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(gameListJacksonTester.write(games).getJson());
    }
    @Test
    public void shouldGetGameById() throws Exception{
        game.setId(1);
        given(serviceLayer.getGame(1))
                .willReturn(game);

        MockHttpServletResponse response = mockMvc.perform(
                get("/game/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                gameJacksonTester.write(game).getJson());
    }
    @Test
    public void shouldCreateUpdateAndDeleteGame() throws Exception {
        Game gameAdded = game;
        gameAdded.setId(1);

        given(serviceLayer.addGame(game)).willReturn(gameAdded);
        MockHttpServletResponse createResponse = mockMvc.perform(
                post("/game")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJacksonTester
                                .write(game)
                                .getJson()))
                .andReturn().getResponse();
        assertThat(createResponse.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(createResponse.getContentAsString()).isEqualTo(gameJacksonTester.write(gameAdded).getJson());

        Game game2=game;
        game2.setTitle("new title");
        MockHttpServletResponse updateResponse = mockMvc.perform(
                put("/game")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJacksonTester
                                .write(game2)
                                .getJson()))
                .andReturn().getResponse();

        assertThat(updateResponse.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());

        MockHttpServletResponse deleteResponse = mockMvc.perform(
                delete("/game/1"))
                .andReturn().getResponse();

        assertThat(deleteResponse.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }
    @Test
    public void shouldGetAllGamesByGroups() throws Exception {
        game.setId(1);
        List<Game> games=new ArrayList<Game>();
        games.add(game);
        given(serviceLayer.getAllGamesByRating("bad")).willReturn(games);
        given(serviceLayer.getAllGamesByStudio("Studio 1")).willReturn(games);
        given(serviceLayer.getAllGamesByTitle("game")).willReturn(games);

        MockHttpServletResponse response = mockMvc.perform(
                get("/game/studio/Studio 1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(gameListJacksonTester.write(games).getJson());

         response = mockMvc.perform(
                get("/game/title/game")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(gameListJacksonTester.write(games).getJson());
         response = mockMvc.perform(
                get("/game/rating/bad")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(gameListJacksonTester.write(games).getJson());
    }
    @Test
    public void shouldReturn422WhenInvalidInput() throws Exception {

        MockHttpServletResponse addEmptyStringResponse = mockMvc.perform(
                post("/game").contentType(MediaType.APPLICATION_JSON)
                        .content(gameJacksonTester.write(new Game()).getJson())
        ).andReturn().getResponse();

        assertThat(addEmptyStringResponse.getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());

        MockHttpServletResponse addNullResponse = mockMvc.perform(
                post("/game").contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertThat(addNullResponse.getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}