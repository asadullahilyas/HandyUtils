# HandyUtils
Kotlin and Android functions to make code better and life easier

[![](https://jitpack.io/v/asadullahilyas/HandyUtils.svg)](https://jitpack.io/#asadullahilyas/HandyUtils)

## Project Level Gradle

### Groovy
``` Groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### Kotlin
```` Kotlin
allprojects {
    repositories {
        ...
        maven { url = URI.create("https://jitpack.io") }
    }
}
````

## App Level Gradle

### Groovy
```` Groovy
dependencies {
    implementation 'com.github.asadullahilyas:HandyUtils:1.1.5'
}
````

### Kotlin
``` Kotlin
dependencies {
    implementation("com.github.asadullahilyas:HandyUtils:1.1.5")
}
```

## Examples

### String Extensions

Say you have a `String?` but you don't know if it is just an empty String. Kotlin's got you covered here. You can simply use `isNullOrEmpty().not()`. Oh but what if that String is not empty, but is blank. So you end up using `isNullOrEmpty().not() && isNullOrBlank().not()` for every String. There should be a function that checks both conditions, so you don't have to call two functions. With HandyUtils, now there is. You can use:
- `isNullOrEmptyOrBlank().not()`

Or even better:
- `isNeitherNullNorEmptyNorBlank()`

Other handy extnesion functions for String are:
- `toNullIfEmptyOrBlank()`
- `ifNeitherNullNorEmptyNorBlank {  }`
- `capitalizeWords()`
- `removeSpaces()`
- `toLetters()`
- `toDigits()`
- `decodeFromBase64String()`
- `urlEncode()`
- `urlDecode()`

And so many more.

### View Extensions

If you hate doing:

    someView.visibility = View.GONE

Try the following handy extension functions:

- `someView.gone()`
- `someView.invisible()`
- `someView.visible()`

Do you know bounding box of your view? Using the following handy extension attribute, now you do:

- `someView.boundingBox`

### Bitmap extensions

Remember how to save a Bitmap as file? No? You need to Google that? Don't. Just use `save()` function:

- `bitmap.save( fileToSaveBitmapTo: File )`

Converting bitmap to ByteArray?

- `bitmap.toByteArray()`

Convert bitmap to Base64 to easily send it over HTTP request?

- `bitmap.toBase64()`

Resize or compress bitmap?

    bitmap.resize(400) // Function will make sure that large side of the bitmap is 400, keeping the aspect ratio intact
    bitmap.bitmapCompression(50) // Function will reduce the size of bitmap to 50%

### CoroutineScope Extensions

Tired of doing `coroutineScope.launch(Dispatcher.IO) { }` everytime? Seems like boilerplate. How about:

- `coroutineScope.launchOnIO { }`
- `coroutineScope.launchOnMain { }`
- `coroutineScope.launchOnDefault { }`
- `coroutineScope.asyncOnIO { }`
- `coroutineScope.asyncOnMain { }`
- `coroutineScope.asyncOnDefault { }`
- `coroutineScope.withContextIO { }`
- `coroutineScope.withContextMain { }`
- `coroutineScope.withContextDefault { }`

### Float Extensions

Excellent, it has started downloading and it is sending us progress in `Float`. Let's show that progress on our `TextView`. Uh ho, the Float values are:

    0.045344512123
    0.234562312348
    0.492134123213
    0.712323532489
    0.868348129395
    0.998485213482
    1.0

We want to show our users simple numbers. But we cannot convert it to `Int`, that'll just become a whole bunch of 0s and then a 1. Uhh, now I have to study that `DecimalFormatter` again. Or maybe I don't.

    progressView.setText( floatProgress.toDecimalPoints(2) )

    0.045344512123  -> 0.04
    0.234562312348  -> 0.23
    0.492134123213  -> 0.49
    0.712323532489  -> 0.71
    0.868348129395  -> 0.86
    0.998485213482  -> 0.99
    1.0             -> 1.00

### JSONObject Extensions

Isn't it easy, to convert a `Map<*, *>` into JSONObject? You just do `JSONObject( yourMap )` and done. But what if we want to convert that `JSONObject` back to `Map<*, *>`? Well, that is easy too, after using a handy extension function:

- `yourJSONObject.toMap()`

## Conclusion

There are so many other classes and functionalities that this library contains. Just explore it. Suggest or add more to it. This is done for the amazing community of Kotlin and Android. A little something back for the good of others.
