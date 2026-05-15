-keepattributes *Annotation*,SourceFile,LineNumberTable,Signature,Exceptions,InnerClasses,EnclosingMethod

-keep class com.follow.clashx.core.** { *; }

-keepclassmembers class * {
    native <methods>;
}

-dontwarn com.follow.clashx.**
