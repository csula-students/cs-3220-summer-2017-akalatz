package edu.csula.jaxrs;


import java.util.List;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.csula.jaxrs.FoodItem;
import edu.csula.jaxrs.InventoryDAO;

@Path("food-resource")
@Singleton
public class FoodResource {
	
	    private InventoryDAO dao = new InventoryDAO();

	

	    @GET
	    @Path("fooditems")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<FoodItem> getFoodItems() {
	    	InventoryDAO dao = new InventoryDAO();
	    	return dao.list();
	     
	    }
	    
	    @GET
	    @Path("fooditems/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FoodItem getFoodItem(@PathParam("id") int id) {
	    	System.out.println(id); //testing purpose
	    	InventoryDAO dao = new InventoryDAO();
	    	return dao.get(id).get();
	        
	    }
	    
	    @POST
	    @Path("fooditems")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public boolean addFoodItem(FoodItem foodItem) {
	        dao.add(foodItem);
	        System.out.println(dao.list());
	        return true;
	    }

	    @PUT
	    @Path("fooditem/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public boolean updateFoodItem(FoodItem foodItem, @PathParam("id") int id) {
	        if (id == foodItem.getId()) {
	            dao.update(foodItem);
	            System.out.println(dao.list());
	            return true;
	        } else {
	            return false;
	        }
	    }

	    @DELETE
	    @Path("fooditem/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public boolean deleteFoodItem(@PathParam("id") int id) {
	        dao.delete(id);
	        System.out.println(dao.list());
	        return true;
	    }
	}