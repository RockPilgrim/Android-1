/**
 * Android-1 Homework-1
 *
 * Class fist and last activity
 * Change text color on random color
 *
 * @author Timofei Tokarev
 * @version dated 30.09.18
 */

package my.lessons.lesson_1workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button changeColorButton;
    int colors[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors=getResources().getIntArray(R.array.text_colors);
        for (int i=0;i<20;i++) {
            System.out.println((int)(Math.random() * 5));
        }
        textView=findViewById(R.id.textView);
        changeColorButton =findViewById(R.id.button);

        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println("!PRESS!");   // for test
                while (true){
                    int c=(int) (Math.random()*colors.length);
                    //System.out.println("Color# "+c);   // for test
                    if (textView.getCurrentTextColor()!=colors[c]){
                        textView.setTextColor(colors[c]);
                        changeColorButton.setTextColor(colors[c]);
                        break;
                    }
                }
            }
        });
    }
}
