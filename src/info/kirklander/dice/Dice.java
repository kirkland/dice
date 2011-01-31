package info.kirklander.dice;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Dice extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Random generator = new Random();
            	String diceIndex = "" + (generator.nextInt(6) + 1);
            	String resource = "dice" + diceIndex;
            	
                setContentView(R.layout.dice);
                
                ImageView iv = (ImageView) findViewById(R.id.ImageView01);
                iv.setImageResource(getResources().getIdentifier(resource, "drawable", getPackageName()));
                
            }
        });
    }

}
