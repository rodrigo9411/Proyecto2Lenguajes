package com.rodrigo.turingmachines.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rodrigo.turingmachines.R;
import com.rodrigo.turingmachines.objects.BeltItem;

import java.util.List;

public class BeltAdapter extends  RecyclerView.Adapter<BeltAdapter.ViewHolder> {

    private List<BeltItem> mItems;
    private Context mContext;
    

    public BeltAdapter(Context context,List<BeltItem> belt){
        mContext = context;
        mItems = belt;
    }

    @Override
    public BeltAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View participantsView = inflater.inflate(R.layout.belt_item,parent,false);
        BeltAdapter.ViewHolder viewHolder = new BeltAdapter.ViewHolder(participantsView);
        return viewHolder;
    }

    

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        BeltItem item = mItems.get(position);

        TextView textViewText = holder.tvText;
        textViewText.setText(item.getText());

        TextView textViewStatus = holder.tvStatus;
        textViewStatus.setText(item.getCurrentStatus().trim());
        if(item.getCurrentStatus().trim().contains("q")){
            textViewText.setBackground(mContext.getDrawable(R.drawable.current_square));
        }else{
            textViewText.setBackground(mContext.getDrawable(R.drawable.square));
        }


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvText,tvStatus;


        private ViewHolder(View itemView) {
            super(itemView);
            tvText =  itemView.findViewById(R.id.tvText);
            tvStatus =  itemView.findViewById(R.id.tvStatus);

        }

        public TextView getTextView() {
            return tvText;
        }
        public TextView getStatusView(){
            return tvStatus;
        }
    }


}
