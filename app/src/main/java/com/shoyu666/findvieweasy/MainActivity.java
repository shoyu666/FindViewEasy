package com.shoyu666.findvieweasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.shoyu666.findviewlib.BindView;
import com.shoyu666.findviewlib.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textview)
    public TextView textview;

    @BindView(R.id.button)
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        textview.setText("xxxxxxxxxxxxxxx");
        button.setText("bbbbbbbbbbbbbbb");
    }
}
