# First Custom View - Circular Progress Bar

The following set of tutorials will teach you,
  * To get metrics for your custom view from a reference design.
  * Measure the logical coordinates for your `View` dynamically.
  * Draw your custom `View` using the Android Canvas API.
  * Perform animations using `ValueAnimator` and `TypeEvaluator`.

Contents
--------
11 [View measurements - The right way to do it!](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/11CircularProgressBar)
  * Calculate the logical metrics required for drawing the `View` inside the `onSizeChanged()` method.

12 [Drawing the Progress Bar](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/12CircularProgressBar)
  * Offset the `RectF` coordiantes to contain the progress bar inside the `View`.
  * Draw reference lines to visually debug your drawing.

13 [Centre the Progress Bar inside the View](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/13CircularProgressBar)
  * Move the `RectF` to the center, thereby positioning the `CircularProgressBar` to the center of the `View`.

14 [Inflating your Custom View from XML](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/14CircularProgressBar)
  * Override a constructor from the `View` class that takes in an `AttributeSet` parameter in order to inflate the custom `View` from XML.

15 [Updating values and redrawing the Progress Bar](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/15CircularProgressBar)
  * Calculate the sweep angle based on the value provided by the user.
  * Redraw the progress bar with the new value by calling the `invalidate()` method.

17 [Displaying the progress value text](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/17CircularProgressBar)
  * Draw the value text at the center of the `View`.
  * Measure text size and use `Paint.Align.CENTER` to align the text to the center of the `View`.

18 [Animating the Progress Bar using a Value Animator](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/18CircularProgressBar)
  * Use a `ValueAnimator` with an `AnimatorUpdateListener` to animate the progress bar when the value changes.

19 [Making it real with Interpolators](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/19CircularProgressBar)
  * Experiment with different interpolaters like `AccelerateDecelerateInterpolator`, `LinerIntepolator` and `OvershootInterpolator` for different animation effects.

20 [Adding additional XML attributes to the Custom View](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/20CircularProgressBar)
  * Learn to use a `styleable` resource to declare XML attributes for your `View`.
  * Retrieve XML attributes using the `AttributeSet` and `TypedArray`.

21 [Making it snazzier - Animating Colors](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/21CircularProgressBar)
  * Use a `ArgbEvaluator` and a `ValueAnimator` to animate between colors.

22 [Will this run on older Androids? - Handling backward compatibility](https://github.com/codeherenow/android-uis/tree/master/Section%2002%20-%20Circular%20Progress%20Bar/22CircularProgressBar)
  * Isolate API specific code and prevent execution in older Android versions.
  * Provide alternate functionality for backward compatibility.
