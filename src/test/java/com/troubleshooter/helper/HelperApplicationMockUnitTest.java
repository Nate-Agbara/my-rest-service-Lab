//package com.troubleshooter.helper;
//
//import com.troubleshooter.helper.model.Users;
//import com.troubleshooter.helper.repository.MysqlRepo;
//import com.troubleshooter.helper.service.MysqlService;
////import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//public class HelperApplicationMockUnitTest {
//
//    @Mock
//    private MysqlRepo mysqlRepo;
//
//
//    @InjectMocks
//    MysqlService mysqlService;
//
//    @Before(value = "setup")
//    public void setup(){
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testSubmit(){
//        // create a user
//        Users users = new Users();
//        users.setFirstname("Nathan");
//        users.setLastname("Agbara");
//        users.setEmail("test@agbara.com");
//
//        when(mysqlRepo.submit(any(String.class),any(String.class),any(String.class))).thenReturn(1);
//
//        // submit the user
//        int response = mysqlService.submit(null, null, null);
//
//        // verify the save
//        assertEquals("Nathan", users.getFirstname());
//    }
//}
