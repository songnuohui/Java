package com.zt;
class Fruit{
	  private String type;  private String color;
	  private double price;	  
	  public Fruit(){}
	  public Fruit(String type, String color, double price) {
		this.type = type; this.color = color;
		this.price = price;
	}	 
	 public void show(){
		 System.out.println("Fruit show()");
	 } 
}
class Apple extends Fruit{
	public Apple(){
		super("苹果","绿色",9.9);
	}
	 public void show(){
		 System.out.println("Apple show()");
	 } 
	 public void addPrice(){
		 System.out.println("Apple addPrice()");
	 } 
}
public class SuperDemo {
        public static void main(String[] args) {
        	//Fruit f=new Apple();
        	//f.addPrice();  //不可见
        	//f.show();        //调用真实对象里面的方法
        	
        	//Apple a= (Apple) new Fruit();
        	
        	Fruit f=new Apple();
        	System.out.println(f instanceof Fruit);
        	System.out.println(f instanceof Apple);
        	Apple a= (Apple)f;
        	System.out.println(a);
		}
}
