package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method used to be called when the order button is clicked.
     */

    public void submitOrder(View view) {

            CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.toppingsCheckbox);
            boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
            Log.v("MainActivity", "Has whipped cream: " +  hasWhippedCream);

            CheckBox addChocolateCheckBox = (CheckBox) findViewById(R.id.chocolateCheckbox);
            boolean hasChocolate = addChocolateCheckBox.isChecked();
            Log.v("MainActivity", "Has chocolate: " + hasChocolate);

            EditText nameField = (EditText) findViewById(R.id.name);
            String name = nameField.getText().toString();
            Log.v("MainActivity", "Name: " + name);

            int price = calculatePrice(hasWhippedCream, hasChocolate);
            String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, name) + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        Log.v("MainActivity", "Sharing the order summary to email");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    /**
     *Create summary of the order.
     *
     * @param name of the customer
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return text summary
     */

    public String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {
        price = calculatePrice(addWhippedCream, addChocolate);
        String priceMessage = getString(R.string.order_summary_name, name);
        priceMessage += "\n" + getString(R.string.whippedCreamQ) + " " + addWhippedCream;
        priceMessage += "\n" + getString(R.string.chocolateQ) + " " + addChocolate;
        priceMessage += "\n " + getString(R.string.quantity) + quantity;
        priceMessage += "\n" + getString(R.string.total) + price;
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        // Price of 1 cup of coffee
        int basePrice = 5;

        // Add $1 if the user wants whipped cream
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        // Add $2 if the user wants chocolate
        if (addChocolate) {
          basePrice = basePrice + 2;
        }

        // Calculate the total price by multiplying the quantity
            return quantity * basePrice;
    }

    public void increment(View view) {
        if (quantity == 100) {
           Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */

}
