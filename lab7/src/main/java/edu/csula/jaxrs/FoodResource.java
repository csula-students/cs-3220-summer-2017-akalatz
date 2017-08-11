package edu.csula.jaxrs;

import java.util.ArrayList;
import java.util.Arrays;
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
	private List<FoodItem> items = new ArrayList<>(Arrays.asList(new FoodItem(1, "Hamburger", "An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!", 12.99)));
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
	    	return items.get(id);
	        
	    }
	    
	    
	    @POST
	    @Path("fooditems")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public boolean addItem(FoodItem newItem) {
	    	InventoryDAO dao = new InventoryDAO();
	    	dao.add(newItem);
	    	return true;
	    }
	    
	    @DELETE
	    @Path("delete/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public boolean deleteItem(@PathParam("id") int id) {
	    	System.out.println(id);
	    	InventoryDAO dao = new InventoryDAO();
	    	dao.delete(id);
	    	return true;
	    	
	    }
	    
	    @PUT
	    @Path("fooditems/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public boolean updateItem(FoodItem item, @PathParam("id") int id) {
	    	System.out.println(id);
	    		InventoryDAO dao = new InventoryDAO();
	    	dao.update(item);
	    	return true;
	    }
	}