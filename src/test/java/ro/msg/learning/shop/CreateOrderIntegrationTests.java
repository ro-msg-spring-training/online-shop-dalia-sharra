package ro.msg.learning.shop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ro.msg.learning.shop.exception.ProductException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ShopApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
@ActiveProfiles("test")
class CreateOrderIntegrationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void createOrderSuccess(){
        try {
            JSONArray array = new JSONArray();
            array.put(new JSONObject().put("productId", 2).put("quantity", 1));
            array.put(new JSONObject().put("productId", 3).put("quantity", 2));
            String jsonString = new JSONObject()
                    .put("timestamp", "2018-12-30T19:34:50")
                    .put("addressCountry", "Country1")
                    .put("addressCity", "City1")
                    .put("addressCounty", "County1")
                    .put("addressStreetAddress", "Street1")
                    .put("products", array)
                    .toString();
            mvc.perform(post("/order").content(jsonString)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void createOrderFailure(){
        try {
            JSONArray array = new JSONArray();
            array.put(new JSONObject().put("productId", 1).put("quantity", 100));
            array.put(new JSONObject().put("productId", 2).put("quantity", 1));
            String jsonString = new JSONObject()
                    .put("timestamp", "2018-12-30T19:34:50")
                    .put("addressCountry", "Country1")
                    .put("addressCity", "City1")
                    .put("addressCounty", "County1")
                    .put("addressStreetAddress", "Street1")
                    .put("products", array)
                    .toString();
            mvc.perform(post("/order").content(jsonString)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isConflict());
        } catch (ProductException productException) {
            assertFalse(productException.getMessage().isEmpty());
        } catch (Exception e) {
            fail();
        }
    }
}
