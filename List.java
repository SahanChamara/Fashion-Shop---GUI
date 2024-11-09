class List {
    private FashionShopCustomerDetails[]  cusDetailsArray;
    private int nextIndex;
    private double loadFact;
    private int initSize;

    // CustomerDetails variables
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

    List(int initSize , double loadFact){
        this.initSize=initSize;
        this.loadFact=loadFact;
        nextIndex=0;

        cusDetailsArray = new FashionShopCustomerDetails[initSize];
    }

    // Details Validation Part

    // Phone Number Validation
    public boolean phoneNumber(String phoneNumber){
        if(phoneNumber.length()!=10 || phoneNumber.charAt(0)!='0'){
            return false;
        }
        return true;
    }

    //T-Shirt Size Validatiob
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



    // customer details add 
    public boolean add(FashionShopCustomerDetails customerDetails){
        if(nextIndex>=cusDetailsArray.length){
            extendArray();
        }
        cusDetailsArray[nextIndex]=customerDetails;
        nextIndex++;
        return true;
    }

    // extend array
    private void extendArray(){
        FashionShopCustomerDetails[] tempCusDetails = new FashionShopCustomerDetails[cusDetailsArray.length+(int)(cusDetailsArray.length*loadFact)];
        for(int i=0; i<cusDetailsArray.length; i++){
            tempCusDetails[i]=cusDetailsArray[i];
        }
        cusDetailsArray=tempCusDetails;
    }

    //search method
    public int search(FashionShopCustomerDetails cusDetails){
        for(int i=0; i<nextIndex; i++){
            if(cusDetailsArray[i].equals(cusDetails)){
                return i;
            }
        }
        return -1;
    }

    // remove method
    public boolean remove(int index){
        if(isValidIndex(index)){
            for(int i=index; i<nextIndex-1; i++){
                cusDetailsArray[i]=cusDetailsArray[i+1];
            }
            nextIndex--;
            return true;
        }
        return false;
    }

    // is empty
    public boolean isEmpty(){
        return nextIndex<=0;
    }

    // Size Method
    public int size(){
        return nextIndex;
    }

    //Capacity Method
    public int capacity(){
        return cusDetailsArray.length;
    }

    // get method
    public FashionShopCustomerDetails get(int index){
        return cusDetailsArray[index];
    }

    // set Method
    public void set(int index,FashionShopCustomerDetails cusDetails){
        cusDetailsArray[index]=cusDetails;
    }

    // valid index check
    public boolean isValidIndex(int index){
        return index<nextIndex && index>=0;
    }



    
    
    
}
