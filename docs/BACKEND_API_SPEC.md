# iChat Backend API Spec (Starter)

## Auth
### POST /v1/auth/otp/request
Request OTP for phone/email.

### POST /v1/auth/otp/verify
Validate OTP and return access + refresh token.

## User
### GET /v1/users/me
Return profile, privacy settings, and device sessions.

### PATCH /v1/users/me
Update profile metadata.

## Conversations
### GET /v1/conversations?cursor=...
Paginated conversation list sorted by last activity.

### POST /v1/conversations
Create 1:1 or group conversation.

## Messages
### GET /v1/conversations/{id}/messages?cursor=...
Fetch paginated history.

### POST /v1/conversations/{id}/messages
Send text/media reference message.

### POST /v1/messages/{id}/ack
Update delivered/seen status.

## Realtime (WebSocket)
- `message.new`
- `message.ack`
- `conversation.typing`
- `presence.changed`

## Security notes
- Use short-lived JWT access token + rotating refresh token.
- Server-side message schema validation.
- Signed URLs for media.
- Encrypt PII at rest; TLS 1.2+ in transit.
