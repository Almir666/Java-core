package MultiThreads;

// Exchanger<T> это синхронизатор котрый обеспечиваает обмен данными между двумя потоками,
// позволяет потокам получить информацию друг от друга одновременно

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

// Для примера возьмем игру камень ножницы бумага
// наш exchanger будет одновременно выдавать ответ обоим потокам для того что бы узнать кто победил
public class ExchangerEx {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> p1 = new ArrayList<>();
        p1.add(Action.ROCK);
        p1.add(Action.SCISSORS);
        p1.add(Action.ROCK);
        List<Action> p2 = new ArrayList<>();
        p2.add(Action.SCISSORS);
        p2.add(Action.ROCK);
        p2.add(Action.PAPER);

        new Player("Luka", p1, exchanger);
        new Player("Gosha", p2, exchanger);
    }
}

enum Action {
    ROCK, SCISSORS, PAPER;
}

class Player extends Thread {
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger = new Exchanger<>();

    public Player (String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void play (Action p1Action, Action p2Action) {
        if (p1Action == Action.ROCK && p2Action == Action.SCISSORS
        || p1Action == Action.SCISSORS && p2Action == Action.PAPER
        || p1Action == Action.PAPER && p2Action == Action.ROCK) {
            System.out.println(name + " победил");
        }
    }
    @Override
    public void run() {
        Action reply;
        for(Action action: myActions) {
            try {
                // метод exchange() выдает нам объект, но не ранее чем этот же метод выдаст объект второму потоку 
                // до тех пор потоки будут заблокированы и разблокируются когда оба они получат свои объекты от exchange()
                reply = exchanger.exchange(action);
                play(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}