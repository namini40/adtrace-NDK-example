package io.adtrace.ndkexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    public native String getAppToken();

    public native long[] getSignatures();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        Button btn_token = findViewById(R.id.btn_token);
        Button btn_signature = findViewById(R.id.btn_signature);

        tv.setText("click on buttons");
        btn_token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                text = String.format("app token (coming from C++): %s", getAppToken());
                tv.setText(text);
            }
        });
        btn_signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                long[] signatures = getSignatures();
                text = String.format("signatures (coming from C++)\nsecret id: %d\ninfo1: %d\ninfo2: %d\ninfo3: %d\ninfo4: %d",
                        signatures[0],
                        signatures[1],
                        signatures[2],
                        signatures[3],
                        signatures[4]
                );
                tv.setText(text);
            }
        });


    }

}