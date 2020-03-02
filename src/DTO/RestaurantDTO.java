package DTO;

public class RestaurantDTO {
	private String rid;
	private String restaurant;
	private int delviery_fee;
	private int min_delivery_fee;
	public RestaurantDTO(String rid, String restaurant, int delviery_fee, int min_delivery_fee) {
		super();
		this.rid = rid;
		this.restaurant = restaurant;
		this.delviery_fee = delviery_fee;
		this.min_delivery_fee = min_delivery_fee;
	}
	
	// 식당명만 출력하기 위한 overload 
	public RestaurantDTO(String restaurant) {
		this.restaurant = restaurant;
	}
	
	public String getRid() {
		return rid;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public int getDelviery_fee() {
		return delviery_fee;
	}
	public int getMin_delivery_fee() {
		return min_delivery_fee;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public void setDelviery_fee(int delviery_fee) {
		this.delviery_fee = delviery_fee;
	}
	public void setMin_delivery_fee(int min_delivery_fee) {
		this.min_delivery_fee = min_delivery_fee;
	}

}
