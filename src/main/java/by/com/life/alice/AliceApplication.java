package by.com.life.alice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@ImportResource(locations = { "classpath:beans.xml" })
@SpringBootApplication
public class AliceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AliceApplication.class, args);
	}


//	@Bean
//	public ServletRegistrationBean exampleServletBean() {
//		ServletRegistrationBean bean = new ServletRegistrationBean(
//				new TestServlet(), "/*");
//		bean.setLoadOnStartup(1);
//		return bean;
//	}
}
