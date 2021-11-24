package com.troubleshooter.helper;

import com.troubleshooter.helper.model.Users;
import com.troubleshooter.helper.service.MysqlService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//import static io.restassured.RestAssured.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HelperApplicationTests {

	@Autowired
	private MysqlService mysqlService;

	@Test
	public void submit() {
		//create a user

		//Test submitting a user
		int submitAttemptResponse = mysqlService.submit("Nathan", "Agbara","test@nathan.com");

		// Verify the submit
		assertNotNull(submitAttemptResponse);
		assertEquals(1, submitAttemptResponse);

	}


}
