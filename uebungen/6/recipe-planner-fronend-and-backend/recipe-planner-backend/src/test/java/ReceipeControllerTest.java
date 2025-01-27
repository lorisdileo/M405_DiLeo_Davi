import ch.tbz.recipe.planner.controller.RecipeController;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;  // Hinzugefügt

import java.util.Collections;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = {ch.tbz.recipe.planner.RecipePlannerApplication.class})
@AutoConfigureMockMvc  // Hinzugefügt, um MockMvc zu konfigurieren
@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;  // MockMvc wird nun automatisch injiziert

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RecipeService recipeService;

    @Test
    void getRecipes_shouldReturnListOfRecipes() throws Exception {
        when(recipeService.getRecipes()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void getRecipe_shouldReturnRecipeById() throws Exception {
        UUID recipeId = UUID.randomUUID();
        Recipe recipe = new Recipe();
        when(recipeService.getRecipeById(recipeId)).thenReturn(recipe);

        mockMvc.perform(get("/api/recipes/recipe/" + recipeId))
                .andExpect(status().isOk());
    }

    @Test
    void addRecipe_shouldReturnSavedRecipe() throws Exception {
        Recipe recipe = new Recipe();
        when(recipeService.addRecipe(recipe)).thenReturn(recipe);

        mockMvc.perform(post("/api/recipes")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recipe)))
                .andExpect(status().isOk());
    }
}
