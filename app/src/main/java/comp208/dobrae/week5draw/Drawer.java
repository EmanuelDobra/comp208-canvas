package comp208.dobrae.week5draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

// Drawer class that instantiates all needed resources to draw on canvas
public class Drawer extends View {

    // build arrayList to store lines that user draws
    private ArrayList<Line> lines = new ArrayList<>();

    // brush type width and color, controls it
    Paint paint = new Paint();
    // Path object to store the POIs
    Path myPath = new Path();

    // default line attributes, will be editable by button clicks
    int currentColor = Color.BLACK;
    int brushWidth = 8;

    // constructor
    public Drawer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    // this is to draw things on canvas
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // for each line we have in our array, draw it out
        for (Line ln: lines) {
            paint.setStrokeWidth(ln.strokeWidth);
            paint.setColor(ln.color);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(ln.linePath, paint);
        }
    }

    // begin point of path
    public void begin(float x, float y) {
        myPath = new Path(); // reset path

        // create and store new lines
        Line ln = new Line(currentColor, brushWidth, myPath);
        lines.add(ln);

        // move to co-ords
        myPath.moveTo(x, y);
    }

    // adds point to path
    public void addPoint(float x, float y) {
        if (myPath != null) {
            myPath.lineTo(x, y);
            invalidate();
        }
    }

    // clears screen of current lines
    public void clearScreen() {
        lines = new ArrayList<>();
        myPath = new Path();
        invalidate();  // says to redraw everything, repeat path
    }

    // basic functions to change colors to the ones we use
    public void changeColorRed() {
        currentColor = Color.RED;
    }

    public void changeColorMagenta() {
        currentColor = Color.MAGENTA;
    }

    public void changeColorGreen() {
        currentColor = Color.GREEN;
    }

    public void changeColorBlue() {
        currentColor = Color.BLUE;
    }

    public void changeColorYellow() {
        currentColor = Color.YELLOW;
    }

    // basic functions to change the line stroke width
    public void pencilStroke() {
        brushWidth = 8;
    }

    public void highlighterStroke() {
        brushWidth = 24;
    }

    public void brushStroke() {
        brushWidth = 64;
    }


}
