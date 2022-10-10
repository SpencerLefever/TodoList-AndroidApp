/**
 * Spencer Lefever
 * COSC330 Lab 3 Ticket Sales
 * 
 * Testing class
 */


public class ticketSalesTest { 
    public static void main(String[] args) {
        
        /**
         * Array of Sale orders
         * Indexes as follows
         * for sales and tax type
         * 
         *      ADU   CHI   SEN
         * US    0     1     2
         * CAN   3     4     5
         * GER   6     7     8
         */
        
         //Initizalize different taxes
         SaleTax usTax = new USTax();
         SaleTax canadaTax = new CanadaTax();
         SaleTax germanyTax = new GermanyTax();

         //Initialize different prices
         TicketPrice adultPrice = new AdultPrice();
         TicketPrice childPrice = new ChildPrice();
         TicketPrice seniorPrice = new SeniorPrice();

         //Define sale order array to hold all sale orders
         SaleOrder saleOrderArr[] = new SaleOrder[9];

         //Create adult, senior and child prices with US Tax
         SaleOrder usAdultOrder = new SaleOrder(adultPrice, usTax);
         SaleOrder usChildOrder = new SaleOrder(childPrice, usTax);
         SaleOrder usSeniorOrder = new SaleOrder(seniorPrice, usTax);

         //Set values in array to values initialized
         saleOrderArr[0] = usAdultOrder;
         saleOrderArr[1] = usChildOrder;
         saleOrderArr[2] = usSeniorOrder;

         //Create adult, senior and child prices with Canada Tax
         SaleOrder canadaAdultOrder = new SaleOrder(adultPrice, canadaTax);
         SaleOrder canadaChildOrder = new SaleOrder(childPrice, canadaTax);
         SaleOrder canadaSeniorOrder = new SaleOrder(seniorPrice, canadaTax);

         //Set values in array to initialized values
         saleOrderArr[3] = canadaAdultOrder;
         saleOrderArr[4] = canadaChildOrder;
         saleOrderArr[5] = canadaSeniorOrder;

         //Create adult, senior and child prices with Germany tax
         SaleOrder germanyAdultOrder = new SaleOrder(adultPrice, germanyTax);
         SaleOrder germanyChildOrder = new SaleOrder(childPrice, germanyTax);
         SaleOrder germanySeniorOrder = new SaleOrder(seniorPrice, germanyTax);

         //Set values in array to initialized values
         saleOrderArr[6] = germanyAdultOrder;
         saleOrderArr[7] = germanyChildOrder;
         saleOrderArr[8] = germanySeniorOrder;

         System.out.println("\tAdult\tChild\tSenior");
         //Print US tax output using calcPrice method
         System.out.print("US\t");
         //Call calcPrice Method on US orders
         for(int i=0; i<=2; i++) {
            System.out.print(saleOrderArr[i].calcPrice() + "\t");
         }        
         System.out.print("\n");

         System.out.print("Canada\t");
         //Call calcPrice Method on Canada orders
         for(int i=3; i<=5; i++) {
            System.out.print(saleOrderArr[i].calcPrice() + "\t");
         }      
         System.out.print("\n");

         System.out.print("Germany\t");
         //Call calcPrice Method on Germany orders
         for(int i=6; i<=8; i++) {
            System.out.print(saleOrderArr[i].calcPrice() + "\t");
         }      
         System.out.print("\n");

    } 
}