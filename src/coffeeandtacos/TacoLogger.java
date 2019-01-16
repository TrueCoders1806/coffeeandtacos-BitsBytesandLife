package coffeeandtacos;

import java.util.logging.*;

public class TacoLogger implements ILog {

    @Override
    public void logInfo(String log, Exception e) {
        Logger.getLogger(CoffeeAndTacos.class.getName()).log(Level.INFO, log, e);
    }

    @Override
    public void logInfo(String log) {
        Logger.getLogger(CoffeeAndTacos.class.getName()).log(Level.INFO, log);
    }

    @Override
    public void logWarning(String log, Exception e) {
        Logger.getLogger(CoffeeAndTacos.class.getName()).log(Level.WARNING, log, e);
    }

    @Override
    public void logWarning(String log) {
        Logger.getLogger(CoffeeAndTacos.class.getName()).log(Level.WARNING, log);
    }

    @Override
    public void logSevere(String log, Exception e) {
        Logger.getLogger(CoffeeAndTacos.class.getName()).log(Level.SEVERE, log, e);
    }

    @Override
    public void logSevere(String log) {
        Logger.getLogger(CoffeeAndTacos.class.getName()).log(Level.SEVERE, log);
    }
    
}
