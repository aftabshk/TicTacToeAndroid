package com.example.androidbasics;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public TextView createCell() {
        GradientDrawable border = new GradientDrawable();
        border.setColor(Color.parseColor("#F0ECCF"));
        border.setStroke(1, 0xFF000000);

        TextView cell = new TextView(this);
        cell.setText("");
        cell.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
        cell.setGravity(Gravity.CENTER);
        cell.setBackground(border);

        return cell;
    }

    public LinearLayout createRow() {
        LinearLayout row = new LinearLayout(this);
        row.setLayoutParams(new LinearLayout.LayoutParams(600, 200));
        row.setOrientation(LinearLayout.HORIZONTAL);
        Arrays.asList(this.createCell(), this.createCell(), this.createCell()).forEach(row::addView);

        return row;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = findViewById(R.id.board);
        layout.addView(this.createRow());
        layout.addView(this.createRow());
        layout.addView(this.createRow());
    }
}
