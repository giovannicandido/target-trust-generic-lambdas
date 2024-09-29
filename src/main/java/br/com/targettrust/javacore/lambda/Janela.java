package br.com.targettrust.javacore.lambda;

import java.time.Duration;
import java.util.function.Function;

public class Janela implements Runnable {
    private final String name;

    public Janela(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++ ) {
            System.out.println(String.format("Thread %s executando em paralelo", name));
            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Janela("janela 1"));
        Thread t2 = new Thread(new Janela("janela 2"));
        t.start();
        t2.start();
        System.out.println("Thread 1 e 2 iniciada e vão executar em paralelo");
        try {
            Thread.sleep(Duration.ofSeconds(12));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finalizando programa principal");
    }

    public void executarComLambda() {
        Thread t = new Thread(() -> {
            for(int i = 0; i < 10; i++ ) {
                System.out.println(String.format("Thread janela 1 executando em paralelo", name));
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++ ) {
                System.out.println(String.format("Thread janela 2 executando em paralelo", name));
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Runnable lambda = () -> {
            for(int i = 0; i < 10; i++ ) {
                System.out.println(String.format("Thread executando em paralelo", name));
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t3 = new Thread(lambda);
        Thread t4 = new Thread(lambda);

        Function<String, Runnable> fabricaLambda = (String name) -> {
            return () -> {
                for(int i = 0; i < 10; i++ ) {
                    System.out.println(String.format("Thread %s em paralelo", name));
                    try {
                        Thread.sleep(Duration.ofSeconds(1));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
        };

        Runnable thread1 = fabricaLambda.apply("janela 1");
        Runnable thread2 = fabricaLambda.apply("janela 2");

        Thread t5 = new Thread(thread1);
        Thread t6 = new Thread(thread2);

    }

    public Runnable buildLambda(String name) {
        return () -> {
            for(int i = 0; i < 10; i++ ) {
                System.out.println(String.format("Thread %s em paralelo", name));
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
