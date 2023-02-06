package hjallad.AddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAddressBook() throws Exception {
        this.mockMvc.perform(get("/addressbook/create")).andDo(print()).andExpect(content().string(containsString("{\"buddyList\":[]}")));
    }

    @Test
    public void addBuddyTest() throws Exception {
        this.mockMvc.perform(get("/addressbook/create"));
        this.mockMvc.perform(get("/addressbook/addBuddy?name=hassan&address=123ggg&phone=6123444&bookId=1")).andDo(print()).andExpect(content().string(containsString("{\"buddyList\":[{\"id\":1,\"name\":\"hassan\",\"address\":\"123ggg\",\"phone\":\"6123444\"}]}")));
    }

    @Test
    public void removeBuddyTest() throws Exception {
//        this.mockMvc.perform(get("/addressbook/create"));
//        // add buddy named joe
//        this.mockMvc.perform(get("/addressbook/addBuddy?name=joe&address=456ggg&phone=6123774&bookId=1"));
//        // add buddy named hassan
//        this.mockMvc.perform(get("/addressbook/addBuddy?name=hassan&address=123ggg&phone=6123444&bookId=1"));
        //remove buddy hassan made in prev test
        this.mockMvc.perform(get("/addressbook/removeBuddy?name=hassan&bookId=1")).andDo(print()).andExpect(content().string(containsString("{\"buddyList\":[]}")));
    }
}
