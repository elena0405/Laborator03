package lab03.eim.systems.cs.pub.ro;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import lab03.eim.systems.cs.pub.ro.R;

public class PhoneDialerActivity extends AppCompatActivity {

    private EditText phone_number_edit_text;
    private ImageButton call_button;
    private ImageButton decline_call_button;
    private ImageButton erase_button;
    private Button b_star, b_diez, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;

    private CallingButtonClickListener callButtonClickListener = new CallingButtonClickListener();
    private DeclineCallButtonClickListener declineCallButtonClickListener = new DeclineCallButtonClickListener();
    private EraseNumberButtonClickListener eraseNumberButtonClickListener = new EraseNumberButtonClickListener();
    private PhoneNumberButtonClickListener phoneNumberButtonClickListener = new PhoneNumberButtonClickListener();

    private class CallingButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        PhoneDialerActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phone_number_edit_text.getText().toString()));
                startActivity(intent);
            }
        }
    }

    private class DeclineCallButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            finish();
        }
    }

    private class EraseNumberButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int l = phone_number_edit_text.getText().toString().length();
            if (l > 0) {
                phone_number_edit_text.setText(phone_number_edit_text.getText().toString().substring(0, l - 1));
            }
        }
    }

    private class PhoneNumberButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            phone_number_edit_text.setText(phone_number_edit_text.getText().toString() + ((Button)view).getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        phone_number_edit_text = findViewById(R.id.phone_number_edit_text);

        call_button = findViewById(R.id.call_button);
        call_button.setOnClickListener(callButtonClickListener);

        decline_call_button = findViewById(R.id.decline_button);
        decline_call_button.setOnClickListener(declineCallButtonClickListener);

        erase_button = findViewById(R.id.erase_button);
        erase_button.setOnClickListener(eraseNumberButtonClickListener);

        b0 = findViewById(R.id.number_0_button);
        b0.setOnClickListener(phoneNumberButtonClickListener);

        b1 = findViewById(R.id.number_1_button);
        b1.setOnClickListener(phoneNumberButtonClickListener);

        b2 = findViewById(R.id.number_2_button);
        b2.setOnClickListener(phoneNumberButtonClickListener);

        b3 = findViewById(R.id.number_3_button);
        b3.setOnClickListener(phoneNumberButtonClickListener);

        b4 = findViewById(R.id.number_4_button);
        b4.setOnClickListener(phoneNumberButtonClickListener);

        b5 = findViewById(R.id.number_5_button);
        b5.setOnClickListener(phoneNumberButtonClickListener);

        b6 = findViewById(R.id.number_6_button);
        b6.setOnClickListener(phoneNumberButtonClickListener);

        b7 = findViewById(R.id.number_7_button);
        b7.setOnClickListener(phoneNumberButtonClickListener);

        b8 = findViewById(R.id.number_8_button);
        b8.setOnClickListener(phoneNumberButtonClickListener);

        b9 = findViewById(R.id.number_9_button);
        b9.setOnClickListener(phoneNumberButtonClickListener);

        b_star = findViewById(R.id.star_button);
        b_star.setOnClickListener(phoneNumberButtonClickListener);

        b_diez = findViewById(R.id.diez_button);
        b_diez.setOnClickListener(phoneNumberButtonClickListener);
    }
}