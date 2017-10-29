# Magic Icon
&nbsp;
Icon view and Icon button for android; change icon color on runtime.

&nbsp;
### Features!
- Icon Font - Google Material Icons,  Font Awesome, ionicons
- Drawable resource
- Icon shape - rectangle, circle
- Border - color and width
- Radius
- Change icon color

&nbsp;
### Screenshot
![Magic Icon Screenshot](https://raw.githubusercontent.com/alex31n/Magic-Icon/master/Assets/icon_screenshot_01.png)

&nbsp;
### Install

&nbsp;
##### Gradle 

```
dependencies {
        compile 'com.ornach.magicicon:magic-icon:1.4'
}
```

&nbsp;
##### or Maven

```
<dependency>
    <groupId>com.ornach.magicicon</groupId>
    <artifactId>magic-icon</artifactId>
    <version>1.4</version>
    <type>pom</type>
</dependency>
```

&nbsp;
## Use

&nbsp;
#### XML
Include namespace to the root View/Layout :
```
xmlns:app="http://schemas.android.com/apk/res-auto"
```
Icon View with custom params
```
<com.ornach.magicicon.IconView
    android:layout_width="50dp"
    android:layout_height="50dp"
    android:layout_marginRight="10dp"
    app:mi_backgroundColor="#3A559F"
    app:mi_fontText="&#xf09a;"
    app:mi_typeface="font_awesome"
    app:mi_iconColor="#FFF"
    app:mi_radius="8dp"
    app:mi_shape="rectangle"/>
```

Icon Button with custom params
```
<com.ornach.magicicon.IconButton
    android:layout_width="60dp"
    android:layout_height="60dp"
    android:layout_marginRight="20dp"
    app:mi_borderColor="#00897B"
    app:mi_borderWidth="4dp"
    app:mi_focusColor="#60E9DB"
    app:mi_fontText="&#xf09a;"
    app:mi_typeface="font_awesome"
    app:mi_iconColor="#00897B"
    app:mi_shape="oval"/>
```

&nbsp;
## Fonts
In this porject I have used third party fonts and they have separate licenses. So before use, please see their license.

[Google Material icons](https://material.io/icons/) licensed under the [Apache License 2.0](https://github.com/google/material-design-icons/blob/master/LICENSE)

[Font Awesome](http://fontawesome.io/cheatsheet/) and open source license http://fontawesome.io/license/

[ionicons](http://ionicons.com/cheatsheet.html) licensed under the [MIT License](https://github.com/ionic-team/ionicons/blob/master/LICENSE)


&nbsp;
&nbsp;
## License
    Copyright 2017 Alex Beshine
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and limitations under the License.
