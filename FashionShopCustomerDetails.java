class FashionShopCustomerDetails{
	private String orderId;
	private String phoneNumber;
	private String size;
	private int quantity;
	private double amount;
	private int orderStatus;	
	
	//defauls constructor
	FashionShopCustomerDetails(){		
		
	}
	
	// all constructors
	FashionShopCustomerDetails(String orderId , String phoneNumber , String size , int quantity , double amount,int orderStatus){
		this.orderId = orderId;
		this.phoneNumber=phoneNumber;
		this.size=size;
		this.quantity=quantity;
		this.amount=amount;
		this.orderStatus=orderStatus;		
	}
	
	// set Order Id
	public void setOrderId(String orderId){        
		this.orderId=orderId;        
	}
	
	// Get Order Id
	public String getOrderId(){
		return this.orderId;
	}
	
	// set Phone Number
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	
	// Get Phone Number
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	// Set Size
	public void setSize(String size){
		this.size=size;
	}
	
	// Get Size
	public String getSize(){
		return this.size;
	}
    
    // Set Quantity
    public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	
	// Get Quantity
	public int getQuantity(){
		return this.quantity;
	}
	
	// set Amount
	public void setAmount(double amount){
		this.amount=amount;
	}
	
	// Get Amount
	public double getAmount(){
		return this.amount;
	}
	
	//set Order Status
	public void setOrderStatus(int orderStatus){
		this.orderStatus=orderStatus;
	}
	
	// // Get Order Status
	public int getOrderStatus(){
		return this.orderStatus;
	}

    // get order status delivering . processing or delivered
    public String printOrderStatus(){
        if(this.orderStatus==1){
            return "Delivering";
        }else if(this.orderStatus==2){
            return "Delivered";
        }else{
            return "Processing";
        }
    }
}