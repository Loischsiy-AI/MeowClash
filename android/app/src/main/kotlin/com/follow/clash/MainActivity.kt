package com.follow.clash

import android.content.Context
import com.follow.clash.plugins.AppPlugin
import com.follow.clash.plugins.ServicePlugin
import com.follow.clash.plugins.TilePlugin
import com.follow.clash.plugins.VpnPlugin
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity : FlutterActivity() {
    companion object {
        private const val MAIN_ENGINE_ID = "meowclash_main_engine"
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine {
        val engineCache = FlutterEngineCache.getInstance()
        return engineCache.get(MAIN_ENGINE_ID) ?: createAndCacheEngine(context, engineCache)
    }

    private fun createAndCacheEngine(context: Context, cache: FlutterEngineCache) =
        FlutterEngine(context.applicationContext).apply {
            GeneratedPluginRegistrant.registerWith(this)
            dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
            cache.put(MAIN_ENGINE_ID, this)
            GlobalState.flutterEngine = this
        }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        listOf(VpnPlugin, AppPlugin(), ServicePlugin(), TilePlugin()).forEach { plugin ->
            if (flutterEngine.plugins.get(plugin.javaClass) == null) {
                flutterEngine.plugins.add(plugin)
            }
        }

        GlobalState.flutterEngine = flutterEngine
    }

    override fun shouldDestroyEngineWithHost(): Boolean = false
}
