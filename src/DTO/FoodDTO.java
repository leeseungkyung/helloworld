package DTO;

public class FoodDTO {
	private String rid;
	private int fid;
	private String name;
	private int price;
	private int sideIndex;
	public FoodDTO(String rid, int fid, String name, int price, int sideIndex) {
		super();
		this.rid = rid;
		this.fid = fid;
		this.name = name;
		this.price = price;
		this.sideIndex = sideIndex;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSideIndex() {
		return sideIndex;
	}
	public void setSideIndex(int sideIndex) {
		this.sideIndex = sideIndex;
	}
}
