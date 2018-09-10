package com.amazonaws.sample;

public class TickFlink {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar [jar] [consumerArn] [shardId]");
            System.exit(1);
        }

        String consumerArn = args[0];
        String shardId = args[1];
        TickProcessor processor = new TickProcessor();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Executing TickFlink.ShutdownHook");
            processor.interrupt();
        }));

        processor.start();
    }

}
