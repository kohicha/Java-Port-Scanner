package PortScan;

import java.sql.Time;
import java.util.concurrent.*;
public class PortScanner {
    private String targetHost;
    private int startPort;
    private int endPort;
    private String protocol;

    public PortScanner(String targetHost, int startPort, int endPort, String protocol) {
        this.targetHost = targetHost;
        this.startPort = startPort;
        this.endPort = endPort;
        this.protocol = protocol;
    }

    public void startScan(){
        ExecutorService executor = Executors.newFixedThreadPool(50);
        for(int port = startPort; port <= endPort; port++){
            executor.execute(new PortScanTask(targetHost, port, protocol));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
