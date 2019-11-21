package com.toby.githubsearch.rs;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class RsConfig extends ResourceConfig 
{
    public RsConfig() 
    {
        register(SearchResource.class);
        register(SearchExpHandler.class);
        register(SearchSecurityFilter.class);
    }
}
