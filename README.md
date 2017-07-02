# Magic Icon
&nbsp;
Icon view and Icon button for android; change icon color on runtime.

&nbsp;
### Features!
- Font Awesome Icon
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
#### Gradle 

```
dependencies {
        compile 'com.ornach.magicicon:magic-icon:1.3'
}
```

&nbsp;
#### Maven

```
<dependency>
    <groupId>com.ornach.magicicon</groupId>
    <artifactId>magic-icon</artifactId>
    <version>1.3</version>
    <type>pom</type>
</dependency>
```

&nbsp;
### Use

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
    app:mi_fontAwesome="&#xf09a;"
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
    app:mi_fontAwesome="&#xf061;"
    app:mi_iconColor="#00897B"
    app:mi_shape="oval"/>
```

&nbsp;
#### Font Awesome Icon

Cheatsheet http://fontawesome.io/cheatsheet/

Note: before use **font awesome** please see their license http://fontawesome.io/license/


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
