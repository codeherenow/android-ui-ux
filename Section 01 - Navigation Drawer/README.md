# Using Navigation Drawers (50 mins)
This section teaches you about integrating drawers to your application using the `DrawerLayout`. You'll learn to,
  * Integrate drawers to your `Activity` with a native and support `ActionBar`.
  * Tie the drawer to the native and compatibility `Toolbar`.
  * Use multiple drawers in your layout.

Contents
--------
[01 Integrating a navigation drawer to your Activity](/01NavigationDrawer)
  * Use a `DrawerLayout` to add a navigation drawer that slides in from the left of the `Activity`.

[02 Summoning the drawer using a "Hamburger" menu button](https://github.com/codeherenow/android-uis/tree/master/Section%2001%20-%20Navigation%20Drawer/02NavigationDrawer)
  * Add a `ActionBarDrawerToggle` from the appcompat v7 library to create a "Hamburger" menu icon that toggles the drawer.

[03 Handling click events inside the drawer & handling the back button](https://github.com/codeherenow/android-uis/tree/master/Section%2001%20-%20Navigation%20Drawer/03NavigationDrawer)
  * Handle click events on the list items present in the drawer.
  * Make sure that Android's back button dismisses the drawer if it's already open.

[04 Using the drawer with a backward compatible ActionBar](https://github.com/codeherenow/android-uis/tree/master/Section%2001%20-%20Navigation%20Drawer/04NavigationDrawer)
  * Ensure that the drawer is displayed on older versions of Android that do not have a native ActionBar (API < 11).
  * We use the `ActionBarActivity` from the appcompat v7 library to achieve this.

[05 Pairing a drawer to a Toolbar](https://github.com/codeherenow/android-uis/tree/master/Section%2001%20-%20Navigation%20Drawer/05NavigationDrawer)
  * Replace the `ActionBar` with a `Toolbar` that was introduced in Android Lollipop.
  * The `Toolbar` we use is from the appcompat v7 support package.
  * Since the `Toolbar` is part of the layout, the drawer is displayed on top of the `Toolbar`.

[06 Displaying the drawer under the Toolbar](https://github.com/codeherenow/android-uis/tree/master/Section%2001%20-%20Navigation%20Drawer/06NavigationDrawer)
  * Display the drawer under the `Toolbar` by making minor changes to the layout.

[07 Changing the Toolbar text while the drawer opens & closes](https://github.com/codeherenow/android-uis/tree/master/Section%2001%20-%20Navigation%20Drawer/07NavigationDrawer)
  * We make use of the `DrawerListener` to listen for the drawer's open and close events to change the title on the `Toolbar`.

[08 Having fun with multiple drawers](https://github.com/codeherenow/android-uis/tree/master/Section%2001%20-%20Navigation%20Drawer/07NavigationDrawer)
  * Add an additional drawer that slides in from the right of the `Activity`.
  * The right drawer is summoned by using an action item on the `Toolbar`.
