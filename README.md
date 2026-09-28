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

`tavall-concurrency/` (root Gradle project)
- **Root Java source/build module** ← This Module — `src/main/java/`, `build.gradle.kts`

Module Type: `LIBRARY`; Runtime Owner: `None`.

## Documentation

| Document | Purpose |
| --- | --- |
| [Module Progression](docs/progression/TAVALL_CONCURRENCY_PROGRESSION.md) | Audited module implementation, integration, validation, and history. |
| [Contributing](CONTRIBUTING.md) | Contribution and development notes. |
| [Repository Git Workflow](docs/quality/GIT_WORKFLOW.md) | Applicable repository guidance. |

## Module Development

- **Module Type:** `LIBRARY`
- **Runtime Owner:** `None`
- **Current PR Stack:** README and module Progression [#10](https://github.com/TavallStudios/tavall-concurrency/pull/10); platform integration [#6](https://github.com/TavallStudios/tavall-concurrency/pull/6) (draft to `main`); CI localization [#7](https://github.com/TavallStudios/tavall-concurrency/pull/7) (draft to `staging/platform`).
- **Module-local CI Definition:** Missing from current `main`: `.tavallci/ci.yaml` (required for a Tavall source/build module). This documentation PR records the gap and does not change CI configuration.

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
| GitHub | PRIMARY | TavallStudios/tavall-concurrency/README.md | 2026-09-27 5:33 PM PDT| PR [#17](https://github.com/TavallStudios/tavall-concurrency/pull/10) updated to correct table formatting. |
| Notion | NOT_APPLICABLE | — | 2026-09-27 12:29 PM PDT | README files are not synchronized as Notion twins. |

### Update History

| Timestamp | Surface | Event | Location | Previous Location | Evidence | Notes |
| --- | --- | --- | --- | --- | --- | --- |
| 2026-09-27 12:29 PM PDT | GitHub | UPDATED | TavallStudios/tavall-concurrency/README.md | Same path | https://github.com/TavallStudios/tavall-concurrency/pull/10. | Reworked the public README to describe the current project, module boundary, usage, and documentation. |
| 2026-09-27 5:32 PM PDT | GitHub | UPDATED | TavallStudios/tavall-concurrency/README.md | Same path | PR [#10](https://github.com/TavallStudios/tavall-concurrency/pull/10) | Added the required root-module Progression route, visible module marker, classification, PR stack, and CI-definition state. |
| 2026-09-27 5:33 PM PDT | GitHub | UPDATED | TavallStudios/tavall-concurrency/README.md | Same path | PR [#10](https://github.com/TavallStudios/tavall-concurrency/pull/10) | Corrected the Documentation table row order; preserved module routing and development details. |

</details>
