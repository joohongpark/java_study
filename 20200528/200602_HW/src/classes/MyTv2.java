package classes;

public class MyTv2 {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int prevChannel;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public boolean getIsPowerOn() {
        return isPowerOn;
    }
    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setChannel(int channel) {
        prevChannel = this.channel;
        this.channel = channel;
    }

    public void setIsPowerOn(boolean isPowerOn) {
        this.isPowerOn = isPowerOn;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void gotoPrevChannel() {
        int swap = prevChannel;
        prevChannel = this.channel;
        this.channel = swap;
    }
}