package com.pradip.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * @author Pradip
 *
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodLevelSecurityConfiguration extends GlobalMethodSecurityConfiguration{

}
