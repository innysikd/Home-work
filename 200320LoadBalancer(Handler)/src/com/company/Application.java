package com.company;

public class Application {
    /*
   Outer Server
   принимает запросы и пересылает их на менее загруженный Handler

   Balancer
   Его качестрва:
   1. хранит инфо о Handlers (в структуре данных)
   2. быстро обновляется
   3. быстро отдает самый оптимальный Handler
   При подключении он пустой
   Если от какого-л Handler в течении 5 cек нет сообщений, он стирается из структруры данных

   Handler
   каждую секунду пересылает инфо на Balancer (UDP), сколько у него свободных потоков
   host:  port:  load:
   Затем на более свободный Handler приходит по TCP задание, он его обрабатывает и отсылает обратно по этому же каналу

   Общий вид (второго варианта):
   TCP thread from Client to Server -> thread from Server to Handler (TCP) -> thread from Handler to server (TCP) ->
   -> connection from Server to Client (TCP) -> close thread

     */

    public static void main(String[] args) throws InterruptedException {

        String handlerHost = args[0];
        int handlerPort = Integer.parseInt(args[1]);

        Thread th = new Thread(new Handler(handlerHost, handlerPort));

        th.start();
        th.join();

    }

}
