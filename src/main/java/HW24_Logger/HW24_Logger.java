package HW24_Logger;


import org.apache.log4j.Logger;


public class HW24_Logger {

    private static final Logger log = Logger.getLogger(HW24_Logger.class);

    public void goToTheShop() {
        System.out.println("Необходимо купить продукты");
        log.info("Это информационное сообщение!");
        log.warn("Необходимо взять с собой деньги, но денег может не быть");
        takeMoney();
    }

    private void takeMoney() {
        log.error("денег нет");
    }
}
