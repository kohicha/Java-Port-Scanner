package PortScan;

public class PrepareTask {
    private String targetHost;
    private int startPort;
    private int endPort;
    private String protocol;
    public PrepareTask(String[] args) {
        if(args.length < 3){
            System.out.println("Usage: portscanner <target-host> <start-port> <end-port> <tcp/udp>");
            System.exit(1);
        }
        this.targetHost = args[0];
        this.startPort = Integer.parseInt(args[1]);
        this.endPort = Integer.parseInt(args[2]);
        this.protocol = args[3];

        if(!protocol.equals("tcp") && !protocol.equals("udp")){
            System.out.println("Invalid protocol. Please use tcp or udp");
        }
    }
    public String getTargetHost() {
        return targetHost;
    }
    public int getStartPort() {
        return startPort;
    }
    public int getEndPort() {
        return endPort;
    }
    public String getProtocol() {
        return protocol;
    }
}
