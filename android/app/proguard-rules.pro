-keepattributes *Annotation*,SourceFile,LineNumberTable,Signature,Exceptions,InnerClasses,EnclosingMethod

-keep class com.follow.clashx.models.** { *; }
-keep class com.follow.clashx.core.** { *; }
-keep class com.follow.clashx.plugins.** { *; }
-keep class com.follow.clashx.services.** { *; }
-keep class com.follow.clashx.widgets.** { *; }
-keep class com.follow.clashx.FlClashXApplication { *; }
-keep class com.follow.clashx.MainActivity { *; }
-keep class com.follow.clashx.TempActivity { *; }
-keep class com.follow.clashx.FilesProvider { *; }
-keep class com.follow.clashx.GlobalState { *; }

-dontwarn com.follow.clashx.**
-dontwarn com.google.gson.**
