package hr.ent.jutarnjamolitva;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MolitvaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_molitva);
        setTitle("Jutarnja molitva");

        Intent intent = getIntent();
        int BrojMolitve = intent.getIntExtra("brojMolitve",-1);

        if(BrojMolitve != -1)
            promjeniMolitvu(BrojMolitve);
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_molitva, menu);
        return true;
    }*/
/*
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
*/

    void promjeniMolitvu(int Broj){
        TextView naslovMolitve = (TextView) findViewById(R.id.molitvaTitleView);
        TextView textMolitve = (TextView) findViewById(R.id.molitvaContent);


        //naslovMolitve.setText("naslov" + Broj);
        //textMolitve.setText("naslov" + Broj);
        naslovMolitve.setText(getString(getStringResource(getApplicationContext(),"title" + Broj)));
        textMolitve.setText(getString(getStringResource(getApplicationContext(),"molitva" + Broj)));
    }

    public int getStringResource(Context context, String name) {
        int resId = context.getResources().getIdentifier(name, "string", "hr.ent.jutarnjamolitva");
        return resId;
    }
}
