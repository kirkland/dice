package info.kirklander.dice;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Dice extends Activity {
    int diceCount = 2;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
//        final TextView debug = (TextView) findViewById(R.id.debug);
//        debug.setText("HELLO");
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dice_array_strings, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        
        class OnDiceSelectedListener implements OnItemSelectedListener {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            	diceCount = ((int) id) + 1;
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
            	
           		((android.view.ViewGroup) findViewById(R.id.diceHolder)).removeAllViews();
            	
            	for (int i = 0; i < diceCount; i++) {
            		ImageView iv = new ImageView(Dice.this);
            		iv.setId(i);
            		String resource = "dice" + (generator.nextInt(6) + 1);
            		iv.setImageResource(getResources().getIdentifier(resource, "drawable", getPackageName()));
            		
            	    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            	    if (i < 1) {
            	    	lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            	    }
            	    if (i % 2 == 1) {
            	    	lp.addRule(RelativeLayout.RIGHT_OF, i - 1);
            	    	lp.addRule(RelativeLayout.ALIGN_TOP, i - 1);
            	    }
            	    if (i > 1) {
            	    	lp.addRule(RelativeLayout.BELOW, i - 2);
            	    }

            	    ((android.view.ViewGroup) findViewById(R.id.diceHolder)).addView(iv, lp);
            	}
            }
        });
    }

}
