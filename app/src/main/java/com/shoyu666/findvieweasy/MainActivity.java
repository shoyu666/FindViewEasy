package com.shoyu666.findvieweasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shoyu666.findviewlib.BindView;
import com.shoyu666.findviewlib.ButterKnife;
import com.shoyu666.findviewlib.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    @OnClick({R.id.button, R.id.textview})
    public void onClick(View v) {
        Toast.makeText(this, "触发点击", Toast.LENGTH_LONG).show();
    }
}
