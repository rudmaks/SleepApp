Minimal Android app that runs a script as root and exits immediately.

The app has no user interface. Upon launch it executes
su -c "sh /data/local/scripts/sleep.sh" via Magisk and then calls finish().

Compatible with Android 10 (API 29) and above, including Android 14. Tested on:

    Samsung J5 2016 (j5xnlte), LineageOS 17.1 (Android 10), Magisk v26.4

    Samsung SM-A032F, LineageOS 21 (Android 14), Magisk v30.7
