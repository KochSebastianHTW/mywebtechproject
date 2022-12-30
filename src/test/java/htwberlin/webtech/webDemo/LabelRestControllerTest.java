package htwberlin.webtech.webDemo;

import htwberlin.webtech.service.LabelService;
import htwberlin.webtech.webDemo.api.Label;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LabelRestController.class)
public class LabelRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LabelService labelService;

    @Test
    @DisplayName("should return found labels form label service")
    void returnFoundLabelsFromLabelService() throws Exception {
        // given
        var labels = List.of(
                new Label(1, "Sollte gemacht werden", "#EED202"),
                new Label(2, "Priorisieren", "#FF0000")
        );
        when(labelService.findAll()).thenReturn(labels);

        // when
        mockMvc.perform(get("/api/v1/labels"))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Sollte gemacht werden"))
                .andExpect(jsonPath("$[0].color").value("#EED202"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Priorisieren"))
                .andExpect(jsonPath("$[1].color").value("#FF0000"));
    }

    @Test
    @DisplayName("should return 404 if label is not found")
    void return404IfLabelNotFound() throws Exception {
        // given
        when(labelService.findById(anyLong())).thenReturn(null);

        // when
        mockMvc.perform(get("/api/v1/labels/123"))
                //then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a label")
    void returnHttpStatus201AndLocationHeaderWhenCreatingLabel() throws Exception{
        // given
        String labelToCreateAsJson = "{\"name\": \"Priorisieren\", \"color\": \"#FF0000\"}";
        var label = new Label(10, null, null);
        when(labelService.create(any())).thenReturn(label);

        // when
        mockMvc.perform(
                post("/api/v1/labels")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(labelToCreateAsJson)
            )
            // then
            .andExpect(status().isCreated())
            .andExpect(header().exists("Location"))
            .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/labels/" + label.getId()))));
    }

    @Test
    @DisplayName("should validate create label request")
    void validateCreateLabelRequest() throws Exception {
        // given
        String labelToCreateAsJson = "{\"name\": \"Priorisieren\", \"color\": \"FF0000\"}";

        // when
        mockMvc.perform(
                post("/api/v1/labels")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(labelToCreateAsJson)
            )
            // then
            .andExpect(status().isBadRequest());
    }
}
