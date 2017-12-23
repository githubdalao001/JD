package com.bwie.mytaobao.myview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DELL on 2017/11/17.
 */

public class MyYinDaoView extends View {

    private Paint paint;
    private int round;
    private float radiu;
    private int ringColor;
    float cX,cY;

    CircleStyle cs ;
    private void init(){

        paint = new Paint();
        paint.setAntiAlias(true);

        round = 0;
        radiu = 100;
        ringColor = Color.BLACK;


    }
    public MyYinDaoView(Context context) {
        super(context);
        init();
    }

    public MyYinDaoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyYinDaoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(cs == null){
            cs = new CircleStyle(radiu,ringColor,round);
            cX = getWidth()/2;
            cY = getHeight()/2;
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);
            canvas.drawCircle(cX, cY, cs.getRadiu()-10, paint);
            canvas.drawCircle(cX, cY, cs.getRadiu()+10, paint);

            paint.setColor(cs.getColor());
            paint.setStrokeWidth(16);
            RectF rect = new RectF();
            rect.set(cX - cs.getRadiu(), cY - cs.getRadiu(), cX + cs.getRadiu(), cY+ cs.getRadiu());
            canvas.drawArc(rect, 0.0f, cs.getRound(), false, paint);
            startAnimator();
        }else{
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);
            canvas.drawCircle(cX, cY, cs.getRadiu()-10, paint);
            canvas.drawCircle(cX, cY, cs.getRadiu()+10, paint);

            paint.setColor(cs.getColor());
            paint.setStrokeWidth(16);
            RectF rect = new RectF();
            rect.set(cX - cs.getRadiu(), cY - cs.getRadiu(), cX + cs.getRadiu(), cY+ cs.getRadiu());
            canvas.drawArc(rect, 0, cs.getRound(), false, paint);
//            tempRound = cs.getRound();
        }

    }

    public interface startActivity{
        void start();
    }
    public startActivity sa;
    public void setStartActivity(startActivity sa){
        this.sa = sa;
    }

    public void startAnimator() {
        ValueAnimator animator = ValueAnimator.ofObject(new CircleEvaluator(),new CircleStyle(radiu,Color.BLACK,0),new CircleStyle(radiu,Color.BLACK,360));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                cs = (CircleStyle) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(4000);
        animator.start();
       animator.addListener(new AnimatorListenerAdapter() {
           @Override
           public void onAnimationEnd(Animator animation) {
               super.onAnimationEnd(animation);
               sa.start();
           }
       });
    }

    class CircleEvaluator implements TypeEvaluator {
        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            CircleStyle start = (CircleStyle) startValue;
            CircleStyle end = (CircleStyle) endValue;
            float round = start.getRound() + fraction * (end.getRound() - start.getRound());
            int colorR = Math.abs((int) (216 - fraction * (245 - 16)));
            int colorG = Math.abs((int) (156 - fraction * (45 - 16)));
            int colorB = Math.abs((int) (24 - fraction * (234 - 16)));
            String tempR = Integer.toHexString(colorR);
            String tempG = Integer.toHexString(colorG);
            String tempB = Integer.toHexString(colorB);
            if(tempR.length() < 2){
                tempR += "0";
            }
            if(tempG.length() < 2){
                tempG += "0";
            }
            if(tempB.length() < 2){
                tempB += "0";
            }
            String tempColor = "#" + tempR + tempG + tempB ;//#fff3a3
            int color = Color.parseColor(tempColor);
            CircleStyle cs = new CircleStyle(radiu,  color, round);
            return cs;
        }
    }

    class CircleStyle {
        float radiu;
        int color;
        float round;

        public CircleStyle(float radiu, int color, float round) {
            this.radiu = radiu;
            this.color = color;
            this.round = round;
        }

        public float getRound() {
            return round;
        }

        public void setRound(float round) {
            this.round = round;
        }

        public float getRadiu() {
            return radiu;
        }

        public void setRadiu(float radiu) {
            this.radiu = radiu;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }
}
