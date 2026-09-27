# tavall-concurrency

Small Java 25 concurrency helpers for asynchronous work and write-once state.

A single-module library containing a virtual-thread-backed asynchronous task runner and an immutable-after-assignment value holder.

## Why tavall-concurrency

- A small shared API for dispatching asynchronous work.
- A write-once container for values that become immutable after initialization.

## Features

- AsyncTask.runAsync(...) and supplyAsync(...) return CompletableFuture results.
- AsyncTask.namingThreadFactory(...) supports named worker creation.
- ImmutableLock stores a value once and exposes get() and isSet().

## Quick Start

Add the published artifact to a Gradle project:

```kotlin
dependencies {
    implementation("org.tavall:tavall-concurrency:<version>")
}
```

Use the exact published version and repository access configured for your project. See the links below for API and contribution details.

## Project Structure

This repository is a single Java library module (Module Type: LIBRARY; Runtime: None).

## Documentation

| Document | Purpose |
| --- | --- |
| [Contributing](CONTRIBUTING.md) | Contribution and development notes. |
| [Repository Git Workflow](docs/quality/GIT_WORKFLOW.md) | Applicable repository guidance. |

## Requirements / Compatibility

Java 25.

## Building From Source

```bash
./gradlew check
```

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md).

## License

No tracked license file is present in the current repository tree.

## Documentation Update State

<details>
<summary>Documentation Update State</summary>

### Current Locations

| Surface | Sync State | Location | Last Updated | Evidence |
| --- | --- | --- | --- | --- |
| GitHub | PRIMARY | TavallStudios/tavall-concurrency/README.md | 2026-09-27 12:29 PM PDT | Migration PR. |
| Notion | NOT_APPLICABLE | — | 2026-09-27 12:29 PM PDT | README files are not synchronized as Notion twins. |

### Update History

| Timestamp | Surface | Event | Location | Previous Location | Evidence | Notes |
| --- | --- | --- | --- | --- | --- | --- |
| 2026-09-27 12:29 PM PDT | GitHub | UPDATED | TavallStudios/tavall-concurrency/README.md | Same path | Migration PR. | Reworked the public README to describe the current project, module boundary, usage, and documentation. |

</details>
