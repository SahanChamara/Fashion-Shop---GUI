import java.io.*;
class CustomerController {
    
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

    // place order file writing
    public static boolean addCustomer(FashionShopCustomerDetails c1) throws IOException{
        FileWriter fw = new FileWriter("CustomerDetails.txt",true);
        fw.write(c1.toString()+"\n");
        fw.close();
        return true;
    }

    // generating order id
    public static String generateOrderId() throws IOException{
        String lastLine = null;
        BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
        String line = br.readLine();
        while(line!=null){
            lastLine=line;
            line=br.readLine();
        }
        br.close();

        if(lastLine==null){
            return "ODR#00001";
        }else{
            int orderId = Integer.parseInt(lastLine.substring(4,9));
            return String.format("ODR#%05d",orderId+1);
        }
    }

    // search customer
    public void searchCustomer(String cusPhoneNumber)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
        String line=br.readLine();
        boolean isExist = false;
        while(line!=null){
            String cusId = line.substring(10,20);
            if(cusId.equalsIgnoreCase(cusPhoneNumber)){
                isExist=true;
                numbervalid=true;
                break;
            }
            line=br.readLine();
        }
        br.close();
        if(isExist){            
            String[] cusDetails = line.split(",");
            //FashionShopCustomerDetails c1 = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),cusDetails[5]);
            searchCustomerId(cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]));
           
        }
    }


    // serarch by custoemer id...................
    public void searchCustomerId(String cusEnterPhonenum, String cusSize, int qty) {
        // numbervalid = true;
        // System.out.println(numbervalid);

        if (cusSize.equals("M")) {
            tempMedium += qty;
        } else if (cusSize.equals("XS")) {
            tempXtraSmall += qty;
        } else if (cusSize.equals("XXL")) {
            tempXtraXl += qty;
        } else if (cusSize.equals("XL")) {
            tempXtraLarge += qty;
        } else if (cusSize.equals("S")) {
            tempSmall += qty;
        } else if (cusSize.equals("L")) {
            tempLarge += qty;
        }
        tempAmountCalculation();

    }

    public boolean getNumberValid() {
        // System.out.println("return wena number valid eka "+numbervalid);
        return this.numbervalid;
    }

    public void tempAmountCalculation() {
        mediumAmount = tempMedium * 900;
        xtraLargeAmount = tempXtraLarge * 1100;
        xtraxXlAmount = tempXtraXl * 1200;
        xtraSmallAmount = tempXtraSmall * 600;
        smallAmount = tempSmall * 800;
        largeAmount = tempLarge * 1000;
        searchTotalAmount = mediumAmount + xtraLargeAmount + xtraxXlAmount + xtraSmallAmount + smallAmount
                + largeAmount;
    }

    public int getMedium() {
        return this.tempMedium;
    }

    public int getXtraSmall() {
        return this.tempXtraSmall;
    }

    public int getXtraXl() {
        return this.tempXtraXl;
    }

    public int getXtraLarge() {
        return this.tempXtraLarge;
    }

    public int getSmall() {
        return this.tempSmall;
    }

    public int getLarge() {
        return this.tempLarge;
    }

    // amount getters
    public double getMediumAmount() {
        return this.mediumAmount;
    }

    public double getXtraLargeAmount() {
        return this.xtraLargeAmount;
    }

    public double getXtraXlAmount() {
        return this.xtraxXlAmount;
    }

    public double getXtraSmallAmount() {
        return this.xtraSmallAmount;
    }

    public double getSmallAmount() {
        return this.smallAmount;
    }

    public double getLargeAmount() {
        return this.largeAmount;
    }

    public double getSearchTotalAmount() {
        return this.searchTotalAmount;
    }

    public void tempCountUpdate() {
        this.tempMedium = 0;
        this.tempXtraLarge = 0;
        this.tempXtraXl = 0;
        this.tempXtraSmall = 0;
        this.tempSmall = 0;
        this.tempLarge = 0;
    }

    //Search by order id
    public static FashionShopCustomerDetails searchOrderId(String orderId) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.txt"));
        String line=br.readLine();
        boolean isExist=false;
        while(line!=null){
            String id = line.substring(0,9);
            if(orderId.equalsIgnoreCase(id)){
                isExist=true;
                break;
            }
            line=br.readLine();
        }
        br.close();
        
        if(isExist){
            String[] cusDetails = line.split(",");
            FashionShopCustomerDetails cus = new FashionShopCustomerDetails(cusDetails[0],cusDetails[1],cusDetails[2],Integer.parseInt(cusDetails[3]),Double.parseDouble(cusDetails[4]),cusDetails[5]);
            return cus;
        }else{
            return null;
        }
    }
    
}
