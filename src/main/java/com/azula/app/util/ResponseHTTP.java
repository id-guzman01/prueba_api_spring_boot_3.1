package com.azula.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ResponseHTTP {

    public String respuesta(String message, String httpcode) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> campos = new HashMap<>();
        campos.put("status", httpcode);
        campos.put("message", message);

        String json = mapper.writeValueAsString(campos);

        return json;
    }

}
