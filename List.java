class List {
    private Node start;

    // add method
    public boolean add(FashionShopCustomerDetails customerDetails) {
        if (isEmpty()) {
            return addFirst(customerDetails);
        } else {
            return addLast(customerDetails);
        }
    }

    // addFirst
    public boolean addFirst(FashionShopCustomerDetails customerDetails) {
        Node n1 = new Node(customerDetails);
        n1.next = start;
        start = n1;
        return true;
    }

    // add last
    public boolean addLast(FashionShopCustomerDetails customerDetails) {
        Node n1 = new Node(customerDetails);
        Node lastNode = start;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = n1;
        return true;
    }

    // add on index
    public boolean add(int index, FashionShopCustomerDetails customerDetails) {
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                return addFirst(customerDetails);
            } else {
                Node n1 = new Node(customerDetails);
                Node temp = start;
                int count = 0;
                while (count < index - 1) {
                    temp = temp.next;
                    count++;
                }
                n1.next = temp.next;
                temp.next = n1;
                return true;
            }
        }
        return false;
    }

    // get customer object
    public FashionShopCustomerDetails get(int index){
        if(index>=0 && index<size()){            
            int count=0;
            Node temp = start;
            while(count<index){
                temp=temp.next;
                count++;
            }
            return temp.customerDetails;
        }
        return null;
    }

    //remove first
    public FashionShopCustomerDetails removeFirst(){
        FashionShopCustomerDetails c1 = start.customerDetails;
        start=start.next;
        return c1;
    }

    // removeLast
    public FashionShopCustomerDetails removeLast(){
        if(isEmpty()){
            return null;
        }
        if(start.next==null){
            FashionShopCustomerDetails c1 = start.customerDetails;
            start=null;
            return c1;
        }
        Node temp = start;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        FashionShopCustomerDetails cus = temp.next.customerDetails;
        temp.next=null;
        return cus;
    }

    // remove an index
    public FashionShopCustomerDetails remove(int index){
        if(index>=0 && index<size()){
            if(index==0){
                FashionShopCustomerDetails c1 = start.customerDetails;
                removeFirst();
                return c1;
            }
            Node temp = start;
            int count=0;
            while(count<index-1){
                temp=temp.next;
                count++;
            }
            FashionShopCustomerDetails cus = temp.next.customerDetails;
            temp.next=temp.next.next;
            return cus;
        }
        return null;
    }

    public boolean remove(FashionShopCustomerDetails customerDetails){
        int index=search(customerDetails);
        return remove(index)!=null;
    }

    // set objectss
    public boolean set(int index,FashionShopCustomerDetails customerDetails){
        if(index>=0 && index<size()){
            Node temp = start;
            int count=0;
            while(count<index){
                count++;
                temp=temp.next;
            }
            temp.customerDetails=customerDetails;
            return true;
        }
        return false;
    }

    // contain method
    public boolean contains(FashionShopCustomerDetails customerDetails){
        return search(customerDetails)!=-1;
    }

    //clear
    public void clear(){
        start=null;
    }

    //search objects
    public int search(FashionShopCustomerDetails customerDetails){
        Node temp = start;
        int index=0;
        while(temp!=null){
            if(temp.customerDetails.equals(customerDetails)){
                return index;
            }
            index++;
            temp=temp.next;
        }
        return -1;
    }

    // isempty
    public boolean isEmpty() {
        return start == null;
    }

    // size
    public int size() {
        Node temp = start;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //printList
    public void printList(){
        System.out.println(toString());
    }

    // to String
    public String toString(){
        String list="{";
        Node temp = start;
        while(temp!=null){
            list+=temp.customerDetails.toString()+" - ";
        }
        return isEmpty()? "[Empty]":list+"\b\b}";
    }

    // inner class Node ========================================
    class Node {
        private FashionShopCustomerDetails customerDetails;
        private Node next;

        Node(FashionShopCustomerDetails customerDetails) {
            this.customerDetails = customerDetails;
        }
    }

    public FashionShopCustomerDetails[] toArray(){
        FashionShopCustomerDetails[] tempCusDetailsArray = new FashionShopCustomerDetails[size()];
        Node temp = start;
        for(int i=0; i<tempCusDetailsArray.length; i++){
            tempCusDetailsArray[i]=temp.customerDetails;
            temp=temp.next;
        }
        return tempCusDetailsArray;
    }

}