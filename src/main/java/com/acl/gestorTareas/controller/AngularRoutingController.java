package com.acl.gestorTareas.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AngularRoutingController {
    
    @GetMapping(value = {"/", "/inicio", "/inicio/**"}, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String serveAngularApp(HttpServletResponse response) throws IOException {
        Resource resource = new ClassPathResource("static/index.html");
        response.setContentType("text/html; charset=UTF-8");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}
