package com.example.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api") // racine de l’API
public class RestApplication extends ResourceConfig {
    public RestApplication() {
        packages("com.example.resources"); // paquet contenant nos endpoints
    }
}
