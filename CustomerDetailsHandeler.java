class CustomerDetailsHandeler {
    private FashionShopCustomerDetails[] customerDetailsArray;

    private String newGeneratedORderID;
    public int orderNumber = 1;

    private int tempMedium;
    private int tempXtraSmall;
    private int tempXtraXl;
    private int tempXtraLarge;
    private int tempSmall;
    private int tempLarge;

    private double mediumAmount;
    private double xtraLargeAmount;
    private double xtraxXlAmount;
    private double xtraSmallAmount;
    private double smallAmount;
    private double largeAmount;
    private double searchTotalAmount;

    CustomerDetailsHandeler() {
        this.customerDetailsArray = new FashionShopCustomerDetails[0];

    }

    // ================= order id increment method =========================
    public String incrementOid() {
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

        return newGeneratedORderID;
    }

    // public String getOrderId(){
    // return this.newGeneratedORderID;
    // }

    // Phone Number Validation
    public boolean PhoneNumber(String phoneNumber) {
        int count = 0;
        for (int i = 0; i < phoneNumber.length(); i++) {
            phoneNumber.charAt(i);
            count++;
        }
        if (count != 10 || phoneNumber.charAt(0) != '0') {
            return false;
        } else {
            return true;
        }
    }

    // Size Validation
    public boolean tShirtSizeValidation(String tShirtSize) {
        if (tShirtSize.equalsIgnoreCase("XS") || tShirtSize.equalsIgnoreCase("S") || tShirtSize.equalsIgnoreCase("M")
                || tShirtSize.equalsIgnoreCase("L") || tShirtSize.equalsIgnoreCase("XL")
                || tShirtSize.equalsIgnoreCase("XXL")) {
            return true;
        } else {
            return false;
        }

    }

    // Quantiity Validation
    public boolean quantityValidation(String qty) {
        if (Integer.parseInt(qty) > 0) {
            return true;
        } else {
            return false;
        }

    }

    // Amount Calculation
    public double amountCalculation(String qty, String tShirtSize) {
        double amount=0;
        int quantiity = Integer.parseInt(qty);
        switch (tShirtSize) {
            case "XS":
                amount = quantiity * 600;
                break;
            case "S":
                amount = quantiity * 800;
                break;
            case "M":
                amount = quantiity * 900;
                break;
            case "L":
                amount = quantiity * 1000;
                break;
            case "XL":
                amount = quantiity * 1100;
                break;
            case "XXL":
                amount = quantiity * 1200;
                break;

        }        
        return amount;

    }

    public boolean addCustomer(FashionShopCustomerDetails customer) {
        extendArrays();
        customerDetailsArray[customerDetailsArray.length - 1] = customer;
        return true;
    }

    public void extendArrays() {
        FashionShopCustomerDetails[] tempCustomerDetails = new FashionShopCustomerDetails[customerDetailsArray.length
                + 1];

        for (int i = 0; i < customerDetailsArray.length; i++) {
            tempCustomerDetails[i] = customerDetailsArray[i];
        }
        customerDetailsArray = tempCustomerDetails;
    }

    public boolean serachCustomerId(String cusEnterPhonenum) {
        //boolean numbervalid = false;

        for (int i = 0; i < customerDetailsArray.length; i++) {
            if (cusEnterPhonenum.equals(customerDetailsArray[i].getPhoneNumber())) {
                //numbervalid = true;

                if (customerDetailsArray[i].getSize().equals("M")) {
                    this.tempMedium += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("XS")) {
                    this.tempXtraSmall += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("XXL")) {
                    this.tempXtraXl += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("XL")) {
                    this.tempXtraLarge += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("S")) {
                    this.tempSmall += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("L")) {
                    this.tempLarge += customerDetailsArray[i].getQuantity();
                }
                tempAmountCalculation();;
                return true;                
            }            
        }
        return false;
        // if (numbervalid == false) {
        //     //return false;
        // }

    }
    public void tempAmountCalculation(){
        this.mediumAmount=tempMedium*900;
        this.xtraLargeAmount=tempXtraLarge*1100;
        this.xtraxXlAmount=tempXtraXl*1200;
        this.xtraSmallAmount=tempXtraSmall*600;
        this.smallAmount=tempSmall*800;
        this.largeAmount=tempLarge*1000;
        this.searchTotalAmount=mediumAmount+xtraLargeAmount+xtraxXlAmount+xtraSmallAmount+smallAmount+largeAmount;
    }
    public int getMedium(){
        return this.tempMedium;
    }
    public int getXtraSmall(){
        return this.tempXtraSmall;
    }
    public int getXtraXl(){
        return this.tempXtraXl;
    }
    public int getXtraLarge(){
        return this.tempXtraLarge;
    }
    public int getSmall(){
        return this.tempSmall;
    }
    public int getLarge(){
        return this.tempLarge;
    }

    // amount getters
    public double getMediumAmount(){
        return this.mediumAmount;
    }
    public double getXtraLargeAmount(){
        return this.xtraLargeAmount;
    }
    public double getXtraXlAmount(){
        return this.xtraxXlAmount;
    }
    public double getXtraSmallAmount(){
        return this.xtraSmallAmount;
    }
    public double getSmallAmount(){
        return this.smallAmount;
    }
    public double getLargeAmount(){
        return this.largeAmount;
    }
    public double getSearchTotalAmount(){
        return this.searchTotalAmount;
    }
    
        
   
    
}
