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

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * @author Ragunath Jawahar <www.codeherenow.com>
 */
public class CircularProgressBar extends View {
    // Constants
    private static final float STROKE_THICKNESS_FRACTION = 0.075f;
    private static final float TEXT_SIZE_FRACTION = 0.30f;
    private static final int COLOR_DEFAULT_BACKGROUND = 0xffababab;
    private static final int COLOR_DEFAULT_FOREGROUND = 0xff6a8afe;
    private static final float MAX_VALUE = 100;
    private static final int ANIMATION_DURATION = 800;

    // Attributes
    private float mStrokeThickness;
    private RectF mCircleBounds;
    private float mTextSize;
    private Rect mTextBounds;
    private Paint mPaint;

    private float mValue;
    private int mTextColor;
    private int mBarBackgroundColor;
    private int mBarForegroundColor;
    private int mBarSuppliedForegroundColor = -1;

    // Animation
    private ValueAnimator mValueAnimator;
    private ValueAnimator mColorAnimator;
    private ColorSupplier mColorSupplier;

    /*
     * We need to override at least one of the constructors. Here, we override the simplest of all.
     * The constructor that takes in a {@link android.content.Context} parameter.
     */
    public CircularProgressBar(Context context) {
        this(context, null);
    }

    /*
     * This constructor is required to inflate the custom View from XML. Make sure to include the
     * constructor with a `Context` parameter and an `AttributeSet` parameter. Also chaining
     * constructor calls is a best practice.
     */
    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mCircleBounds = new RectF();
        mTextBounds = new Rect();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setTextAlign(Paint.Align.CENTER);

        // Retrieve XML attribute values
        obtainXmlAttributes(context, attributeSet);

        // Animation
        mValueAnimator = ValueAnimator.ofFloat(0, mValue);

        /*
         * The interpolator takes care of the changing values against the given time
         * interval.
         */
        mValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

        mValueAnimator.setDuration(ANIMATION_DURATION);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
    }

    /*
     * All drawing is done inside this method. The View automatically manages the Canvas and the
     * Bitmap objects for you. So, you don't have to worry about those.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeThickness);

        // Background
        mPaint.setColor(mBarBackgroundColor);
        canvas.drawOval(mCircleBounds, mPaint);

        // Foreground
        mPaint.setColor(mColorSupplier == null
                ? mBarForegroundColor : mBarSuppliedForegroundColor);
        float sweepAngle = mValue / MAX_VALUE * 360;
        canvas.drawOval(mCircleBounds, mPaint);

        // Text
        mPaint.setTextSize(mTextSize);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mTextColor);

        String text = (int) mValue + "%";
        mPaint.getTextBounds(text, 0, text.length(), mTextBounds);
        int textHeight = mTextBounds.height();
        canvas.drawText(text,
                mCircleBounds.centerX(),
                mCircleBounds.centerY() + textHeight / 2,
                mPaint);
    }

    /**
     * This is the method where we calculate the logical coordinates for our View.
     * The {@code onSizeChanged(int, int, int, int)} method is called ONLY when the size of the
     * view changes. Therefore, this is the right place to update metrics.
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Stroke Width
        int diameter = Math.min(w, h);
        mStrokeThickness = diameter * STROKE_THICKNESS_FRACTION;

        // Square
        float boundingSquareSide = diameter - mStrokeThickness;
        float halfViewWidth = w / 2;
        float halfViewHeight = h / 2;
        float halfBoundingSquareSide = boundingSquareSide / 2;

        // Circle & Arc Bounds
        mCircleBounds.left = halfViewWidth - halfBoundingSquareSide;
        mCircleBounds.top = halfViewHeight - halfBoundingSquareSide;
        mCircleBounds.right = halfViewWidth + halfBoundingSquareSide;
        mCircleBounds.bottom = halfViewHeight + halfBoundingSquareSide;

        // Text Size
        mTextSize = diameter * TEXT_SIZE_FRACTION;
    }

    public float getValue() {
        return mValue;
    }

    /*
     * Animate values using the value animator.
     */
    public void setValue(float value) {
        startAnimation(value);
    }

    /*
     * Set a color supplier instance that would get colors for the given value.
     */
    public void setColorSupplier(ColorSupplier colorSupplier) {
        if (colorSupplier != null && mColorAnimator == null) {
            mColorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(),
                    mBarForegroundColor, colorSupplier.getColor(mValue));
            mColorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mBarSuppliedForegroundColor = (int) animation.getAnimatedValue();
                }
            });
        }
        this.mColorSupplier = colorSupplier;
    }

    private void obtainXmlAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = context.obtainStyledAttributes(attributeSet,
                        R.styleable.CircularProgressBar);
                mTextColor = typedArray.getColor(R.styleable.CircularProgressBar_android_textColor,
                        Color.BLACK);
                mBarBackgroundColor = typedArray.getColor(
                        R.styleable.CircularProgressBar_barBackgroundColor,
                        COLOR_DEFAULT_BACKGROUND);
                mBarForegroundColor = typedArray.getColor(
                        R.styleable.CircularProgressBar_barForegroundColor,
                        COLOR_DEFAULT_FOREGROUND);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    private void startAnimation(float value) {
        if (mValueAnimator.isRunning()) {
            mValueAnimator.cancel();
        }
        if (mColorAnimator != null && mColorAnimator.isRunning()) {
            mColorAnimator.cancel();
        }

        // Start value animator
        mValueAnimator.setFloatValues(mValue, value);
        mValueAnimator.start();

        // Start color animator
        if (mColorSupplier != null) {
            int startColor = mBarSuppliedForegroundColor != -1
                    ? mBarSuppliedForegroundColor : mBarForegroundColor;
            int endColor = mColorSupplier.getColor(value);
            mColorAnimator.setIntValues(startColor, endColor);
            mColorAnimator.start();
        }
    }

    /**
     * Implement this interface to supply colors based on your values.
     */
    public interface ColorSupplier {
        int getColor(float value);
    }
}
