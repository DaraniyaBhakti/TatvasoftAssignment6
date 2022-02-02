package com.tatvasoft.tatvasooftassignment6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPhone;
    private EditText etAddress;
    private EditText etMail;
    private Spinner countryDropDown;
    private EditText etDob;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private CheckBox chPlaying;
    private CheckBox chReading;
    private CheckBox chWriting;
    private static Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindId();
        resources = getResources();
        setDatePicker();
        setSpinner();
    }

    public static Resources getRes()
    {
        return resources;
    }

    public void setDatePicker()
    {
        Calendar myCalendar= Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,day);
            String myFormat="MM/dd/yy";
            SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
            etDob.setText(dateFormat.format(myCalendar.getTime()));
        };

        etDob.setOnClickListener(view -> new DatePickerDialog(MainActivity.this,
                date,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH))
                .show());
    }

    public void setSpinner()
    {
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.countryArray));
        countryDropDown.setAdapter(countryAdapter);
    }

    public void bindId()
    {
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etMail = findViewById(R.id.etMail);
        countryDropDown = findViewById(R.id.countryDropDown);
        etDob = findViewById(R.id.etDob);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        chPlaying = findViewById(R.id.chPlaying);
        chReading = findViewById(R.id.chReading);
        chWriting = findViewById(R.id.chWriting);
    }


    private boolean isValid(){
        boolean isValid=true;


        if(TextUtils.isEmpty(etName.getText().toString())) {
            isValid = false;
            etName.setError(getString(R.string.err_name));
        }

        if(TextUtils.isEmpty(etAddress.getText().toString())){
            isValid=false;
            etAddress.setError(getString(R.string.err_address));
        }

        if(TextUtils.isEmpty(etDob.getText().toString())){
            isValid=false;
            etDob.setError(getString(R.string.err_dob));
        }


        if(TextUtils.isEmpty(etMail.getText().toString())){
            isValid=false;
            etMail.setError(getString(R.string.err1_email));
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(etMail.getText().toString()).matches())
        {
            isValid=false;
            etMail.setError(getString(R.string.err2_email));
        }

        if(TextUtils.isEmpty(etPhone.getText().toString())){
            isValid=false;
            etPhone.setError(getString(R.string.err1_contact));
        }
        else if(etPhone.getText().toString().length()!=10){
            isValid=false;
            etPhone.setError(getString(R.string.err2_contact));
        }

        if((!rbFemale.isChecked()) && (!rbMale.isChecked()))
        {
            isValid=false;
            Toast.makeText(getApplicationContext(),getString( R.string.err_gender),Toast.LENGTH_SHORT).show();
        }


        if(!chPlaying.isChecked()){
            if(!chReading.isChecked()){
                if(!chWriting.isChecked()){
                    Toast.makeText(getApplicationContext(), getString(R.string.err_hobby),Toast.LENGTH_SHORT).show();
                    isValid = false;
                }
            }
        }


        return isValid;
    }

    public void btnClick(View view) {
        if(isValid()){
            Toast.makeText(getApplicationContext(), getString(R.string.valid_data),Toast.LENGTH_SHORT).show();
        }
    }
}