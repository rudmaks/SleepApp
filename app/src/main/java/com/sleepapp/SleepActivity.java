package com.sleepapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SleepActivity extends Activity {

    private static final String TAG = "SleepApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            /*
             * Runtime.exec() запускает процесс и НЕМЕДЛЕННО возвращает управление.
             * Процесс "su" (Magisk daemon) продолжает работу независимо от Activity.
             * Вызов finish() после exec() НЕ прерывает запущенный скрипт.
             *
             * Этот подход работает на Magisk v26+ и v30+.
             * Android 14 не добавляет ограничений на Runtime.exec() с su.
             * Ограничения Android 14 касаются Intent (implicit/mutable), а не процессов.
             * Источник: developer.android.com/about/versions/14/behavior-changes-14
             */
            Runtime.getRuntime().exec(new String[]{
                "su",
                "-c",
                "sh /data/local/scripts/sleep.sh"
            });
        } catch (Exception e) {
            // Логируем, но не показываем UI — приложение всё равно закроется
            Log.e(TAG, "exec failed: " + e.getMessage());
        }

        // Закрываем Activity немедленно
        finish();
    }
}
