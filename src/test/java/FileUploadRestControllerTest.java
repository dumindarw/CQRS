import com.drw.cqrs.config.DocumentConfig;
import com.drw.cqrs.controllers.DocumentController;
import com.drw.cqrs.services.CadreDocumentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={DocumentConfig.class},webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class FileUploadRestControllerTest  {


    @InjectMocks
    CadreDocumentService cadreDocumentService = new CadreDocumentService();


    private InputStream is;
    private MockMvc mockMvc;

    @Before
    public void init() throws FileNotFoundException {

        mockMvc = MockMvcBuilders.standaloneSetup(new DocumentController()).setControllerAdvice().build();
        is = new FileInputStream(new File("src/test/resources/test.xlsx"));


    }

    @Test
    public void testUploadFile() throws Exception {


        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test.xlsx", "multipart/form-data", is);

        String s = cadreDocumentService.upload(mockMultipartFile);

        Assert.assertEquals("CadreDoc", s);
    }

}
