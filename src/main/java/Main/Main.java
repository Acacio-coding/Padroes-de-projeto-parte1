package Main;

import ChainOfResponsibility.DB1;
import ChainOfResponsibility.DB2;
import ChainOfResponsibility.SupportTicket;
import ChainOfResponsibility.SupportTicketFinder;
import Composite.CompositeRoute;
import Composite.Freight;
import Composite.FreightRoute;
import Composite.UniqueRoute;
import HookMethod.Hardware;
import HookMethod.Software;
import NullObject.AbstractProductCategory;
import NullObject.ProductCategoryDAO;
import Observer.Customer;
import Observer.FreightUpdateService;
import StatePattern.Cart;
import Strategy.Credit;
import Strategy.Debt;
import Strategy.PayPurchase;
import Strategy.Purchase;

public class Main {
    public static void main(String[] args) {
        //Null object
        AbstractProductCategory category1 = ProductCategoryDAO.getCategory("Software");
        AbstractProductCategory category2 = ProductCategoryDAO.getCategory("Hardware");
        AbstractProductCategory category3 = ProductCategoryDAO.getCategory("Games");

        System.out.println("-----------------------------------------------------");
        System.out.println("Categories:");
        System.out.println("-----------------------------------------------------");
        System.out.println(category1.getName());
        System.out.println(category2.getName());
        System.out.println(category3.getName());
        System.out.println("-----------------------------------------------------");

        //Hook Method
        Software software1 =  new Software(0, "Antivirus", 250.00, category1);
        Hardware hardware1 = new Hardware(0, "Motherboard", 430.00, category2);

        System.out.println("\n-----------------------------------------------------");
        System.out.println("Products:");
        System.out.println("-----------------------------------------------------");
        System.out.println("Category:" + software1.getCategory());
        System.out.println("Product:" + software1.getName());
        System.out.println("Price:" + software1.totalPrice());
        System.out.println("-----------------------------------------------------");
        System.out.println("Category:" + hardware1.getCategory());
        System.out.println("Product:" + hardware1.getName());
        System.out.println("Price:" + hardware1.totalPrice());
        System.out.println("-----------------------------------------------------");

        //State pattern
        Cart cart = new Cart();

        System.out.println("\n-----------------------------------------------------");
        System.out.println("Shopping cart:");
        System.out.println("-----------------------------------------------------");
        cart.listProducts();
        System.out.println("-----------------------------------------------------");
        cart.clear();
        System.out.println("-----------------------------------------------------");
        cart.fill(software1);
        System.out.println("-----------------------------------------------------");
        cart.fill(hardware1);
        System.out.println("-----------------------------------------------------");
        cart.listProducts();
        System.out.println("-----------------------------------------------------");
        cart.clear();
        System.out.println("-----------------------------------------------------");
        cart.listProducts();
        System.out.println("-----------------------------------------------------");
        cart.fill(software1);
        System.out.println("-----------------------------------------------------");
        cart.listProducts();
        System.out.println("-----------------------------------------------------");

        //Composite
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Payment:");
        System.out.println("-----------------------------------------------------");

        FreightRoute route1 = new UniqueRoute("São Paulo", "Joinville");
        FreightRoute route2 = new UniqueRoute("Joinville", "São José");
        FreightRoute route3 = new UniqueRoute("São José", "Canoinhas");
        FreightRoute route4 = new UniqueRoute("Canoinhas", "Três Barras");

        FreightRoute route5 = new CompositeRoute(route1, route2);
        FreightRoute route6 = new CompositeRoute(route3, route4);
        FreightRoute routeFinal = new CompositeRoute(route5, route6);

        Freight freight = new Freight(50, routeFinal);

        System.out.println("Fright price: " + freight.getPrice());
        System.out.println("-----------------------------------------------------");
        System.out.println("Routes forecast:");
        System.out.println("-----------------------------------------------------");
        System.out.println(freight.getRoute());
        System.out.println("-----------------------------------------------------");

        //Strategy
        Purchase purchase = new Purchase(0, cart, freight);
        PayPurchase method1 = new PayPurchase(purchase, new Credit(1.15));
        PayPurchase method2 = new PayPurchase(purchase, new Debt(15));

        System.out.println("Total with credit: " + method1.realizePayment());
        System.out.println("-----------------------------------------------------");
        System.out.println("Total with debt: " + method2.realizePayment());
        System.out.println("-----------------------------------------------------");

        //Observer
        Customer customer1 = new Customer(0, "Teste");
        FreightUpdateService fus = new FreightUpdateService(purchase, customer1);

        System.out.println("\n-----------------------------------------------------");
        System.out.println("Purchase notification area:");
        System.out.println("-----------------------------------------------------");
        fus.update("\nLeft for delivery to addressee.");
        System.out.println("-----------------------------------------------------");

        //Chain of Responsibility
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Support area:");
        System.out.println("-----------------------------------------------------");
        try {
            SupportTicketFinder finder = new DB1(new DB2(null, customer1), customer1);

            SupportTicket first = finder.find(0);
            System.out.println("TicketID: " + first.getId());
            System.out.println("Description: " + first.getDescription() );
            System.out.println("Customer: " + first.getCostumer().getName());
            System.out.println("-----------------------------------------------------");

            SupportTicket second = finder.find(1);
            System.out.println("TicketID: " + second.getId());
            System.out.println("Description: " + second.getDescription() );
            System.out.println("Customer: " + second.getCostumer().getName());
            System.out.println("-----------------------------------------------------");

            SupportTicket third = finder.find(2);
            System.out.println("TicketID: " + third.getId());
            System.out.println("Description: " + third.getDescription() );
            System.out.println("Customer: " + third.getCostumer().getName());
            System.out.println("-----------------------------------------------------");
        }catch (RuntimeException error) {
            System.out.println(error.getMessage());
            System.out.println("-----------------------------------------------------");
        }
    }
}
