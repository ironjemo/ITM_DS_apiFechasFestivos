package apifestivefecha.apifestvefecha;

//import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//import apifestivefecha.apifestvefecha.aplicacion.ServicioFechas;

@SpringBootApplication
public class ApifestvefechaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApifestvefechaApplication.class, args);
	   }

		
	   @Bean
	   public CorsFilter corsFilter() {
		   CorsConfiguration config = new CorsConfiguration();
		   config.setAllowCredentials(true);
		   config.addAllowedOrigin("http://localhost:4200/");
		   config.addAllowedMethod("*");
		   config.addAllowedHeader("*");
   
		   UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		   source.registerCorsConfiguration("/**", config);
   
		   return new CorsFilter(source); 
	   }

		
}
