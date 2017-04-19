package com.github.jioong.rpc.service;

/**
 * Created by jioong on 17-4-19.
 */
public class EchoServiceImpl implements EchoService {

    public String echo(String ping) {
        return ping != null ? ping + " ---> I am OK!" : "I am ok.";
    }
}
