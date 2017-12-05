# Age-Calculate-Kotlin

Sample Android application is written in Kotlin. Calculates the Age difference between two dates.

### INTRODUCTION ###

Kotlin is a great fit for developing Android applications, bringing all of the advantages of a modern language to the Android platform without introducing any new restrictions:

* **Compatibility**: Kotlin is fully compatible with JDK 6, ensuring that Kotlin applications can run on older Android devices with no issues. The Kotlin tooling is fully supported in Android Studio and compatible with the Android build system.

* **Performance**: A Kotlin application runs as fast as an equivalent Java one, thanks to very similar bytecode structure. With Kotlin's support for inline functions, code using lambdas often runs even faster than the same code written in Java.

* **Interoperability**: Kotlin is 100% interoperable with Java, allowing to use all existing Android libraries in a Kotlin application. This includes annotation processing, so databinding and Dagger work too.

* **Footprint**: Kotlin has a very compact runtime library, which can be further reduced through the use of ProGuard. In a real application, the Kotlin runtime adds only a few hundred methods and less than 100K to the size of the .apk file.

* **Compilation Time**: Kotlin supports efficient incremental compilation, so while there's some additional overhead for clean builds, incremental builds are usually as fast or faster than with Java.

* **Learning Curve**: For a Java developer, getting started with Kotlin is very easy. The automated Java to Kotlin converter included in the Kotlin plugin helps with the first steps. Kotlin Koans offer a guide through the key features of the language with a series of interactive exercises.

For more detaials about kotlin [click here](https://kotlinlang.org/docs/tutorials/).

### BUILD REQUIREMENTS ###

 - JDK 1.8
 - [Android SDK](http://developer.android.com/sdk/index.html).
 - Android N [(API 24) ](http://developer.android.com/tools/revisions/platforms.html).
 - Latest Android SDK Tools and build tools.
 - [kotlin-android ](https://kotlinlang.org/docs/reference/using-gradle.html)
 - [kotlin-android-extensions ](https://kotlinlang.org/docs/tutorials/android-plugin.html)
 
### PROJECT ARCHITECTURE ###

This project follows Android architecture guidelines that are based on [MVP (Model View Presenter)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter). Read more about them [here](https://github.com/ribot/android-guidelines/blob/master/architecture_guidelines/android_architecture.md). 


### RUNTIME REQUIREMENTS ###

Android in portrait mode running API level 16 or above

### LIBRARIES USED ###

**Joda Time**

Joda-Time provides a quality replacement for the Java date and time classes.

Joda-Time is the de facto standard date and time library for Java prior to Java SE 8. Users are now asked to migrate to java.time (JSR-310) [more](http://www.joda.org/joda-time/) . 


