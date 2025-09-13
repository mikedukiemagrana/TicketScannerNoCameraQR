# TicketScanner (No Camera) — Full Android Project

This is a complete Android project that embeds your `index.html` and builds a WebView APK **without** using the device camera.
It is ideal for Bluetooth QR scanners in HID (keyboard) mode.

## Build with Android Studio
1. Open the folder in Android Studio.
2. Let it sync Gradle, then `Run` on a device (USB) to install, or `Build → Build APK(s)` to produce an APK.

## Build with GitHub Actions (no local Android setup)
1. Create a new GitHub repo and push this project.
2. The included workflow `.github/workflows/android.yml` will build on each push to `main`/`master`.
3. Download `app-debug.apk` from the workflow **Artifacts**.

## Notes
- Package name: `com.banglemove.tickets` (change it in `app/build.gradle.kts` and Java/Kotlin folder path if needed).
- Min SDK 24 (Android 7). Compile/target SDK 34.
- Icons and app name are included (`Ticket Scanner`).

— Ready to ship.