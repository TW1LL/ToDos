package com.tolliam.todos;

/**
 * Created by wwagner on 8/25/2016.
 */
public class Item {
    private long id;
    private String item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}
