class List {
    private FashionShopCustomerDetails[] cusDetailsArray;
    private int nextIndex;
    private double loadFact;
    private int initSize;

    private final int processing = 0;
    private final int delivering = 1;
    private final int delivered = 2;

    List(int initSize, double loadFact) {
        this.initSize = initSize;
        this.loadFact = loadFact;
        nextIndex = 0;

        cusDetailsArray = new FashionShopCustomerDetails[initSize];
    }

    

    // Change Order Status
    // public int changeOrderStatus(String id) {
    //     for (int i = 0; i < size(); i++) {
    //         if (id.equalsIgnoreCase(cusDetailsArray[i].getOrderId())) {
    //             if (cusDetailsArray[i].getOrderStatus() == 0) {
    //                 return 0;
    //             } else if (cusDetailsArray[i].getOrderStatus() == 1) {
    //                 return 1;
    //             } else if (cusDetailsArray[i].getOrderStatus() == 2) {
    //                 return 2;
    //             }
    //         }
    //     }
    //     return -1;
    // }

    // public void setOrderStatus(int status, String orderId) {
    //     for (int i = 0; i < size(); i++) {
    //         if (orderId.equals(cusDetailsArray[i].getOrderId())) {
    //             if (status == 1) {
    //                 cusDetailsArray[i].setOrderStatus(delivering);
    //                 break;
    //             } else if (status == 2) {
    //                 cusDetailsArray[i].setOrderStatus(delivered);
    //                 break;
    //             }
    //         }

    //     }
    // }

   

    // customer details add
    public boolean add(FashionShopCustomerDetails customerDetails) {
        if (nextIndex >= cusDetailsArray.length) {
            extendArray();
        }
        cusDetailsArray[nextIndex] = customerDetails;
        nextIndex++;
        return true;
    }

    // extend array
    private void extendArray() {
        FashionShopCustomerDetails[] tempCusDetails = new FashionShopCustomerDetails[cusDetailsArray.length
                + (int) (cusDetailsArray.length * loadFact)];
        for (int i = 0; i < cusDetailsArray.length; i++) {
            tempCusDetails[i] = cusDetailsArray[i];
        }
        cusDetailsArray = tempCusDetails;
    }

    // search method
    public int search(FashionShopCustomerDetails cusDetails) {
        for (int i = 0; i < nextIndex; i++) {
            if (cusDetailsArray[i].equals(cusDetails)) {
                return i;
            }
        }
        return -1;
    }

    // remove method
    public boolean remove(int index) {
        if (isValidIndex(index)) {
            for (int i = index; i < nextIndex - 1; i++) {
                cusDetailsArray[i] = cusDetailsArray[i + 1];
            }
            nextIndex--;
            return true;
        }
        return false;
    }

    // is empty
    public boolean isEmpty() {
        return nextIndex <= 0;
    }

    // Size Method
    public int size() {
        return nextIndex;
    }

    // Capacity Method
    public int capacity() {
        return cusDetailsArray.length;
    }

    // get method
    public FashionShopCustomerDetails get(int index) {
        return cusDetailsArray[index];
    }

    // set Method
    public void set(int index, FashionShopCustomerDetails cusDetails) {
        cusDetailsArray[index] = cusDetails;
    }

    // valid index check
    public boolean isValidIndex(int index) {
        return index < nextIndex && index >= 0;
    }

    // i write method
    public FashionShopCustomerDetails[] getArrayObject(){
        return cusDetailsArray;
    }
}


