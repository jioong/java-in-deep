package com.jioong.github.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by jioong on 17-8-24.
 */
public interface MyRemote extends Remote {

    String sayHello() throws RemoteException;
}
