# iChat Production Workflow (End-to-End)

## Phase 0 — Discovery (1-2 weeks)
1. Define ICP and target geographies.
2. Write PRD with acceptance criteria per feature.
3. Threat model (STRIDE) and privacy impact assessment.
4. Capacity estimate: DAU, peak concurrent sockets, media throughput.

## Phase 1 — Platform foundation (2-4 weeks)
1. CI/CD: GitHub Actions + fastlane + Play Console tracks.
2. Environment separation: dev/stage/prod with secret manager.
3. Telemetry baseline:
   - Crash: Firebase Crashlytics.
   - Metrics: Prometheus + Grafana.
   - Tracing: OpenTelemetry.
4. SLOs: message delivery p95, connect success rate, crash-free sessions.

## Phase 2 — Core messaging (4-8 weeks)
1. Auth service:
   - OTP rate limit, device fingerprint, suspicious login signals.
2. Messaging service:
   - WebSocket session manager.
   - Idempotent message IDs.
   - Offline queue + at-least-once semantics.
3. Media service:
   - Signed upload URLs.
   - Malware scanning.
   - Thumbnail pipeline.
4. Client sync:
   - Delta sync tokens.
   - Retry strategy with exponential backoff.

## Phase 3 — Security hardening (2-4 weeks)
1. E2EE design (Double Ratchet or audited equivalent).
2. Key backup + recovery UX.
3. Pen-testing and static analysis gates.
4. Abuse prevention:
   - Spam scoring.
   - Report-user pipeline.
   - Automated account actions with human review.

## Phase 4 — Pre-launch readiness (2 weeks)
1. Load test at 3x expected peak.
2. Incident response runbooks.
3. On-call rotation and escalation matrix.
4. Play Store listing assets, app content declaration, policy checks.

## Phase 5 — Launch and growth
1. Soft launch in one country.
2. Measure retention (D1/D7/D30), message send success, notification open rate.
3. Weekly quality gates before geographic expansion.
