package midtern;



public class restaurant {
	public static int id;
	public static String name;
	public static String url;
	public static int designRatings;
	public static int tasteRatings;

	
	public restaurant(int id,String name,String url,int designRatings,int tasteRatings){
		this.id=id;
		this.name=name;
		this.url=url;
		this.designRatings=designRatings;
		this.tasteRatings=tasteRatings;
	}
	
	public int getId(){
		return id;
	}
	public String getname(){
		return name;
		
	}
	
	public String geturl(){
		return url;
	}
	public int getDesignRating(){
		return designRatings;
	}
	
	public int getTasteRatings(){
		return tasteRatings;
	}
}