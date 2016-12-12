package utils;

/**
 * Created by GS60 on 31.10.2016.
 */

public class Tag{
    private int size;
    private int x, y;

    public Tag(){
        x = 0;
        y = 0;
        size = 20;
    }

    public Tag(int x, int y){
        this.x = x;
        this.y = y;
        size = 20;
    }

    public Tag(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getSize(){
        return size;
    }

    int getX(){
        return x;
    }

    int getY() {
        return y;
    }
}
