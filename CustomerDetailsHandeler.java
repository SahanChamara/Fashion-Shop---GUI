class CustomerDetailsHandeler {
    private FashionShopCustomerDetails [] CustomerDetailsArray;

    private String newGeneratedORderID;
    private int orderNumber=1;

    CustomerDetailsHandeler(){
        this.CustomerDetailsArray = new FashionShopCustomerDetails[0];
       
    }  
     // ================= order id increment method =========================
    public void incrementOid(){        
        int tempOrderNumber = orderNumber;
        
        int[] tempNumOrder = new int[5];
        String idNum = "";
        String tag = "ODR#";
        
        for (int i = 4; tempOrderNumber > 0; i--) {
            tempNumOrder[i] = tempOrderNumber % 10;
            tempOrderNumber /= 10;
        }
        for (int i = 0; i < tempNumOrder.length; i++) {
            idNum += tempNumOrder[i];                               
        }
        newGeneratedORderID = tag + idNum;
        
        // return newGeneratedORderID;
    }    

    public String getOrderId(){
        return this.newGeneratedORderID;
    }
}
