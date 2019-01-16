package coffeeandtacos;

public interface ILog {
    void logInfo(String log, Exception e);
    void logInfo(String log);
    
    void logWarning(String log, Exception e);
    void logWarning(String log);
    
    void logSevere(String log, Exception e);
    void logSevere(String log);
}
