package sg.edu.rp.c346.id20013327.demomyprofilel08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;
    TextView tvName, tvGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGPA = findViewById(R.id.etGPA);
        tvName = findViewById(R.id.tvName);
        tvGPA = findViewById(R.id.tvGPA);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("Name", "John Doe"); //Key must be the same from the one that is below
        Float gpa = prefs.getFloat("GPA", 4.0f); //Key must be the same from the one below
        etName.setText(name);
        etGPA.setText(gpa + "");

    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());
//        Double gpa = Double.parseDouble(etGPA.getText().toString());
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEdit = prefs.edit();
        prefsEdit.putString("Name", strName); //Set the strName to what key
        prefsEdit.putFloat("GPA", gpa); //Set the gpa to what key
        prefsEdit.commit();
    }
}