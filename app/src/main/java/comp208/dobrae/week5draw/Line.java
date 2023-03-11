package comp208.dobrae.week5draw;

import android.graphics.Path;

// Line class that defines the color, stroke width and path of our lines
public class Line {
    public int color;
    public int strokeWidth;
    public Path linePath;

    // Basic constructor when instantiating a line object with specific values
    public Line(int color, int strokeWidth, Path linePath) {
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.linePath = linePath;
    }
}
