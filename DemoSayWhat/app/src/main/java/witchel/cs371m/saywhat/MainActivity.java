package witchel.cs371m.saywhat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] says = {null, null, null, null, null, null};
    private int currSay = 0;
    private boolean useIndividualStrings = false;

    public void sayIt(View view) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(says[currSay]);
        currSay++;
        if(currSay >= says.length) currSay = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if( useIndividualStrings ) {
            says[0] = getString(R.string.saywhat1);
            says[1] = getString(R.string.saywhat2);
            says[2] = getString(R.string.saywhat3);
            says[3] = getString(R.string.saywhat4);
            says[4] = getString(R.string.saywhat5);
            says[5] = getString(R.string.saywhat6);
        } else {
            says = getResources().getStringArray(R.array.say_what_arr);
        }
        Button but = (Button)findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sayIt(v);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
