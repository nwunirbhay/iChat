# iChat (Android)

iChat is a production-oriented Android messaging app starter inspired by the core UX principles seen in WeChat-class apps: fast chat list, simple navigation, responsive messaging, and extensible architecture.

> ⚠️ This repository gives you a strong **foundation + production workflow**. A globally deployed public chat product still requires backend infra, security hardening, moderation, legal compliance, and staged rollout.

## 1) Product scope (MVP -> Public launch)

### MVP features
- Phone/email auth + OTP + session management.
- 1:1 chat, group chat, message status (sent/delivered/seen).
- Media attachments (image/video/doc).
- Push notifications.
- Contact discovery and profile.

### V1 public launch features
- End-to-end encryption for personal chats.
- Voice/video calling.
- Message reactions, replies, edit/delete.
- Admin moderation tooling.
- Abuse reporting, account recovery, and trust/safety operations.

## 2) Tech stack recommendation

### Android app
- **Kotlin + Jetpack Compose**.
- **MVVM + Repository pattern**.
- **Navigation Compose**.
- **Room** for offline caching.
- **WorkManager** for sync/retry/background uploads.
- **Firebase Cloud Messaging (FCM)** for push.

### Backend (recommended)
- Kotlin Ktor / Node.js NestJS / Go Fiber (pick one).
- PostgreSQL for relational core.
- Redis for presence, ephemeral state, and queues.
- Object storage (S3/GCS) for media.
- WebSocket gateway for realtime delivery.
- Kafka/RabbitMQ for async events.

## 3) Architecture blueprint

- `app/` contains Android app shell and sample chat list implementation.
- Build this forward into modules:
  - `feature-auth`
  - `feature-chat-list`
  - `feature-chat-room`
  - `feature-calls`
  - `core-network`
  - `core-db`
  - `core-crypto`

See `docs/PRODUCTION_WORKFLOW.md` and `docs/BACKEND_API_SPEC.md` for full workflow.

## 4) Local setup

1. Install Android Studio (latest stable).
2. Install JDK 17.
3. Open this folder as a Gradle project.
4. Run on Android 8+ emulator/device.

## 5) Suggested execution roadmap

1. Finalize PRD + threat model.
2. Implement auth + device binding.
3. Add websocket messaging + store-and-forward.
4. Add media uploads + antivirus scanning.
5. Add encryption + key rotation.
6. Add observability (metrics, traces, logs).
7. Run security tests + load tests.
8. Staged rollout (internal -> beta -> public).

## 6) Important legal/compliance checklist

- Privacy policy + terms.
- Data retention and deletion controls.
- Regional compliance (GDPR/CCPA/local telecom rules).
- Lawful request handling process.
- CSAM and abuse-report pipeline (if required by market).


## 7) Build failure: Android Gradle Plugin artifact not found

If Gradle cannot resolve `com.android.application` plugin artifacts, see `docs/BUILD_TROUBLESHOOTING.md` for proxy/mirror fixes and step-by-step diagnostics.

## 8) Using this in script editor apps (mobile/lightweight editors)

If you use editors like Acode/SPCK, follow `docs/SCRIPT_EDITOR_SETUP.md`. The project is now in **Groovy Gradle** format (`build.gradle` files), which is easier to edit in many script editors.
