# HandyUtils
Kotlin and Android functions to make code better and life easier

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
    implementation 'com.github.asadullahilyas:HandyUtils:0.0.7'
}
````

### Kotlin
``` Kotlin
dependencies {
    implementation("com.github.asadullahilyas:HandyUtils:0.0.7")
}
```