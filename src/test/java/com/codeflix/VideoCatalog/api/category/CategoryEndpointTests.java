package com.codeflix.VideoCatalog.api.category;

import com.codeflix.VideoCatalog.api.configuration.GlobalExceptionHandler;
import com.codeflix.VideoCatalog.application.usecase.category.common.CategoryOutputData;
import com.codeflix.VideoCatalog.application.usecase.category.create.CreateCategoryInputData;
import com.codeflix.VideoCatalog.application.usecase.category.create.ICreateCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.findall.IFindAllCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.get.IFindByIdCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.remove.IRemoveCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.update.IUpdateCategoryUseCase;
import com.codeflix.VideoCatalog.application.usecase.category.update.UpdateCategoryInputData;
import com.codeflix.VideoCatalog.domain.entity.Category;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class CategoryEndpointTests {
    
    private MockMvc mockMvc;
    private JacksonTester<CreateCategoryInputData> createJson;
    private JacksonTester<UpdateCategoryInputData> updateJson;

    @InjectMocks
    private CategoryEndpoint endpoint;

    @Mock
    private ICreateCategoryUseCase createUseCase;

    @Mock
    private IFindAllCategoryUseCase findAllUseCase;

    @Mock
    private IFindByIdCategoryUseCase findByIdUseCase;

    @Mock
    private IRemoveCategoryUseCase removeUseCase;

    @Mock
    private IUpdateCategoryUseCase updateUseCase;

    @BeforeEach
    public void init() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders
                    .standaloneSetup(endpoint)
                    .setControllerAdvice(new GlobalExceptionHandler())
                    .build();
    }

    @Test
    public void createCategory() throws Exception {
        CreateCategoryInputData input = new CreateCategoryInputData();
        input.setName("any_name");

        String payload = createJson.write(input)
                                   .getJson();

        Category entity = new Category(
            "any_name",
            "any_description",
            true
        );
        CategoryOutputData output = new CategoryOutputData(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getIsActive()
        );

        doReturn(output)
            .when(createUseCase)
            .execute(any(CreateCategoryInputData.class));

        mockMvc.perform(post("/categories")
               .contentType(APPLICATION_JSON)
               .content(payload))
               .andExpect(status().isCreated())
               .andExpect(content().contentType(APPLICATION_JSON))
               .andExpect(jsonPath("$.name", is("any_name")));
    }

    @Test
    public void findAllCategories() throws Exception {
        Category entity1 = new Category(
            "any_name_1",
            "any_description",
            true            
        );
        Category entity2 = new Category(
            "any_name_2",
            "any_description",
            true            
        );     
        CategoryOutputData output1 = new CategoryOutputData(
            entity1.getId(),
            entity1.getName(),
            entity1.getDescription(),
            entity1.getIsActive()
        );
        CategoryOutputData output2 = new CategoryOutputData(
            entity2.getId(),
            entity2.getName(),
            entity2.getDescription(),
            entity2.getIsActive()
        );  
        
        List<CategoryOutputData> output = new ArrayList<CategoryOutputData>();
        output.addAll(Arrays.asList(output1, output2));

        doReturn(output)
            .when(findAllUseCase)
            .execute();

        mockMvc.perform(get("/categories")
               .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().contentType(APPLICATION_JSON))
               .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void findByIdCategory() throws Exception {
        Category entity = new Category(
            "any_name",
            "any_description",
            true            
        );
        CategoryOutputData output = new CategoryOutputData(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getIsActive()
        );

        doReturn(output)
            .when(findByIdUseCase)
            .execute(entity.getId());

        mockMvc.perform(get("/categories/" + entity.getId())
               .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().contentType(APPLICATION_JSON));        
    }
    
    @Test
    public void removeCategory() throws Exception {
        Category entity = new Category(
            "any_name",
            "any_description",
            true
        );

        doNothing()
            .when(removeUseCase)
            .execute(entity.getId());

        mockMvc.perform(delete("/categories/" + entity.getId())
               .contentType(APPLICATION_JSON))
               .andExpect(status().isNoContent());
    }

    @Test
    public void updateCategory() throws Exception {
        Category entity = new Category(
            "any_name_1",
            "any_description"        
        );
        UpdateCategoryInputData input = new UpdateCategoryInputData();
        input.setName("any_name_2");  
        input.setDescription(entity.getDescription());

        String payload = updateJson.write(input)
                                   .getJson();

        doNothing()
            .when(updateUseCase)
            .execute(entity.getId(), input);

        mockMvc.perform(put("/categories/" + entity.getId())
               .contentType(APPLICATION_JSON)
               .content(payload))
               .andExpect(status().isNoContent());
    }
}
