package osmpackage;

//class used to create Product objects
public class Product 
{
	private int productID;
	private String productName;
	private double productPrice;
	
	public void setProductID(int id)
	{
		productID = id;
	}
	public void setProductName(String name)
	{
		productName = name;
	}
	public void setProductPrice(double price)
	{
		productPrice = price;
	}

	
	
	public int getProductID()
	{
		return productID; 
	}
	public String getProductName()
	{
		return productName;
	}
	public double getProductPrice()
	{
		return productPrice; 
	}

}
