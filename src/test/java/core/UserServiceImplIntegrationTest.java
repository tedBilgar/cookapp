package core;

import com.tedbilgar.cookapp.repos.UserRepository;
import com.tedbilgar.cookapp.services.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceImplIntegrationTest {

    @TestConfiguration
    static class UserServiceImplContextConfiguration {

        @Bean
        public TestService testService(){
            return new TestService();
        }
    }

    @Autowired
    private TestService testService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void setTestService(){
        String name = "Denis";

        Assert.assertNotNull(testService.getUserEnteties());
    }
}
