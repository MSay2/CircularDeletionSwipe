package com.msay2.circular_deletion_swipe.activities;

import com.msay2.circular_deletion_swipe.R;
import com.msay2.circular_deletion_swipe.adapter.AdapterRecyclerView;
import com.msay2.circular_deletion_swipe.helpers.DeletionSwipeHelper;
import com.msay2.circular_deletion_swipe.model.ModelRecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;

import android.support.v4.content.ContextCompat;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DeletionSwipeHelper.OnSwipeListener
{
	private Toolbar toolbar;
	private RecyclerView recycler;
	private List<ModelRecyclerView> item_list;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		toolbar = (Toolbar)findViewById(R.id.toolbar);
		toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.semi_black));
		setSupportActionBar(toolbar);
		
		recycler = (RecyclerView)findViewById(R.id.recyclerView);
		recycler.setLayoutManager(new LinearLayoutManager(this));
		recycler.setItemAnimator(new DefaultItemAnimator());
		recycler.setAdapter(new AdapterRecyclerView(this, getItemList()));
		
		ItemTouchHelper.Callback callback = new DeletionSwipeHelper(0, ItemTouchHelper.START, this, this);
		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
		itemTouchHelper.attachToRecyclerView(recycler);
    }
	
	public List<ModelRecyclerView> getItemList()
	{
		item_list = new ArrayList<>();
		for (int i = 0; i < 40; i++)
		{
			ModelRecyclerView model = new ModelRecyclerView();
			model.setText("Position of text is : " + i);
			
			item_list.add(model);
		}
		return item_list;
	}

	@Override
	public void onSwiped(RecyclerView.ViewHolder viewHolder, int position)
	{
		((AdapterRecyclerView.ViewHolder)viewHolder).removeItem(position);
	}
}
