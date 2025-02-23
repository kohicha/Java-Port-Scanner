import PortScan.PortScanner;
import PortScan.PrepareTask;

public class Main {
    public static void main(String[] args) {
        PrepareTask a = new PrepareTask(args);
        PortScanner ps = new PortScanner(a.getTargetHost(), a.getStartPort(), a.getEndPort(), a.getProtocol());
        ps.startScan();
    }
}