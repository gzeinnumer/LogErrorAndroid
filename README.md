<p align="center">
  <img src="https://dafunda.com/wp-content/uploads/2019/10/Aplikasi-sering-force-close-min.jpg"/>
</p>

<h1 align="center">
LogErrorAndroid
</h1>

<div align="center">
    <a><img src="https://img.shields.io/badge/Version-1.0.0-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/Kotlin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Function to make Logs File if your app get <b>Force Close</b>, so you can track if error happen to your app in production.</p>
</div>

---
# Content List
* [Download](#download)
* [Feature List](#feature-list)
* [Tech stack and 3rd library](#tech-stack-and-3rd-library)
* [Usage](#usage)
* [Example Code/App](#example-codeapp)
* [Version](#version)
* [Contribution](#contribution)

---
# Download
Add maven `jitpack.io` and `dependencies` in build.gradle (Project) :
```gradle
// build.gradle project
allprojects {
  repositories {
    google()
    jcenter()
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.github.gzeinnumer:LogErrorAndroid:versi'
}
```

---
# Feature List
- [x] **Make Log File** like logcat in **Android Studio**.

---
# Tech stack and 3rd library
- File ([docs](https://developer.android.com/reference/java/io/File))
- MultiPermission ([docs](https://github.com/gzeinnumer/MultiPermition))

---
# Usage

### Function Log Error
> Example : MBUtilsLogError.initFileLogError(valueString);

| Name               | Return    | Parameter                            | Desc    |
| ------------------ | --------- | ------------------------------------ | ------------- |
| `initFileLogError` | `void`    | `String appName, String logLocation` | Function to make Logs File if your app get `Force Close` and you can put file in external. |

**This library need permission. You can use your own way to get permission, or you can use my repo, here is my repository ([MultiPermission](https://github.com/gzeinnumer/MultiPermition2)) (Follow Step 1 - Step 9)** :

#### DEBUG.
If you find trouble and this library doesn't work, you can trace error with this log in logcat.
|![](https://github.com/gzeinnumer/LogErrorAndroid/blob/master/assets/debug.jpg)|
|--|

#
#### Step 1.
If you has get permission, you can run function `onSuccessCheckPermitions` inside `onRequestPermissionsResult`.
**Remember : You only need use this function 1 TIME in your FirstActivity(on Manifest) or Activity that you use to request permission**:

```java
public class MainActivity extends AppCompatActivity {

    ...

    private void onSuccessCheckPermitions() {
        //   /storage/emulated/0/MyLibsTesting
        String appName = getResources().getString(R.string.app_name);
        //   /storage/emulated/0/MyLibsTesting/logs
        String logLocation = "/logs";
        MBUtilsLogError.initFileLogError(appName, logLocation);
    }

    ...

}
```

#
#### Step 2.

Preview :
|![](https://github.com/gzeinnumer/LogErrorAndroid/blob/master/assets/example1.jpg)|![](https://github.com/gzeinnumer/LogErrorAndroid/blob/master/assets/example2.jpg)|![](https://github.com/gzeinnumer/LogErrorAndroid/blob/master/assets/example3.jpg)|
|--|--|--|
|Request Permission|If `Force Close` happen|Folder `MyLibsTesting` created|

|![](https://github.com/gzeinnumer/LogErrorAndroid/blob/master/assets/example4.jpg)|![](https://github.com/gzeinnumer/LogErrorAndroid/blob/master/assets/example5.jpg)|
|--|--|
|Folder `Logs` created inside `MyLibsTesting`|File log created(if your app `Force Close`)|

|![](https://github.com/gzeinnumer/LogErrorAndroid/blob/master/assets/example6.jpg)|
|--|
|Looks like logcat on Android Studio|

---
## Example Code/App

**FullCode [MainActivity](https://github.com/gzeinnumer/LogErrorAndroid/blob/master/example/MainActivity.java)**

---

## Version
- **0.0.3**
  - First Release
- **1.0.0**
  - First Release

---

## Contribution
You can sent your constibution to `branch` `open-pull`.

---

```
Copyright 2020 M. Fadli Zein
```
