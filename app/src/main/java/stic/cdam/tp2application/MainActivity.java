package stic.cdam.tp2application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Button totalPriceButton;
    private ProductAdapter productAdapter;


    private int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        totalPriceButton = findViewById(R.id.totalprice);

        //   Spinner s =findViewById(R.id.spinner);
       ListView l= findViewById(R.id.ListProduct);
        List<Product> items = new ArrayList<>();
        items.add(new Product(1, R.drawable.cachuete,"Cacahuète","F",0,1.0));
        items.add(new Product(2, R.drawable.ncajou,"Noix de cajou","F",0,1.0));
        items.add(new Product(3, R.drawable.almond,"Amandes","F",0,1.0));
        items.add(new Product(4, R.drawable.dattes,"Les dattes","F",0,1.0));
        items.add(new Product(5, R.drawable.walnut,"Noix","F",0,1.0));

        ProductAdapter adapter = new ProductAdapter(MainActivity.this,
                R.layout.item_product,items);

       // s.setAdapter(adapter);
       l.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.shopingic);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmationDialog();

            }
        });


    }


    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Order");
        builder.setMessage("Are you sure you want to place this order?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //what happens when confirm the order -8_8-
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //do nothing or handle accordingly
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showDatePickerDialog(View view) {
        // Get the current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog
        TextView selectedDateTV = findViewById(R.id.selectedDateTV);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Handle the selected date
                        String selectedDate = year + " - " + (month + 1) + " - " + dayOfMonth;
                        selectedDateTV.setText(selectedDate);
                    }
                },
                year,
                month,
                day
        );
        // Show the dialog
        datePickerDialog.show();
    }

}