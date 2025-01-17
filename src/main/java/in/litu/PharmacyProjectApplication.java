package in.litu;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PharmacyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyProjectApplication.class, args);
	}
	
	@Bean
	public ModelMapper geModelMapper()
	{
		return new ModelMapper();
	}

}
