package stic.cdam.tp2application;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Product extends AppCompatActivity {

    int prodid;
    int imageId;
    String name;
    String category;
    int quantity = 0;
    double price;
    private boolean isIconChanged = false;


    private int counter = 0;
    private TextView quantitytv;
    public Product(int prodid, int imageId, String name, String category, int quantity, double price) {
        this.prodid = prodid;
        this.imageId = imageId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_product);
        ImageButton panieric = findViewById(R.id.panieric);
        panieric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePanieric();
            }
        });
        quantitytv= findViewById(R.id.quantity);
        updateResultText();

        // Set click listeners for the increment and decrement buttons
        ImageButton incrementButton = findViewById(R.id.addic);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementValue();
            }
        });

        ImageButton decrementButton = findViewById(R.id.removeic);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementValue();
            }
        });
    }

    private void incrementValue() {
        counter++;
        updateResultText();
    }

    private void decrementValue() {
        if (counter > 0) {
            counter--;
            updateResultText();
        }
    }

    private void updateResultText() {
        quantitytv.setText(String.valueOf(counter));
    }

    public void togglePanieric() {
        // Assuming you have an ImageButton named panieric in your layout
        ImageButton panieric = findViewById(R.id.panieric);
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

}