package com.example.arakjel.frescopoc;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;

public class MainActivity extends AppCompatActivity {

    private Button uriButton;
    private Button resourceButton;
    private Button exitApplicationButton;
    private SimpleDraweeView simpleDraweeView;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        initialize();
        listeners();
    }

    private void initialize() {
        uriButton = (Button) findViewById(R.id.uriButton);
        resourceButton = (Button) findViewById(R.id.resourceButton);
        exitApplicationButton = (Button) findViewById(R.id.exitApplicationButton);
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.sdvImage);
    }

    private void listeners() {
        uriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageUri = Uri.parse("https://i.imgur.com/tGbaZCY.jpg");
                simpleDraweeView.setImageURI(imageUri);
            }
        });

        resourceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = "res:/" + R.drawable.img_poc;
                simpleDraweeView.setImageURI(Uri.parse(path));
            }
        });

        exitApplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
