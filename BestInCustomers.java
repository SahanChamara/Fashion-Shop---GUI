class BestsInCustomer{
    private int quantity;
    private double amount;
    private String customerPhoneNumber;

    BestsInCustomer(){

    }
    BestsInCustomer(int quantity,double amount,String customerPhoneNumber){
        this.quantity=quantity;
        this.amount=amount;
        this.customerPhoneNumber=customerPhoneNumber;
    }

    // set Quantiity
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    
    // get Quantiity
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


    // set Phone Number
    public void setPhoneNumber(String customerPhoneNumber){
        this.customerPhoneNumber=customerPhoneNumber;
    }

    // Get Phone Number
    public String getPhoneNumber(){
        return this.customerPhoneNumber;
    }
}