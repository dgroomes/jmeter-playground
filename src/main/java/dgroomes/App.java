package dgroomes;

public class App {

    public static void main(String[] args) throws InterruptedException {
        var echo = new Echo();
        echo.slowEcho("hello");
    }
}
