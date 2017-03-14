package com.github.jioong;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

/**
 * Created by jioong on 17-3-13.
 */
public class Activator implements BundleActivator, ServiceListener {
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Startint to listen for service events!");
        bundleContext.addServiceListener(this);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        bundleContext.removeServiceListener(this);
        System.out.println("Stopped listening for service events.");
    }

    public void serviceChanged(ServiceEvent serviceEvent) {
        String[] objectClass = (String[]) serviceEvent.getServiceReference().getProperty("objectClass");
        if(serviceEvent.getType() == ServiceEvent.REGISTERED) {
            System.out.println("Service of type " + objectClass[0] + " registed.");
        } else if(serviceEvent.getType() == ServiceEvent.UNREGISTERING) {
            System.out.println("Service of type" + objectClass[0] + " unregisted.");
        } else if(serviceEvent.getType() == ServiceEvent.MODIFIED) {
            System.out.println("Service of type " + objectClass[0] +  " modified.");
        }
    }
}
