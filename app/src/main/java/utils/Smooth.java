package utils;

/**
 * Created by GS60 on 31.10.2016.
 */

public class Smooth {
    private float[] mass;
    private int range;

    public Smooth(int range){
        this.range = range;
        mass = new float[range];
    }

    public float smooth(float value){
        for (int i = 0; i < range-1; i++){
            mass[i] = mass[i+1];
        }
        mass[range-1] = value;
        float ret = 0;
        for (float m : mass)
            ret += m;
        return ret/range;
    }
}
