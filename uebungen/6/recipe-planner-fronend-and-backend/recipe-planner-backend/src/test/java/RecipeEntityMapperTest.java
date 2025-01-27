import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeEntityMapperTest {

    private RecipeEntityMapper recipeEntityMapper;

    @BeforeEach
    void setUp() {
        // Mapper-Instanz erstellen
        recipeEntityMapper = Mappers.getMapper(RecipeEntityMapper.class);
    }

    @Test
    void testEntityToDomain() {
        // Arrange
        UUID id = UUID.randomUUID();
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(id);
        recipeEntity.setName("Spaghetti Bolognese");
        recipeEntity.setDescription("A delicious Italian pasta dish.");

        // Act
        Recipe recipe = recipeEntityMapper.entityToDomain(recipeEntity);

        // Assert
        assertEquals(recipeEntity.getId(), recipe.getId());
        assertEquals(recipeEntity.getName(), recipe.getName());
        assertEquals(recipeEntity.getDescription(), recipe.getDescription());
    }

    @Test
    void testDomainToEntity() {
        // Arrange
        UUID id = UUID.randomUUID();
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName("Spaghetti Bolognese");
        recipe.setDescription("A delicious Italian pasta dish.");

        // Act
        RecipeEntity recipeEntity = recipeEntityMapper.domainToEntity(recipe);

        // Assert
        assertEquals(recipe.getId(), recipeEntity.getId());
        assertEquals(recipe.getName(), recipeEntity.getName());
        assertEquals(recipe.getDescription(), recipeEntity.getDescription());
    }
}
