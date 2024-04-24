package pe.edu.cibertec.appwebventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AppWebVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppWebVentasApplication.class, args);
	}
	/*@Bean
	public WebMvcConfigurer configCorsGlobal(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/product/**")
						.allowedMethods("GET", "POST", "PUT")
						.allowedOrigins("*");
			}
		};
	}*/
}
