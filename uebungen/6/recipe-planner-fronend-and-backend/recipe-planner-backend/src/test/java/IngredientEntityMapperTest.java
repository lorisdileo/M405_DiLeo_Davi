import ch.tbz.recipe.planner.entities.IngredientEntity;
import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.mapper.IngredientEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientEntityMapperTest {

    private IngredientEntityMapper ingredientEntityMapper;

    @BeforeEach
    void setUp() {
        ingredientEntityMapper = Mappers.getMapper(IngredientEntityMapper.class);
    }

    @Test
    void testEntityToDomain() {
        UUID id = UUID.randomUUID();
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(id);
        ingredientEntity.setName("Tomato");
        ingredientEntity.setAmount(3);

        Ingredient ingredient = ingredientEntityMapper.entityToDomain(ingredientEntity);

        assertEquals(ingredientEntity.getId(), ingredient.getId());
        assertEquals(ingredientEntity.getName(), ingredient.getName());
        assertEquals(ingredientEntity.getAmount(), ingredient.getAmount());
    }

    @Test
    void testDomainToEntity() {
        UUID id = UUID.randomUUID();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(id);
        ingredient.setName("Tomato");
        ingredient.setAmount(3);

        IngredientEntity ingredientEntity = ingredientEntityMapper.domainToEntity(ingredient);

        assertEquals(ingredient.getId(), ingredientEntity.getId());
        assertEquals(ingredient.getName(), ingredientEntity.getName());
        assertEquals(ingredient.getAmount(), ingredientEntity.getAmount());
    }

    @Test
    void testEntitiesToDomains() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        IngredientEntity ingredientEntity1 = new IngredientEntity();
        ingredientEntity1.setId(id1);
        ingredientEntity1.setName("Tomato");
        ingredientEntity1.setAmount(3);

        IngredientEntity ingredientEntity2 = new IngredientEntity();
        ingredientEntity2.setId(id2);
        ingredientEntity2.setName("Cucumber");
        ingredientEntity2.setAmount(2);

        List<IngredientEntity> ingredientEntities = Arrays.asList(ingredientEntity1, ingredientEntity2);

        List<Ingredient> ingredients = ingredientEntityMapper.entitiesToDomains(ingredientEntities);


        assertEquals(ingredientEntities.size(), ingredients.size());
        assertEquals(ingredientEntities.get(0).getId(), ingredients.get(0).getId());
        assertEquals(ingredientEntities.get(1).getName(), ingredients.get(1).getName());
    }

    @Test
    void testDomainsToEntities() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(id1);
        ingredient1.setName("Tomato");
        ingredient1.setAmount(3);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(id2);
        ingredient2.setName("Cucumber");
        ingredient2.setAmount(2);

        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2);

        List<IngredientEntity> ingredientEntities = ingredientEntityMapper.domainsToEntities(ingredients);

        assertEquals(ingredients.size(), ingredientEntities.size());
        assertEquals(ingredients.get(0).getId(), ingredientEntities.get(0).getId());
        assertEquals(ingredients.get(1).getAmount(), ingredientEntities.get(1).getAmount());
    }
}
