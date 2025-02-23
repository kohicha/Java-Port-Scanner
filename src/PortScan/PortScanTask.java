package PortScan;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanTask implements Runnable {

    private String targetHost;
    private int port;
    private String protocol;

    public PortScanTask(String targetHost, int port, String protocol){
        this.targetHost = targetHost;
        this.port = port;
        this.protocol = protocol;
    }

    @Override
    public void run(){
        try{
            if(protocol.equals("tcp")){
                try(Socket socket = new Socket()){
                    socket.connect(new InetSocketAddress(targetHost, port), 200);
                    String service = CommonPorts.getServiceName(port);
                    System.out.printf("[+] Port %d (%s) is open \n", port, service);
                }
            } else if(protocol.equals("udp")){
                try(DatagramSocket socket = new DatagramSocket()){
                    socket.setSoTimeout(200);
                    socket.connect(new InetSocketAddress(targetHost, port));
                    String service = CommonPorts.getServiceName(port);
                    System.out.printf("[+] Port %d (%s) is open \n", port, service);
                }
            }
        }catch (Exception e){

        }
    }
}
