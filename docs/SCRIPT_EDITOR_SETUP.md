# iChat in Script Editor Apps (Acode/SPCK/Code Editor)

If you are using a mobile or lightweight script editor app, use this workflow:

## 1) Required tools
- A text editor app (Acode / SPCK / Code Editor)
- Termux (or Linux shell) for Gradle commands
- JDK 17
- Android SDK + build tools (or run builds in GitHub Actions)

## 2) Open the project
- Open the root folder of iChat.
- Edit normal **Groovy Gradle files** (this project now uses `build.gradle`, `settings.gradle`, and `app/build.gradle`) because many script editor apps handle Groovy better than Kotlin DSL.

## 3) Configure mirrors/proxy if needed
If your network blocks Google Maven, add in `~/.gradle/gradle.properties`:

```properties
GOOGLE_MAVEN_MIRROR=https://<your-google-mirror>
MAVEN_CENTRAL_MIRROR=https://<your-maven-central-mirror>
```

(Use proxy settings from `docs/BUILD_TROUBLESHOOTING.md` when needed.)

## 4) Build commands
Run from project root:

```bash
gradle --refresh-dependencies
gradle :app:assembleDebug
gradle :app:installDebug
```

## 5) If local Android SDK is hard on phone
Use cloud/CI build:
- Push code to GitHub.
- Run Android build in GitHub Actions.
- Download generated APK artifact.

## 6) Next development steps
- Add Auth screen and OTP flow.
- Add chat room screen and send message actions.
- Add local Room database.
- Integrate realtime backend (WebSocket) and push notifications.
