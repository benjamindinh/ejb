package com.ejbank.api;

import javax.ejb.EJB;


import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ejbank.payloads.user.UserPayload;
import com.ejbank.sessions.user.UserSessionLocal;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class UserController {
	
	@EJB
	private UserSessionLocal userService ;
	
	@GET
    @Path("/{id}")
    public UserPayload get(@PathParam("id") int id) {
		UserPayload user = userService.get(id) ;
        return user ;
    }
	
	@GET
    @Path("/name/{name}")
    public UserPayload getByName(@PathParam("name") String lastname) {
		UserPayload user = userService.getByLastName(lastname) ;
        return user ;
    }
	
}
