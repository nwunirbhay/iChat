# Build Troubleshooting (Android Gradle Plugin artifact not found)

If you see:

- `Plugin [id: 'com.android.application', version: 'x.y.z'] was not found`
- `could not resolve plugin artifact 'com.android.application:com.android.application.gradle.plugin:...'`

then the issue is usually **repository connectivity**, not your Kotlin code.

## Why it happened here

In this environment, requests to Google Maven returned HTTP 403 through a proxy tunnel, so Gradle could not download Android Gradle Plugin artifacts.

## Quick checks

```bash
# 1) Check if Google Maven is reachable
curl -I "https://dl.google.com/dl/android/maven2/com/android/application/com.android.application.gradle.plugin/8.4.2/com.android.application.gradle.plugin-8.4.2.pom"

# 2) Run Gradle with more logging
gradle -S -i projects
```

## Fix options

### Option A (Recommended): use normal internet access
- Ensure your machine can reach:
  - `https://dl.google.com/dl/android/maven2/`
  - `https://repo.maven.apache.org/maven2/`
  - `https://plugins.gradle.org/`
- If behind corporate proxy, configure `~/.gradle/gradle.properties`:

```properties
systemProp.http.proxyHost=<proxy-host>
systemProp.http.proxyPort=<proxy-port>
systemProp.https.proxyHost=<proxy-host>
systemProp.https.proxyPort=<proxy-port>
```

### Option B: use internal mirrors
This project now supports mirror override via Gradle properties:

```properties
# ~/.gradle/gradle.properties or project gradle.properties
GOOGLE_MAVEN_MIRROR=https://<your-google-mirror>
MAVEN_CENTRAL_MIRROR=https://<your-maven-central-mirror>
```

Then run:

```bash
gradle clean :app:assembleDebug
```

### Option C: use Android Studio
Android Studio can sometimes auto-handle proxy/auth settings better than CLI Gradle.

## After connectivity is fixed

Run these commands:

```bash
gradle --refresh-dependencies
gradle :app:assembleDebug
gradle :app:testDebugUnitTest
```
