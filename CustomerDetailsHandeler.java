class CustomerDetailsHandeler {
    private FashionShopCustomerDetails [] customerDetailsArray;

    private String newGeneratedORderID;
    static int orderNumber=1;

    CustomerDetailsHandeler(){
        this.customerDetailsArray = new FashionShopCustomerDetails[0];
       
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

    //Quantiity Validation
    public boolean quantityValidation(String qty){
        if(Integer.parseInt(qty)>0){
            return true;
        }else{
            return false;
        }

    }

    //Amount Calculation
    public double amountCalculation(String qty,String tShirtSize){
        double amount=0;
        int quantiity = Integer.parseInt(qty);        
        switch (tShirtSize){
            case "XS":
                amount = quantiity*600;                
                break;
            case "S":
                amount = quantiity*800;
                break;
            case "M":
                amount = quantiity*900;
                break;
            case "L":
                amount = quantiity*1000;
                break;
            case "XL":
                amount = quantiity*1100;
                break;
            case "XXL":
                amount = quantiity*1200;
                break;       
    
        }
        return amount;

    }

    public boolean addCustomer(FashionShopCustomerDetails customer){
        extendArrays();
        customerDetailsArray[customerDetailsArray.length-1]=customer;
        return true;
    }

    public void extendArrays(){
        FashionShopCustomerDetails[] tempCustomerDetails = new FashionShopCustomerDetails[customerDetailsArray.length+1];

        for(int i=0; i<customerDetailsArray.length; i++){
            tempCustomerDetails[i]=customerDetailsArray[i];
        }
        customerDetailsArray=tempCustomerDetails;
    }   
}
