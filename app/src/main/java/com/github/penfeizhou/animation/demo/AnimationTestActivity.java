package com.github.penfeizhou.animation.demo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.penfeizhou.animation.apng.APNGDrawable;
import com.github.penfeizhou.animation.avif.AVIFDrawable;
import com.github.penfeizhou.animation.gif.GifDrawable;
import com.github.penfeizhou.animation.webp.WebPDrawable;


/**
 * @Description: 作用描述
 * @Author: pengfei.zhou
 * @CreateDate: 2019/3/29
 */
public class AnimationTestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apnglib);
        LinearLayout linearLayout = findViewById(R.id.layout);
        EditText rate = findViewById(R.id.rate);
        String[] files = getIntent().getStringArrayExtra("files");
        for (String assetFile : files) {
            ImageView imageView = new ImageView(this);
            Drawable drawable = null;
            if (assetFile.endsWith("png")) {
                APNGDrawable apngDrawable = APNGDrawable.fromAsset(this, assetFile);
                float playRate = Float.parseFloat(rate.getText().toString());
                apngDrawable.setPlayRate(playRate);
                drawable = apngDrawable;
            }
            if (assetFile.endsWith("webp")) {
                drawable = WebPDrawable.fromAsset(this, assetFile);
            }
            if (assetFile.endsWith("gif")) {
                drawable = GifDrawable.fromAsset(this, assetFile);
            }
            if (assetFile.endsWith("avif")) {
                drawable = AVIFDrawable.fromAsset(this, assetFile);
            }
            imageView.setImageDrawable(drawable);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.bottomMargin = 50;
            layoutParams.topMargin = 50;
            linearLayout.addView(imageView, layoutParams);
        }
    }
}
