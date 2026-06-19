package com.keyin.devops_sdat_qap2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CdController.class)
public class CdControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CdService cdService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup()
    {
        Mockito.reset(cdService);
    }

    @Test
    void getAllCds_returnsList() throws Exception
    {
        List<Cd> cds = List.of(
            new Cd("Test album name", "test artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30)),
            new Cd("Test album name2", "test artist name2", "Test track listing2", "Test genre2", "Test label2", "Test producer2", LocalDate.of(2010, 12, 23))
        );

        Mockito.when(cdService.getAllCds()).thenReturn(cds);

        mockMvc.perform(get("/api/cd/getAllCds"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].albumName").value("Test album name"));
    }

    @Test
    void getCdById_returnsCd() throws Exception
    {
        Cd cd = new Cd("Test album name", "test artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));

        Mockito.when(cdService.getCdById(1L)).thenReturn(cd);

        mockMvc.perform(get("/api/cd/getCdById/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.albumName").value("Test album name"))
                .andExpect(jsonPath("$.artistName").value("test artist name"));
    }

    @Test
    void createCd_returnCreatedCd() throws Exception
    {
        Cd cd = new Cd("New test album name", "New test artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 1, 1));

        Mockito.when(cdService.saveCd(Mockito.any(Cd.class)))
                .thenReturn(cd);

        mockMvc.perform(post("/api/cd/add")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cd)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.albumName").value("New test album name"));
    }

    @Test
    void updateCd_returnsUpdatedCd() throws Exception
    {
        Cd cd = new Cd("Test updated album name", "test updated artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));

        Mockito.when(cdService.updateCd(Mockito.eq(1L), Mockito.any(Cd.class)))
                .thenReturn(cd);

        mockMvc.perform(put("/api/cd/update/1")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cd)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.albumName").value("Test updated album name"));
    }

    @Test
    void deleteCdById_returnsOk() throws Exception
    {
        Mockito.doNothing()
                .when(cdService)
                .deleteCdById(1L);

        mockMvc.perform(delete("/api/cd/delete/1"))
                .andExpect(status().isOk());
    }

}
