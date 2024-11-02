class FashionShop {
    public static void main(String args[]){
        CustomerDetailsHandeler customerDetails = new CustomerDetailsHandeler();
        new HomePage(customerDetails).setVisible(true);        
    }
    
}
