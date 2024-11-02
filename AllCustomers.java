class AllCustomers{
    private String customerPhoneNumber;
    private int medium;
    private int xtraSamll;
    private int xtraXl;
    private int xtraLarge;
    private int small;
    private int large;
    private double amount;

    AllCustomers(){

    }

    AllCustomers(String customerPhoneNumber,int medium,int xtraSamll,int xtraXl,int xtraLarge,int small,int large,double amount){
        this.customerPhoneNumber=customerPhoneNumber;
        this.medium=medium;
        this.xtraSamll=xtraSamll;
        this.xtraXl=xtraXl;
        this.xtraLarge=xtraLarge;
        this.small=small;
        this.large=large;
        this.amount=amount;
    }

    // set phone number
    public void setPhoneNumber(String customerPhoneNumber){
        this.customerPhoneNumber=customerPhoneNumber;
    }

    // get phone number
    public String getPhoneNumber(){
        return this.customerPhoneNumber;
    }

    // set medium size
    public void setMedium(int medium){
        this.medium=medium;
    }

    // get Medium size
    public int getMediumSize(){
        return this.medium;
    }

    // set Xtra Small
    public void setXtraSmall(int xtraSamll){
        this.xtraSamll=xtraSamll;
    }

    // get Xtra XL
    public int getXtraSamll(){
        return this.xtraSamll;
    }

    // set XtraXl
    public void setXtraXl(int xtraXl){
        this.xtraXl=xtraXl;
    }

    // Get XtraXl
    public int getXtraXl(){
        return this.xtraXl;
    }

    // set Xtra Large
    public void setXtraLarge(int xtraLarge){
        this.xtraLarge=xtraLarge;
    }

    // get Xtra Large
    public int getXtraLarge(){
        return this.xtraLarge;
    }

    // set Small
    public void setSmall(int small){
        this.small=small;
    }

    // get small
    public int getSmall(){
        return this.small;
    }

    // set Large
    public void setLarge(int large){
        this.large=large;
    }

    // get large
    public int getLarge(){
        return this.large;
    }

    // set Amount
    public void setAmount(double amount){
        this.amount=amount;
    }

    // get amount
    public double getAmount(){
        return this.amount;
    }
}