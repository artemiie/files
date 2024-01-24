/**
 * Источник https://www.udemy.com/course/java-ot-zaura/learn/lecture/21097514#overview
 */

/**
 * Создание потока 1
 */

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        // поток 1 и 2 работают одновременно и независимо друг от друга
        // порядок выполнения потоков и вывода чисел в консоль непредсказуем
        myThread1.start();
        myThread2.start();
    }
}

/**
 * Создание потока 2
 */

class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thred(new MyThread1())
        Thread thread2 = new Thred(new MyThread2())
        // поток 1 и 2 работают одновременно и независимо друг от друга
        // порядок выполнения потоков и вывода чисел в консоль непредсказуем
        thread1.start();
        thread2.start();
    }
}

/**
 * Создание потока 3
 */

public class Main extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();

        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}

/**
 * Создание потока 4
 */

public class Main {
    public static void main(String[] args) {
        // анонимный класс
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world.");
            }
        }).start();

        // лямбда выражение
        new Thread(() -> System.out.println("Hello world.")).start();
    }
}

/**
 * Методы Thread
 *
 *      getName()
 *      setName()
 *      getPriority()
 *      setPriority()
 *      sleep() - заставляет поток остановится
 *      join() - останавливает поток main пока поток на котором вызван join не закончит работу
 *
 */


/**
 * Concurrency / Parallelism
 *
 *      concurrency - выполнение сразу нескольких задач, но необязательно в одно и тоже время.
 *      Способ достижения concurrency зависит от процессора компьютера
 *
 *      parallelism - частный случай concurrency
 *
 * Пример
 * 1) Петь и кушать (либо петь, либо кушать) - один процессор
 * 2) Готовить и говорить по телефону (и готовить, и говорить)
 *      - многоядерный процессор (достигается с помощью параллелизма)
 */


/**
 * Asynchronous / Synchronous
 *
 *      synchronous - все задачи выполяются последовательно.
 *                    Чтоб начать выполнять задание 2, надо дождаться выполнения задачи 1.
 *
 *      asynchronous - переключение между задачами (помогает достичь concurrency).
 *                      На многоядерном процессоре помогает достичь parallelism
 */


/**
 *      volatile - значение переменной будет храниться только в main memory, а не в кэше.
 *                  Потоки будут обращаться к переменным в main memory, а не в своем кэше.
 *                  Переменная volotile работает корректно, если ее изменяет только один поток, другие читают.
 *                  Если несколько потоков изменяют volatile переменную, то это приведет к data race.
 */


/**
 *       synchronized - п омогает синхронизировать работу потоков с методом или блоком кода.
 */


/**
 *       монитор - механизм, с помощью которого достигается коректная работа при синхронизации.
 *                  У каждого объекта есть монитор. У монитора может быть статус свободен или занят.
 *                  Поток не может взаимодействовать с объектом, пока монитор объекта в статусе занят.
 */
