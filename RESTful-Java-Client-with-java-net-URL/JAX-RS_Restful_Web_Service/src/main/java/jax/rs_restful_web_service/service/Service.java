package jax.rs_restful_web_service.service;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import jax.rs_restful_web_service.config.Config;
import jax.rs_restful_web_service.model.Person;

@Path("service")
public class Service extends Config{
    
    private static Map<Integer,Person>persons = new HashMap<>();
    
    static{
        for(int i = 0; i < 10; i++){
            Person p = new Person();
            int id = i + 1;
            p.setId(id);
            p.setName("Name "+id);
            p.setAddress("Address"+id);
            p.setAge(new Random().nextInt(50)+1);
            
            persons.put(id,p);
        }
    }
    
    //Mthod which return a single person object in xml format
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id")int id){
        return persons.get(id);
    }
    
    //Method which return a single person object in json format 
    @GET
    @Path("/getPersonByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam("id")int id){
        return persons.get(id);
    }
    
    //Method which return all persons in xml format
    @GET
    @Path("/getAllPersonXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person>getAllPersonXML(){
        return new ArrayList<Person>(persons.values());
    }

    //Method which return all persons in json format    
    @GET
    @Path("/getAllPersonJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person>getAllPersonJSON(){
        return new ArrayList<Person>(persons.values());
    }
}
