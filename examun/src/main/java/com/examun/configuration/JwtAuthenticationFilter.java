package com.examun.configuration;

import com.examun.Impl.UserDetailsServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EmptyStackException;


@Service
@NoArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {



   @Autowired
    JwtUtils jwtUtils;
;
@Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    final  String requestTokenHeader =request.getHeader("Authorization");
    System.out.println(requestTokenHeader);
    String username=null;
    String jwtToken=null;

    if (requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")){
      jwtToken=requestTokenHeader.substring(7);

      try {
          username=this.jwtUtils.extractUsername(jwtToken);
      } catch (EmptyStackException ex){
          ex.printStackTrace();
      } catch (Exception ex){
          ex.printStackTrace();
          System.out.println("Jwt Token Has expected");
      }

    }else {
        System.out.println("Invalid Token  notE Start whit Bearer String");
    }
        if ((username != null) && (SecurityContextHolder.getContext().getAuthentication() == null)) {
            final  UserDetails userDetails=this.userDetailsService.loadUserByUsername(username);
            if (jwtUtils.validateToken(jwtToken,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                        new UsernamePasswordAuthenticationToken(userDetails ,null,userDetails.getAuthorities());
               usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }else {
                System.out.println("token its not valid");
            }
        }
        filterChain.doFilter(request,response);
    }
}
