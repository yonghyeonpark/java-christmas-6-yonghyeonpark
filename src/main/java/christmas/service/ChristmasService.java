package christmas.service;

public class ChristmasService {
    
    public boolean isEventApplication(int totalOrderAmount) {
        if (totalOrderAmount >= 10000) {
            return true;
        }
        return false;
    }
}
