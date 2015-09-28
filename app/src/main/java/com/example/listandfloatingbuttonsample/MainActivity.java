package com.example.listandfloatingbuttonsample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements
        CustomAdapter.Callback,
        AdapterView.OnItemClickListener,
        View.OnClickListener
{
    private Context context;
    private CustomAdapter customAdapter;
    private ListView listView;
    private ImageButton imageButton;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);
        items = new ArrayList<Item>();
        items.add(new Item("title 0", "sub title 0", false));
        items.add(new Item("title 1", "sub title 1", false));
        items.add(new Item("title 2", "sub title 2", false));
        items.add(new Item("title 3", "sub title 3", false));
        items.add(new Item("title 4", "sub title 4", false));
        items.add(new Item("title 5", "sub title 5", false));
        items.add(new Item("title 6", "sub title 6", false));
        items.add(new Item("title 7", "sub title 7", false));
        items.add(new Item("title 8", "sub title 8", false));
        items.add(new Item("title 9", "sub title 9", false));
        items.add(new Item("title 10", "sub title 10", false));
        items.add(new Item("title 11", "sub title 11", false));
        items.add(new Item("title 12", "sub title 12", false));
        items.add(new Item("title 13", "sub title 13", false));
        items.add(new Item("title 14", "sub title 14", false));
        items.add(new Item("title 15", "sub title 15", false));
        items.add(new Item("title 16", "sub title 16", false));
        items.add(new Item("title 17", "sub title 17", false));
        items.add(new Item("title 18", "sub title 18", false));
        items.add(new Item("title 19", "sub title 19", false));
        customAdapter = new CustomAdapter(this, R.layout.list_layout, items);
        customAdapter.setCallback(this);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(this);

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

    @Override
    public void onClickCheckBox(int position) {
        showToast(context, "pushed checkbox: position " + position);

        Item item = items.get(position);
        item.setCompleted(!item.isCompleted());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showToast(context, "pushed list: position" + position);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.imageButton) {
            showToast(context, "pushed add-button");
        }
    }

    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
