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

    private boolean numbervalid;

    private final int processing = 0;
    private final int delivering = 1;
    private final int delivered = 2;

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
    // public boolean tShirtSizeValidation(String tShirtSize) {
    //     if (tShirtSize.equalsIgnoreCase("XS") || tShirtSize.equalsIgnoreCase("S") || tShirtSize.equalsIgnoreCase("M")
    //             || tShirtSize.equalsIgnoreCase("L") || tShirtSize.equalsIgnoreCase("XL")
    //             || tShirtSize.equalsIgnoreCase("XXL")) {
    //         return true;
    //     } else {
    //         return false;
    //     }

    // }

    public boolean tShirtSizeValidation(String tShirtSize) {
        tShirtSize = tShirtSize.toUpperCase();
        if (tShirtSize.equals("XS") || tShirtSize.equals("S") || tShirtSize.equals("M")
                || tShirtSize.equals("L") || tShirtSize.equals("XL")
                || tShirtSize.equals("XXL")) {
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
        tShirtSize = tShirtSize.toUpperCase();

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
        FashionShopCustomerDetails[] tempCustomerDetails = new FashionShopCustomerDetails[customerDetailsArray.length+ 1];

        for (int i = 0; i < customerDetailsArray.length; i++) {
            tempCustomerDetails[i] = customerDetailsArray[i];
        }
        customerDetailsArray = tempCustomerDetails;
    }

    // serarch by custoemer id...................
    public void serachCustomerId(String cusEnterPhonenum) {
        numbervalid = false;

        for (int i = 0; i < customerDetailsArray.length; i++) {
            if (cusEnterPhonenum.equals(customerDetailsArray[i].getPhoneNumber())) {
                numbervalid = true;               

                if (customerDetailsArray[i].getSize().equals("M")) {
                    tempMedium += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("XS")) {
                    tempXtraSmall += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("XXL")) {
                    tempXtraXl += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("XL")) {
                    tempXtraLarge += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("S")) {
                    tempSmall += customerDetailsArray[i].getQuantity();
                } else if (customerDetailsArray[i].getSize().equals("L")) {
                    tempLarge += customerDetailsArray[i].getQuantity();
                }
                tempAmountCalculation();                               
            }                       
        }        
    }

    public boolean getNumberValid(){
        return this.numbervalid;
    }
    
    public void tempAmountCalculation(){        
        mediumAmount=tempMedium*900;
        xtraLargeAmount=tempXtraLarge*1100;
        xtraxXlAmount=tempXtraXl*1200;
        xtraSmallAmount=tempXtraSmall*600;
        smallAmount=tempSmall*800;
        largeAmount=tempLarge*1000;
        searchTotalAmount=mediumAmount+xtraLargeAmount+xtraxXlAmount+xtraSmallAmount+smallAmount+largeAmount;        
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

    public void tempCountUpdate(){
        this.tempMedium=0;
        this.tempXtraLarge=0;
        this.tempXtraXl=0;
        this.tempXtraSmall=0;
        this.tempSmall=0;
        this.tempLarge=0;
    }

    // search customer by order id..........
    public FashionShopCustomerDetails serachOrderId(String orderId){
        for(int i=0; i<customerDetailsArray.length; i++){
            if(orderId.equalsIgnoreCase(customerDetailsArray[i].getOrderId())){
                return customerDetailsArray[i];
            }
        }
        return null;
    }

    // Delete Customer ...................
    public boolean deleteOrder(String id){
        int index=-1;
        for(int i=0; i<customerDetailsArray.length; i++){
            if(id.equalsIgnoreCase(customerDetailsArray[i].getOrderId())){
                index=i;
                break;
            }            
        }
        if(index==-1){
            return false;
        }else{
            FashionShopCustomerDetails[] tempCusDetails = new FashionShopCustomerDetails[customerDetailsArray.length-1];
            for(int i=0, j=0; i<customerDetailsArray.length; i++){
                if(i!=index){
                    tempCusDetails[j]=customerDetailsArray[i];
                    j++;
                }
            }
            customerDetailsArray=tempCusDetails;
            return true;
        }
    }

    // View Customers
    public FashionShopCustomerDetails[] viewCustomer(){
        FashionShopCustomerDetails[] viewCustomers = new FashionShopCustomerDetails[customerDetailsArray.length];
        boolean[] equalPass = new boolean [customerDetailsArray.length];
        int count=0;

        for(int i=0; i<customerDetailsArray.length; i++){
            if(equalPass[i]){
                continue;
            }

            viewCustomers[count]=new FashionShopCustomerDetails();

            int tempQty = customerDetailsArray[i].getQuantity();
            double tempAmount=customerDetailsArray[i].getAmount();
            equalPass[i]=true;

            for(int j=i+1; j<customerDetailsArray.length; j++){
                if(customerDetailsArray[i].getPhoneNumber().equals(customerDetailsArray[j].getPhoneNumber())){
                    tempQty+=customerDetailsArray[i].getQuantity();
                    tempAmount+=customerDetailsArray[i].getAmount();
                    equalPass[j]=true;
                }
            }

            String cusPhoneNumber = customerDetailsArray[i].getPhoneNumber();
            viewCustomers[count].setViewCustomers(cusPhoneNumber, tempQty, tempAmount);
            count++;
        }
        return viewCustomers;
    }

    
    // Best In Customers Sorting Part
    public FashionShopCustomerDetails[] bestInCusSort(){
        FashionShopCustomerDetails[] viewBestCustomers = new FashionShopCustomerDetails[customerDetailsArray.length];
        boolean [] equalPass = new boolean[customerDetailsArray.length];
        int count=0;
        
        for(int i=0; i<customerDetailsArray.length; i++){
            if(equalPass[i]){
                continue;
            }

            viewBestCustomers[count]=new FashionShopCustomerDetails();

            int tempqty = customerDetailsArray[i].getQuantity();
            double tempAmount = customerDetailsArray[i].getAmount();
            equalPass[i]=true;

            for(int j=i+1; j<customerDetailsArray.length; j++){
                if(customerDetailsArray[i].getPhoneNumber().equals(customerDetailsArray[j].getPhoneNumber())){
                    tempqty+=customerDetailsArray[j].getQuantity();
                    tempAmount+=customerDetailsArray[j].getAmount();
                    equalPass[j]=true;
                }                
            }
            String customerPhoneNumber = customerDetailsArray[i].getPhoneNumber();

            viewBestCustomers[count].setBestInCustomers(customerPhoneNumber, tempqty, tempAmount);            
            count++;
        }
               
        // Sorting loop in best in customer....
        for(int i=count-1; i>0; i--){           
            for(int j=0; j<i; j++){    
                if(viewBestCustomers[j] != null && viewBestCustomers[j+1] != null){
                    if(viewBestCustomers[j].getQuantity()!=0 && viewBestCustomers[j+1].getQuantity()!=0){
                        if(viewBestCustomers[j].getAmount()<viewBestCustomers[j+1].getAmount()){                   
                            FashionShopCustomerDetails swap = viewBestCustomers[j];
                            viewBestCustomers[j]=viewBestCustomers[j+1];
                            viewBestCustomers[j+1]=swap;                    
                        }
                    }

                }              
            }
        }
        return viewBestCustomers;

    }

    // Change Order Status
    public int changeOrderStatus(String id){
        for(int i=0; i<customerDetailsArray.length; i++){
            if(id.equals(customerDetailsArray[i].getOrderId())){
                if(customerDetailsArray[i].getOrderStatus()==0){
                    return 0;
                }else if(customerDetailsArray[i].getOrderStatus()==1){
                    return 1;
                }else if(customerDetailsArray[i].getOrderStatus()==2){
                    return 2;
                }
            }            
        }
        return -1;        
    }

    public void setOrderStatus(int status){
        for(int i=0; i<customerDetailsArray.length; i++){
            if(status==1){
                customerDetailsArray[i].setOrderStatus(delivering);
            }else if(status==2){
                customerDetailsArray[i].setOrderStatus(delivered);
            }
        }
    }

    // All Customer
    public AllCustomers[] allCustomersReport(){
        AllCustomers[] allCustomerDetails = new AllCustomers[customerDetailsArray.length];
        
        for(int i=0; i<allCustomerDetails.length; i++){
            allCustomerDetails[i]=new AllCustomers();
        }

        boolean equalPass[] = new boolean[customerDetailsArray.length];
        for(int i=0; i<customerDetailsArray.length; i++){
            if(equalPass[i]){
                continue;
            }

            int tempMedium2=0;
            int tempXtraSmall2=0;
            int tempXtraXl2=0;
            int tempXtraLarge2=0;
            int tempSmall2=0;
            int tempLarge2=0;
            double tempAmount2=0;

            String customerPhoneNumber = customerDetailsArray[i].getPhoneNumber();
            
            allCustomerDetails[i].setPhoneNumber(customerPhoneNumber);

            if(customerDetailsArray[i].getSize().equals("M")){
                tempMedium2=customerDetailsArray[i].getQuantity();
                allCustomerDetails[i].setMedium(tempMedium2);

            }else if (customerDetailsArray[i].getSize().equals("XS")){
                tempXtraSmall2=customerDetailsArray[i].getQuantity();
                allCustomerDetails[i].setXtraSmall(tempXtraSmall2);

            }else if(customerDetailsArray[i].getSize().equals("XXL")){
                tempXtraXl2=customerDetailsArray[i].getQuantity();
                allCustomerDetails[i].setXtraXl(tempXtraXl2);

            }else if(customerDetailsArray[i].getSize().equals("XL")){
                tempXtraLarge2=customerDetailsArray[i].getQuantity();
                allCustomerDetails[i].setXtraLarge(tempXtraLarge2);

            }else if(customerDetailsArray[i].getSize().equals("S")){
                tempSmall2=customerDetailsArray[i].getQuantity();
                allCustomerDetails[i].setSmall(tempSmall2);

            }else if(customerDetailsArray[i].getSize().equals("L")){
                tempLarge2=customerDetailsArray[i].getQuantity();
                allCustomerDetails[i].setLarge(tempLarge2);
            }

            tempAmount2=customerDetailsArray[i].getAmount();  
            allCustomerDetails[i].setAmount(tempAmount2);           
            equalPass[i]=true;            
    
            for(int j=i+1; j<customerDetailsArray.length; j++){
                if(customerDetailsArray[i].getPhoneNumber().equals(customerDetailsArray[j].getPhoneNumber())){                                             
                allCustomerDetails[i].setPhoneNumber(customerPhoneNumber);

                if(customerDetailsArray[i].getSize().equals("M")){
                    tempMedium2=customerDetailsArray[i].getQuantity();
                    allCustomerDetails[i].setMedium(tempMedium2);    
                }else if (customerDetailsArray[i].getSize().equals("XS")){
                    tempXtraSmall2=customerDetailsArray[i].getQuantity();
                    allCustomerDetails[i].setXtraSmall(tempXtraSmall2);
                }else if(customerDetailsArray[i].getSize().equals("XXL")){
                    tempXtraXl2=customerDetailsArray[i].getQuantity();
                    allCustomerDetails[i].setXtraXl(tempXtraXl2);
                }else if(customerDetailsArray[i].getSize().equals("XL")){
                    tempXtraLarge2=customerDetailsArray[i].getQuantity();
                    allCustomerDetails[i].setXtraLarge(tempXtraLarge2);
                }else if(customerDetailsArray[i].getSize().equals("S")){
                    tempSmall2=customerDetailsArray[i].getQuantity();
                    allCustomerDetails[i].setSmall(tempSmall2);
                }else if(customerDetailsArray[i].getSize().equals("L")){
                    tempLarge2=customerDetailsArray[i].getQuantity();
                    allCustomerDetails[i].setLarge(tempLarge2);
                }
    
                tempAmount2=customerDetailsArray[i].getAmount();  
                allCustomerDetails[i].setAmount(tempAmount2);           
                equalPass[i]=true;            
                }                
            }           
        } 
        return allCustomerDetails; 

    }

    // Sorting by Quantity
    public Sorting[] sortByQty(){
        Sorting [] sortingByQuantity = new Sorting[6];
        for(int i=0; i<sortingByQuantity.length; i++){
            sortingByQuantity[i]=new Sorting();
        }

        sortingByQuantity[0].setSize("M");
        sortingByQuantity[1].setSize("Xl");
        sortingByQuantity[2].setSize("XS");
        sortingByQuantity[3].setSize("S");
        sortingByQuantity[4].setSize("XXL");
        sortingByQuantity[5].setSize("L");

        int tempM4=0;
        int tempXs4=0;
        int tempXtraXl4=0;
        int tempXLarge4=0;
        int tempSmall4=0;
        int tempLarge4=0;

        int mtotal=0;
        int xstotal=0;
        int xtraxltotal=0;
        int xlargetotal=0;
        int smalltotal=0;
        int largetotal=0;

        sortingByQuantity[0].setQuantity(0);
        sortingByQuantity[1].setQuantity(0);
        sortingByQuantity[2].setQuantity(0);
        sortingByQuantity[3].setQuantity(0);
        sortingByQuantity[4].setQuantity(0);
        sortingByQuantity[5].setQuantity(0);

        for(int i=0; i<customerDetailsArray.length; i++){
            if(customerDetailsArray[i].getSize().equals("M")){
                tempM4+=customerDetailsArray[i].getQuantity();
                sortingByQuantity[0].setQuantity(tempM4);

            }else if (customerDetailsArray[i].getSize().equals("XL")){
                tempXLarge4+=customerDetailsArray[i].getQuantity();
                sortingByQuantity[1].setQuantity(tempXLarge4);

            }else if(customerDetailsArray[i].getSize().equals("XS")){
                tempXs4+=customerDetailsArray[i].getQuantity();
                sortingByQuantity[2].setQuantity(tempXs4);

            }else if(customerDetailsArray[i].getSize().equals("S")){
                tempSmall4+=customerDetailsArray[i].getQuantity();
                sortingByQuantity[3].setQuantity(tempSmall4);

            }else if(customerDetailsArray[i].getSize().equals("XXL")){
                tempXtraXl4+=customerDetailsArray[i].getQuantity();
                sortingByQuantity[4].setQuantity(tempXtraXl4);

            }else if(customerDetailsArray[i].getSize().equals("L")){
                tempLarge4+=customerDetailsArray[i].getQuantity();
                sortingByQuantity[5].setQuantity(tempLarge4);
            }

            mtotal=tempM4*900;
            xlargetotal=tempXLarge4*1100;
            xstotal=tempXs4*600;
            smalltotal=tempSmall4*800;
            xtraxltotal=tempXtraXl4*1200;           
            largetotal=tempLarge4*1000;

            sortingByQuantity[0].setAmount((double)mtotal);
            sortingByQuantity[1].setAmount((double)xlargetotal);
            sortingByQuantity[2].setAmount((double)xstotal);
            sortingByQuantity[3].setAmount((double)smalltotal);
            sortingByQuantity[4].setAmount((double)xtraxltotal);
            sortingByQuantity[5].setAmount((double)largetotal);
          
        }
        // sorting part for quantity
        for(int i=5; i>0; i--){
            for(int j=0; j<i; j++){
                if(sortingByQuantity[j].getQuantity()<sortingByQuantity[j+1].getQuantity()){
                    Sorting swap = sortingByQuantity[j];
                    sortingByQuantity[j]=sortingByQuantity[j+1];
                    sortingByQuantity[j+1]=swap;
                }
            }
        }
        return sortingByQuantity;
    }

    //Sorting by Amount
    public Sorting[] sortByAmount(){
        Sorting [] sortByAmount = new Sorting[6];
        for(int i=0; i<sortByAmount.length; i++){
            sortByAmount[i]=new Sorting();
        }

        sortByAmount[0].setSize("M");
        sortByAmount[1].setSize("XL");
        sortByAmount[2].setSize("XS");
        sortByAmount[3].setSize("S");
        sortByAmount[4].setSize("XXL");
        sortByAmount[5].setSize("L");

        int tempM4=0;
        int tempXs4=0;
        int tempXtraXl4=0;
        int tempXLarge4=0;
        int tempSmall4=0;
        int tempLarge4=0;

        int mtotal=0;
        int xstotal=0;
        int xtraxltotal=0;
        int xlargetotal=0;
        int smalltotal=0;
        int largetotal=0;

        sortByAmount[0].setQuantity(0);
        sortByAmount[1].setQuantity(0);
        sortByAmount[2].setQuantity(0);
        sortByAmount[3].setQuantity(0);
        sortByAmount[4].setQuantity(0);
        sortByAmount[5].setQuantity(0);

        for(int i=0; i<customerDetailsArray.length; i++){
            if(customerDetailsArray[i].getSize().equals("M")){
                tempM4+=customerDetailsArray[i].getQuantity();
                sortByAmount[0].setQuantity(tempM4);
            }else if (customerDetailsArray[i].getSize().equals("XL")){
                tempXLarge4+=customerDetailsArray[i].getQuantity();
                sortByAmount[1].setQuantity(tempXLarge4);
            }else if(customerDetailsArray[i].getSize().equals("XS")){
                tempXs4+=customerDetailsArray[i].getQuantity();
                sortByAmount[2].setQuantity(tempXs4);
            }else if(customerDetailsArray[i].getSize().equals("S")){
                tempSmall4+=customerDetailsArray[i].getQuantity();
                sortByAmount[3].setQuantity(tempSmall4);
            }else if(customerDetailsArray[i].getSize().equals("XXL")){
                tempXtraXl4+=customerDetailsArray[i].getQuantity();
                sortByAmount[4].setQuantity(tempXtraXl4);
            }else if(customerDetailsArray[i].getSize().equals("L")){
                tempLarge4+=customerDetailsArray[i].getQuantity();
                sortByAmount[5].setQuantity(tempLarge4);
            }

            mtotal=tempM4*900;
            xlargetotal=tempXLarge4*1100;
            xstotal=tempXs4*600;
            smalltotal=tempSmall4*800;
            xtraxltotal=tempXtraXl4*1200;           
            largetotal=tempLarge4*1000;

            sortByAmount[0].setAmount((double)mtotal);
            sortByAmount[1].setAmount((double)xlargetotal);
            sortByAmount[2].setAmount((double)xstotal);
            sortByAmount[3].setAmount((double)smalltotal);
            sortByAmount[4].setAmount((double)xtraxltotal);
            sortByAmount[5].setAmount((double)largetotal);
          
        }
        for(int i=5; i>0; i--){           
            for(int j=0; j<i; j++){              
                if(sortByAmount[j].getAmount()<sortByAmount[j+1].getAmount()){                   
                        Sorting swap = sortByAmount[j];
                        sortByAmount[j]=sortByAmount[j+1];
                        sortByAmount[j+1]=swap;                    
                }           
            }
        }
        return sortByAmount;
    }

    //get Object by print the view all orders
    public FashionShopCustomerDetails[] getObject(){
        FashionShopCustomerDetails[] tempArray = new FashionShopCustomerDetails[customerDetailsArray.length];
        for(int i=0; i<customerDetailsArray.length; i++){
            tempArray[i]=customerDetailsArray[i];            
        }
        return tempArray;
    }

    // Orders by Amount all orders print
    public FashionShopCustomerDetails[] allOrdersByAmount(){
        FashionShopCustomerDetails[] sortingByAmount = new FashionShopCustomerDetails[customerDetailsArray.length];
        for(int i=0; i<customerDetailsArray.length; i++){
            sortingByAmount[i]=customerDetailsArray[i];
        }        

        for(int i=customerDetailsArray.length-1; i>0; i--){
            for(int j=0; j<i; j++)
            if(sortingByAmount[j].getAmount()<sortingByAmount[j+1].getAmount()){
                FashionShopCustomerDetails swap=customerDetailsArray[j];
                sortingByAmount[j]=sortingByAmount[j+1];
                sortingByAmount[j+1]=swap;
            }
        }
        return sortingByAmount;

    }  
    
}
