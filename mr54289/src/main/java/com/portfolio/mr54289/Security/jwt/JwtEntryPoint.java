
package com.portfolio.mr54289.Security.jwt;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.slf4j.*;

import org.springframework.security.core.*;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{
    
    
   private final static Logger logger= LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.error("Fallo el metodo commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
  
        
    }
   

