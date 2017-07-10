package org.kjpm.com.cryptowallet;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by kemjohnmantos on 22/06/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Currency> currency;
    private Activity activity;
    static View samp;

    public RecyclerAdapter(Activity activity, List<Currency> currency) {
        this.currency = currency;
        this.activity = activity;

    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        samp = getView(view);

        return viewHolder;
    }

    public View getView(View view) {
        return view;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        holder.address.setText(currency.get(position).getAddress());
        holder.balance.setText(currency.get(position).getBalance()+"");
//        holder.container.setOnClickListener(onClickListener(position));
    }


    @Override
    public int getItemCount() {
        return (null != currency ? currency.size() : 0);
        // return 0;
    }

//    private View.OnClickListener onClickListener(final int position){
//
//        return new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//                final Dialog dialog = new Dialog(activity);
//
//                dialog.setContentView(R.layout.item_recycler);
//                dialog.setTitle("Position" + position);
//                dialog.setCancelable(true);
//
//                TextView name = (TextView) dialog.findViewById(R.id.name);
//                TextView price = (TextView) dialog.findViewById(R.id.price);
//                ImageView img = (ImageView) dialog.findViewById(R.id.image);
//                setDataToView(name, price, img, position);
//                String itmName = name.getText().toString();
//                String itmPrice = price.getText().toString();
//                String url = FriendsFragment.imageUrl + items.get(position).getItem_image();
//                Intent itminfo = new Intent(activity,ItemInfo.class);
//                itminfo.putExtra("itmName",itmName);
//                itminfo.putExtra("itmPrice",itmPrice);
//                itminfo.putExtra("itmImage",url);
//                itminfo.putExtra("itmId",items.get(position).getItem_id());
//
//                activity.startActivity(itminfo);
//            }
//        };
//    }

//    private void setDataToView(TextView name, TextView price, ImageView img, int position){
//        address.setText(currency.get(position).getAddress());
//        balance.setText(currency.get(position).getBalance().toString());
//
////        Picasso.with(activity).load(FriendsFragment.imageUrl + items.get(position).getItem_image()).into(img);
//    }


    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView address;
        private TextView balance;
        private View container;

        public ViewHolder(View view) {
            super(view);

            address = (TextView) view.findViewById(R.id.address);
            balance = (TextView) view.findViewById(R.id.balance);
            container = view.findViewById(R.id.card_view);
        }
    }
}