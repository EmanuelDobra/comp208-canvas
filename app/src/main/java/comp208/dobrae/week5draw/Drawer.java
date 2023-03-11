package comp208.dobrae.week5draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Drawer extends View {
    // brush type width and color, controls it
    Paint paint = new Paint();

    // Path object to store the POIs
    Path myPath = new Path();

    // constructor
    public Drawer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    // this is to draw things on canvas
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // we need a path based on points
        paint.setStyle(Paint.Style.STROKE); // sets it to draw stroke
        paint.setColor(Color.MAGENTA); // sets brush color
        paint.setStrokeWidth(8); // 8px width

        // draw the path if not null
        if (myPath != null) {
            canvas.drawPath(myPath, paint); // puts obj down
        }
    }

    // begin point of path
    public void begin(float x, float y) {
       myPath = new Path(); // reset path
       myPath.moveTo(x, y);
       invalidate(); // says to redraw everything, repeat path
    }

    // adds point to path
    public void addPoint(float x, float y) {
        if (myPath != null) {
            myPath.lineTo(x, y);
            invalidate();
        }
    }


}
