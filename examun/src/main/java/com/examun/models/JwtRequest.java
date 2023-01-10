package com.examun.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
public class JwtRequest   {
    @JsonProperty
    String username;
    @JsonProperty
    String password;
    public  JwtRequest(){
        super();
    }

}
