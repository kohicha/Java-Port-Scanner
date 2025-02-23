package PortScan;
import java.util.*;
public class CommonPorts {
    private static final Map<Integer, String> CommonPorts = new HashMap<>();
    static {
        CommonPorts.put(21, "FTP");
        CommonPorts.put(22, "SSH");
        CommonPorts.put(80, "HTTP");
        CommonPorts.put(443, "HTTPS");
        CommonPorts.put(445, "SMB");
        CommonPorts.put(25, "SMTP");
        CommonPorts.put(3389, "RDP");
    }

    public static String getServiceName(int port) {
        return CommonPorts.getOrDefault(port, "Unknown");
    }
}
