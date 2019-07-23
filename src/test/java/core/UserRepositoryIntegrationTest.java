package core;

import com.tedbilgar.cookapp.config.AppConfig;
import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.repos.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void mainTest(){
        UserEntity user = new UserEntity();
        user.setFirstName("Denis");
        user.getFirstName();
        userRepository.save(user);
        Assert.assertEquals(1l,1l);
    }
}
