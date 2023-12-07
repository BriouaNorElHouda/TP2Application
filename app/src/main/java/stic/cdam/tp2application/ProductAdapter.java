package stic.cdam.tp2application;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Activity activity;
    private int itemResourceId;
    private List<Product> items;

    private int quantity = 0;
    private double totalprice = 0.0;
    private TextView quantitytv;

    public ProductAdapter(Activity activity, int itemResourceId, List<Product> items) {
        this.activity = activity;
        this.itemResourceId = itemResourceId;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = convertView;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            layout = inflater.inflate(itemResourceId, parent, false);
        }
        ImageView imageId = layout.findViewById(R.id.imageId);
        TextView nameTV = layout.findViewById(R.id.name);
        TextView categoryTV = layout.findViewById(R.id.category);
        TextView quantitytv = layout.findViewById(R.id.quantity);
        TextView priceTV = layout.findViewById(R.id.price);

        Product currentItem = items.get(position);

        imageId.setImageResource(currentItem.imageId);
        nameTV.setText(currentItem.name);
        categoryTV.setText(currentItem.category);
        quantitytv.setText(String.valueOf(currentItem.quantity));
        priceTV.setText(String.valueOf(currentItem.price));

        TextView totalTextView = layout.findViewById(R.id.total);
        ImageButton panieric = layout.findViewById(R.id.panieric);
        panieric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePanieric(panieric);
            }
        });

        ImageButton incrementButton = layout.findViewById(R.id.addic);
        ImageButton decrementButton = layout.findViewById(R.id.removeic);

        incrementButton.setOnClickListener(v -> {
            currentItem.quantity++;
            quantitytv.setText(String.valueOf(currentItem.quantity));
            updateTotal(currentItem, totalTextView);
            updateTotalPrice();
        });

        decrementButton.setOnClickListener(v -> {
            if (currentItem.quantity > 0) {
                currentItem.quantity--;
                quantitytv.setText(String.valueOf(currentItem.quantity));
                updateTotal(currentItem, totalTextView);
                updateTotalPrice();
            }
        });



        Button btnTotalPrice = activity.findViewById(R.id.totalprice);
        btnTotalPrice.setOnClickListener(v -> {
            //Log.d("TotalPrice", "Total Price: " + getTotalPrice());
            btnTotalPrice.setText(String.valueOf(getTotalPrice() +"DZD"));
        });
        return layout;

    }

    private void updateTotal(Product currentItem, TextView totalTextView) {
        // Assuming currentItem has 'price' attribute
        double total = currentItem.quantity * currentItem.price;
        totalTextView.setText(String.valueOf(total+"DZD"));
    }
    private void updateTotalPrice() {

        totalprice = 0.0;
        for (Product item : items) {
            totalprice += item.quantity * item.price;
        }
    }

    public void togglePanieric(ImageButton panieric) {
        Log.d("TogglePanieric", "ToggleButton Clicked!");
        // Get the current state of the ImageButton
        boolean isPaniericPShopping = true; // Initial state
        if (panieric.getTag() != null) {
            isPaniericPShopping = (boolean) panieric.getTag();
        }

        // Toggle between pshoppingic and mshoppingic icons
        if (isPaniericPShopping) {
            panieric.setImageResource(R.drawable.mshoppingic); // Change to mshoppingic
        } else {
            panieric.setImageResource(R.drawable.pshoppingic); // Change to pshoppingic
        }

        // Toggle the state
        panieric.setTag(!isPaniericPShopping);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Product getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public double getTotalPrice() {
        return totalprice;
    }
}
