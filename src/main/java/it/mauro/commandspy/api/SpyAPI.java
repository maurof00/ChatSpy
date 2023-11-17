package it.mauro.commandspy.api;

public class SpyAPI {
    private boolean spyAlerts;

    public SpyAPI() {
        this.spyAlerts = true;
    }
    public boolean isSpyAlerts() {
        return spyAlerts;
    }

    public void setSpyAlerts(boolean spyAlerts) {
        this.spyAlerts = spyAlerts;
    }
}
