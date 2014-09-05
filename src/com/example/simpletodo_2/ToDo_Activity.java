package com.example.simpletodo_2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class ToDo_Activity extends Activity {
	private ArrayList<String> todoItems;
	private ArrayAdapter<String> todoAdapter;
	private ListView lvItem;
	private EditText etnewItem;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_);
        etnewItem = (EditText) findViewById(R.id.etnewItem);
        lvItem = (ListView) findViewById(R.id.lvItem);
        populateArrayItems();
        todoAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,todoItems);
        lvItem.setAdapter(todoAdapter);
        setupListViewListener();
    }

    private void setupListViewListener() {
    	lvItem.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View item,
					int pos, long id) {
				todoItems.remove(pos);
				todoAdapter.notifyDataSetChanged();
				// TODO Auto-generated method stub
				return true;
			}
    		
    	});
    }
 private void populateArrayItems()
   {
	   todoItems = new ArrayList<String>();
	  // todoItems.add("Item 1");
	  // todoItems.add("Item 2");
	  // todoItems.add("Item 3");
   }
   
   public void onAddedMethod(View v){
	  
	   String itemText = etnewItem.getText().toString();
	   todoAdapter.add(itemText);
	   etnewItem.setText("");
	   
   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.to_do_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
