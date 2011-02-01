package info.kirklander.dice;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Dice extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dice_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        
        class OnDiceSelectedListener implements OnItemSelectedListener {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            	// do nothing, yet
            }

            public void onNothingSelected(AdapterView<?> parent) {
              // Do nothing.
            }
        }
        
        spinner.setOnItemSelectedListener(new OnDiceSelectedListener());

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
            	Random generator = new Random();
            	
            	String diceIndex1 = "" + (generator.nextInt(6) + 1);
            	String resource1 = "dice" + diceIndex1;         	            
                ImageView iv = (ImageView) findViewById(R.id.ImageView01);
                iv.setImageResource(getResources().getIdentifier(resource1, "drawable", getPackageName()));        	
   
                String diceIndex2 = "" + (generator.nextInt(6) + 1);
                String resource2 = "dice" + diceIndex2;
                ImageView iv2 = (ImageView) findViewById(R.id.ImageView02);
                iv2.setImageResource(getResources().getIdentifier(resource2, "drawable", getPackageName()));
                
            }
        });
    }

}
