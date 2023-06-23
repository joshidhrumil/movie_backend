package com.demo.movie.SecurityService;

import com.demo.movie.service.UserService;
import com.demo.movie.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class JwtFilterRequest extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UserServiceImpl userService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader=request.getHeader("Authorization");
        String username = null;
       // String password =null;
        String jwtToken=null;

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
        {
            jwtToken=authorizationHeader.substring(7);
            username = jwtUtils.extractUsername(jwtToken);

        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null)
        {
                UserDetails CurrentUser =userService.loadUserByUsername(username);
                Boolean TokenValidated=jwtUtils.validateToken(jwtToken,CurrentUser);
                if(TokenValidated)
                {
                   UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(CurrentUser,null,CurrentUser.getAuthorities());
                   usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                   SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
        }
        filterChain.doFilter(request,response);
    }
}
