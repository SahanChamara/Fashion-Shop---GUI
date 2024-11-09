class List {
    private FashionShopCustomerDetails[]  cusDetailsArray;
    private int nextIndex;
    private double loadFact;
    private int initSize;

    List(int initSize , double loadFact){
        this.initSize=initSize;
        this.loadFact=loadFact;
        nextIndex=0;

        cusDetailsArray = new FashionShopCustomerDetails[initSize];
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


    
    
    
}
