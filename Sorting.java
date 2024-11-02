class Sorting{
    private String size;
    private int quantity;
    private double amount;

    Sorting(){

    }

    Sorting(String size,int quantity,double amount){
        this.size=size;
        this.quantity=quantity;
        this.amount=amount;
    }

    // set size
    public void setSize(String size){
        this.size=size;
    }

    // get Size
    public String getSize(){
        return this.size;
    }

    // set quantity
    public void setQuantity(int quantity){
        this.quantity=quantity;        
    }

    // get quantity
    public int getQuantity(){
        return this.quantity;
    }

    // set amount
    public void setAmount(double amount){
        this.amount=amount;
    }

    // get amount
    public double getAmount(){
        return this.amount;
    }
}