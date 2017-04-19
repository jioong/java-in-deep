package com.github.jioong.rpc.service.com.github.jioong.rpc;

import com.github.jioong.rpc.service.EchoService;
import com.github.jioong.rpc.service.EchoServiceImpl;

import java.net.InetSocketAddress;

/**
 * Created by jioong on 17-4-19.
 */
public class RpcApp {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8080);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8080));
        System.out.println(echo.echo("Are you ok?"));
        System.out.println(echo.echo(null));
    }
}
