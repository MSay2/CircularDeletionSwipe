package com.msay2.circular_deletion_swipe.adapter;

import com.msay2.circular_deletion_swipe.R;
import com.msay2.circular_deletion_swipe.model.ModelRecyclerView;

import android.support.v7.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>
{
	private Context context;
	private List<ModelRecyclerView> item;

	public AdapterRecyclerView(Context context, List<ModelRecyclerView> item)
	{
		this.context = context;
		this.item = item;
	}
	
	@Override
	public AdapterRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
		
		ViewHolder vh = new ViewHolder(layout);
		
		return vh;
	}
	
	@Override
	public void onBindViewHolder(AdapterRecyclerView.ViewHolder holder, int position)
	{
		holder.text.setText(item.get(position).getText());
	}
	
	@Override
	public int getItemCount()
	{
		return item.size();
	}
	
	public class ViewHolder extends RecyclerView.ViewHolder
	{
		private TextView text;
		
		ViewHolder(View itemView)
		{
			super(itemView);
			
			text = (TextView)itemView.findViewById(R.id.id_text);
		}
		
		public void removeItem(int position)
		{
			item.remove(position);
			notifyItemRemoved(position);
		}
	}
}
