package org.example.matricula.config;

import org.example.matricula.dto.CareerDTO;
import org.example.matricula.model.Career;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;


@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean("careerMapper")
    public ModelMapper careerMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(Career.class, CareerDTO.class)
                .addMapping(Career::getName,(dest, v) -> dest.setNameCareer((String) v));
        return mapper;
    }
}
