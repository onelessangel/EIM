package com.example.lab3;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ContactsManagerActivity extends AppCompatActivity {
    Button detailsButton, cancelButton, saveButton;
    EditText nameEditText, phoneEditText, emailEditText, addressEditText;
    EditText jobTitleEditText, companyEditText, websiteEditText, imEditText;
    LinearLayout additionalDetails;

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.detailsButton) {
                if (detailsButton.getText().equals(Constants.SHOW_DETAILS) ) {
                    additionalDetails.setVisibility(View.VISIBLE);
                    detailsButton.setText(Constants.HIDE_DETAILS);
                } else {
                    additionalDetails.setVisibility(View.GONE);
                    detailsButton.setText(Constants.SHOW_DETAILS);
                }
            } else if (view.getId() == R.id.saveButton) {
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String jobTitle = jobTitleEditText.getText().toString();
                String company = companyEditText.getText().toString();
                String website = websiteEditText.getText().toString();
                String im = imEditText.getText().toString();

                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                if (!name.isEmpty()) {
                    intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
                }

                if (!phone.isEmpty()) {
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
                }

                if (!email.isEmpty()) {
                    intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
                }

                if (!address.isEmpty()) {
                    intent.putExtra(ContactsContract.Intents.Insert.POSTAL, address);
                }

                if (!jobTitle.isEmpty()) {
                    intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, jobTitle);
                }

                // arraylist in intent
                ArrayList<ContentValues> contactData = new ArrayList<>();

                if (!website.isEmpty()) {
                    ContentValues websiteRow = new ContentValues();
                    websiteRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE);
                    websiteRow.put(ContactsContract.CommonDataKinds.Website.URL, website);
                    contactData.add(websiteRow);
                }

                if (!jobTitle.isEmpty()) {
                    ContentValues imRow = new ContentValues();
                    imRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE);
                    imRow.put(ContactsContract.CommonDataKinds.Im.DATA, im);
                    contactData.add(imRow);
                }

                intent.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, contactData);
                startActivity(intent);
            } else if (view.getId() == R.id.cancelButton) {
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacts_manager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        detailsButton = findViewById(R.id.detailsButton);
        cancelButton = findViewById(R.id.cancelButton);
        saveButton = findViewById(R.id.saveButton);
        additionalDetails = findViewById(R.id.additionalDetails);
        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        emailEditText = findViewById(R.id.emailEditText);
        addressEditText = findViewById(R.id.addressEditText);
        jobTitleEditText = findViewById(R.id.jobTitleEditText);
        companyEditText = findViewById(R.id.companyEditText);
        websiteEditText = findViewById(R.id.websiteEditText);
        imEditText = findViewById(R.id.imEditText);

        ButtonListener buttonListener = new ButtonListener();
        detailsButton.setOnClickListener(buttonListener);
        saveButton.setOnClickListener(buttonListener);
        cancelButton.setOnClickListener(buttonListener);
    }
}