package utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import diplom.angrystudent.mai.diplom.R;

/**
 * Created by GS60 on 31.30.2016.
 */

public class TagView extends View {

    Context context;
    Drawable drawable;
    ArrayList<Tag> tagList;
    public FPoint camera;

    private Smooth smoothY;

    public TagView(Context context) {
        super(context);
        this.context = context;
        drawable = ContextCompat.getDrawable(context, R.drawable.circle);
        tagList = new ArrayList<>();
        camera = new FPoint(0,0);
        smoothY = new Smooth(50);
    }

    public TagView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        drawable = ContextCompat.getDrawable(context, R.drawable.circle);
        tagList = new ArrayList<>();
        camera = new FPoint(0,0);
        smoothY = new Smooth(50);
    }

    public TagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        drawable = ContextCompat.getDrawable(context, R.drawable.circle);
        tagList = new ArrayList<>();
        camera = new FPoint(0,0);
        smoothY = new Smooth(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Tag tag : tagList){
            //drawable.setBounds(tag.getX()-tag.getSize()/2, tag.getY()-tag.getSize()/2, tag.getX()+tag.getSize()/2, tag.getY()+tag.getSize()/2);
            drawable.setBounds((int)(/**/ (getWidth()/2 + (tag.getX() - camera.getX())*(getWidth()/-36) - tag.getSize()/2)), (int)(/**/(getHeight()/2 + (tag.getY() - camera.getY())*(getHeight()/50) - tag.getSize()/2)),(int)(/**/(getWidth()/2 + (tag.getX() - camera.getX())*(getWidth()/-36) + tag.getSize()/2)), (int)(/**/(getHeight()/2 + (tag.getY() - camera.getY())*(getHeight()/50) + tag.getSize()/2)));
            drawable.draw(canvas);
        }
        //Log.w("Draw",getWidth() + " " + getHeight());
    }

    public void putOrientationData(float[] data){
        camera.y = data[1];
    }

    public void putGyroData(float[] value){
        //camera.x += value[0];
        camera.x += value[1];
        //z += value[2];
        invalidate();
    }

    public void addTag(Tag tag){
        tagList.add(tag);
    }

    public void setTagList(ArrayList<Tag> tag){
        tagList.addAll(tag);
    }

    public class FPoint{
        private float x, y;
        FPoint(){
            x=0;
            y=0;
        }
        FPoint(float x, float y){
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y+90;
        }
    }

}
