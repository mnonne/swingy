package org.aminadzh.swingy.model.items;

public abstract class Helmet {
    private int boost;
    private String name;

    protected Helmet(String name, int boost) {
        this.name = name;
        this.boost = boost;
    }

    public int getBoost() {
        return boost;
    }
}
