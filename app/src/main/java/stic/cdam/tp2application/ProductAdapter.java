package stic.cdam.tp2application;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Activity activity;
    private int itemResourceId;
    private List<Product> items;

    private int quantity = 0;
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
        quantitytv = layout.findViewById(R.id.quantity); // Initialize quantitytv here
        TextView priceTV = layout.findViewById(R.id.price);

        imageId.setImageResource(items.get(position).imageId);
        nameTV.setText(items.get(position).name);
        categoryTV.setText(items.get(position).category);
        quantitytv.setText(String.valueOf(items.get(position).quantity)); // Convert int to String
        priceTV.setText(String.valueOf(items.get(position).price)); // Convert int to String

        ImageButton panieric = layout.findViewById(R.id.panieric);
        panieric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePanieric(panieric);
            }
        });

        // Gestion des boutons d'ajout et de soustraction
        ImageView addButton = layout.findViewById(R.id.addic);
        ImageView removeButton = layout.findViewById(R.id.removeic);
        TextView quantityTV = layout.findViewById(R.id.quantity);
        TextView totalTV = layout.findViewById(R.id.total);




        ImageButton incrementButton = layout.findViewById(R.id.addic);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementValue();
            }
        });

        ImageButton decrementButton = layout.findViewById(R.id.removeic);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementValue();
            }
        });

        return layout;
    }

    private void incrementValue() {
        quantity++;
        quantitytv.setText(String.valueOf(quantity));
    }

    private void decrementValue() {
        if (quantity > 0) {
            quantity--;
            quantitytv.setText(String.valueOf(quantity));
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
}
