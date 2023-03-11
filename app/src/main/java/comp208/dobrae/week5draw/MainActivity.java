package comp208.dobrae.week5draw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.OnTouchListener; // need this for the View

public class MainActivity extends AppCompatActivity {

    // add in drawer obj
    Drawer lines;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get our drawer
        lines = findViewById(R.id.drawer);

        // view: what is being touched
        // event: what happens
        OnTouchListener listener = (view, event) ->{
            // turns our event into an int for us to use
            int action = event.getActionMasked();

            switch(action) {
                // finger has touched screen
                case (MotionEvent.ACTION_DOWN):
                    lines.begin(event.getX(), event.getY()); // move initial start pt to where user touched
                    break;
                case (MotionEvent.ACTION_UP): // register click if user lifts finger
                    view.performClick();
                    break;
                case (MotionEvent.ACTION_MOVE):
                    lines.addPoint(event.getX(), event.getY()); // register move pts if user drags
                    break;
            }
            return true;
        };

        lines.setOnTouchListener(listener);
    }
}