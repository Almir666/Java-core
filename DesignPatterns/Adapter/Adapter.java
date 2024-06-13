package DesignPatterns.Adapter;

public class Adapter {
    public static void main(String[] args) {
        SimpleSocket simpleSocket = new SimpleSocketObject();

        SocketAdapter adapter = new SocketAdapter(simpleSocket);

        Device device = new Device();
        device.work(adapter);

    } 
}


class SocketAdapter implements AnotherSocket{

    SimpleSocket simpleSocket;

    public SocketAdapter(SimpleSocket socket) {
        this.simpleSocket = socket;
    }
    @Override
    public void getPower() {
        simpleSocket.getPower();
    }
}

interface SimpleSocket {
    void getPower();
}

interface AnotherSocket {
    void getPower();
}

class SimpleSocketObject implements SimpleSocket{
    @Override
    public void getPower() {
        System.out.println("Get power...");
    }
}

class Device {
    public void work(AnotherSocket adapter) {
        adapter.getPower();
    }
}


