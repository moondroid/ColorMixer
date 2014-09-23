ColorMixer
===========
### Description
ColorMixer is a widget for choosing a color in HSV color-space.
The demo app can also be found on the [Play Store](https://play.google.com/store/apps/details?id=it.moondroid.colormixerdemo.demo)

[logo]: https://developer.android.com/images/brand/en_app_rgb_wo_45.png
[google]: https://play.google.com/store/apps/details?id=it.moondroid.colormixerdemo.demo "Play Store"
[![the google logo][logo]][google]

### Screenshot
![Demo](art/screenshot.png)


### Code Samples
For example, to show a dialog with mColor as starting color:

```java
HSLFragment fragment = HSLFragment.newInstance(mColor);
fragment.show(getFragmentManager(), "dialog");
```

Your activity has to implement ``HSLFragment.OnColorChangeListener`` through these methods:

```java
@Override
public void onColorChange(int color) {
    //called everytime the color changes
}

@Override
public void onColorConfirmed(int color) {
    //called when the user press the confirm button in the dialog
}

@Override
public void onColorCancel() {
    //called when the user press the cancel button in the dialog
}
```


### License

```
The MIT License (MIT)

Copyright (c) 2014 Marco Granatiero

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
