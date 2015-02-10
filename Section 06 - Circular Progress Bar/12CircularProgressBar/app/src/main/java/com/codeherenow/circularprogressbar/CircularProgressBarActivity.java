/*
 * Copyright (C) 2015 Code Here Now
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codeherenow.circularprogressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

/**
 * This is an example on creating custom views for Android.
 *
 * @author Ragunath Jawahar <www.codeherenow.com>
 */
public class CircularProgressBarActivity extends Activity {

    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_progress_bar);
        mRandom = new Random();

        final CircularProgressBar circularProgressBar =
                (CircularProgressBar) findViewById(R.id.circularProgressBar);
        circularProgressBar.setColorSupplier(new MyColorSupplier());

        // Event Listener
        circularProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = mRandom.nextInt(101);
                circularProgressBar.setValue(value);
            }
        });
    }

    /*
     * This is our implementation of the `ColorSupplier`. We supply 4 different colors
     * for 4 different ranges.
     */
    static class MyColorSupplier implements CircularProgressBar.ColorSupplier {

        @Override
        public int getColor(float value) {
            int color;
            if (value <= 30) {
                color = 0xfff44224;
            } else if (value <= 60) {
                color = 0xffffb74c;
            } else if (value <= 85) {
                color = 0xff6a8afe;
            } else {
                color = 0xff42bd41;
            }
            return color;
        }
    }
}
