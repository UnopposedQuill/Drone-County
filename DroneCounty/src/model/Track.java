package model;

public class Track {
    private int whidth;
    private int height;
    private int limit;
    private int numOfSubtracks;

    public int getWhidth() {
        return whidth;
    }

    public int getHeight() {
        return height;
    }

    public int getLimit() {
        return limit;
    }

    public void setWhidth(int whidth) {
        this.whidth = whidth;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNumOfSubtracks() {
        return numOfSubtracks;
    }

    public void setNumOfSubtracks(int numOfSubtracks) {
        this.numOfSubtracks = numOfSubtracks;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
