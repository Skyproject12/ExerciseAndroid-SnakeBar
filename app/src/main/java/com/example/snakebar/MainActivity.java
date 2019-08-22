package com.example.snakebar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleBottomSheetDialog.BottomListener {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOpen= findViewById(R.id.button_open);
        textView= findViewById(R.id.text_status);
        buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleBottomSheetDialog buttonSheet= new ExampleBottomSheetDialog();
                buttonSheet.show(getSupportFragmentManager(),"exampleBottomSheet");
            }
        });
    }

    @Override
    public void onButtonClicked(String text) {
        textView.setText(text);
    }
}
