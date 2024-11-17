class List{
    private Node start;

    // add method
    public boolean add(FashionShopCustomerDetails customerDetails){
        if(isEmpty()){
            return addFirst(customerDetails);
        }else{
            return addLast(customerDetails);
        }
    }

    // addFirst
    public boolean addFirst(FashionShopCustomerDetails customerDetails){
        Node n1 = new Node(customerDetails);
        n1.next=start;
        start=n1;
        return true;
    }

    // add last
    public boolean addLast(FashionShopCustomerDetails customerDetails){
        Node n1 = new Node(customerDetails);
        Node lastNode  = start;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
        }
        lastNode.next=n1;
        return true;
    }

    //add on index
    public boolean add(int index,FashionShopCustomerDetails customerDetails){
        if(isEmpty()){
            return addFirst(customerDetails);
        }else{
            Node n1 = new Node(customerDetails);
            Node temp = start;
            int count=0;
            while(count<index-1){
                temp=temp.next;
                count++;
            }
            n1.next=temp.next;
            temp.next=n1;
            return true;

        }
    }

    // isempty
    public boolean isEmpty(){
        return start==null;
    }

    //size
    public int size(){
        Node temp=start;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }












    // inner class Node
    class Node{
        private FashionShopCustomerDetails customerDetails;
        private Node next;

        Node(FashionShopCustomerDetails customerDetails){
            this.customerDetails=customerDetails;
        }
    }


}