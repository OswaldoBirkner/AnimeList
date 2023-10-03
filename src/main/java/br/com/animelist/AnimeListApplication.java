package br.com.animelist;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Api(value = "Anime List Application", tags = {"Anime List"})
public class AnimeListApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimeListApplication.class, args);
    }
}
