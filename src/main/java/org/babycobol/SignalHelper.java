package org.babycobol;

public class SignalHelper {

    private String procName = null;
    private boolean insideSignalHandler;

    public void start() {
        insideSignalHandler = true;
    }

    public void stop() {
        insideSignalHandler = false;
    }

    public boolean outsideHandler() {
        return !insideSignalHandler;
    }

    public String procName() {
        return procName;
    }

    public boolean isSet() {
        return procName != null;
    }

    public void unset() {
        procName = null;
    }

    public void set(String procName) {
        this.procName = procName;
    }
}
