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

    //Phone Number Validation
    public boolean PhoneNumber(String phoneNumber){
        int count=0;
        for(int i=0; i<phoneNumber.length(); i++){
            phoneNumber.charAt(i);
            count++;
        }
        if(count!=10 || phoneNumber.charAt(0)!='0'){
            return false;
        }else{
            return true;
        }
    }

    //Size Validation
    public boolean tShirtSizeValidation(String tShirtSize){
        if(tShirtSize.equalsIgnoreCase("XS") || tShirtSize.equalsIgnoreCase("S") || tShirtSize.equalsIgnoreCase("M") || tShirtSize.equalsIgnoreCase("L") || tShirtSize.equalsIgnoreCase("XL") || tShirtSize.equalsIgnoreCase("XXL")){
            return true;
        }else{
            return false;
        }

    }
    
}
