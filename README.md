# Tines

This sandbox contains a sample React application connected to a Java Spring Boot API. It lets candidates verify that they can run the coding challenge environment before their interview.

## Requirements

The project pins its development tools to match the coding challenge:

| Tool | Required version | Source of truth |
| --- | --- | --- |
| JDK | 17–25; JDK 17 is the default | `.sdkmanrc`, `backend/pom.xml` |
| Node.js | 22.23.1 | `.node-version` |
| Yarn | 4.13.0 | `package.json` |

You do not need to install Maven globally; the repository contains a Maven wrapper.

Install any JDK from 17 through 25 from [Adoptium](https://adoptium.net/). The checked-in SDKMAN configuration selects JDK 17 as the reproducible default:

```bash
sdk env install
sdk env
```

Install the Node.js version from `.node-version` with your preferred version manager. Node includes Corepack, which supplies the repository's pinned Yarn version:

```bash
corepack enable
```

## Quick start

Run all commands from the repository root:

```bash
t/doctor
t/setup
t/start
```

- `t/doctor` validates the JDK, Node, Yarn, Maven wrapper, and development ports.
- `t/setup` installs frontend dependencies and downloads backend dependencies.
- `t/start` starts Spring Boot on port 8000 and Next.js on port 3000.

Open [http://localhost:3000](http://localhost:3000).

Stop both processes with `Ctrl+C`.

## IntelliJ IDEA

1. Open the repository root, not only the `backend` directory.
2. If IntelliJ does not detect the backend automatically, right-click `backend/pom.xml` and select **Add as Maven Project**.
3. In **File → Project Structure**, select a JDK from 17 through 25. Keep the project language level at 17.
4. Under **Build, Execution, Deployment → Maven → Runner**, select the project JDK. Do the same for the Maven importer if it uses a different JDK.
5. Under **Languages & Frameworks → JavaScript Runtime**, select Node.js 22 and Yarn as the package manager.
6. Select **Backend**, **Frontend**, or **Full stack** from the shared run-configuration dropdown. Alternatively, run `t/start` in IntelliJ's terminal.

The shared configurations live in `.run/` and contain no machine-specific JDK paths. The project uses a conventional `node_modules` install so JavaScript and TypeScript indexing works without Plug'n'Play-specific IDE configuration. Formatting basics are shared through `.editorconfig`; personal IntelliJ workspace files remain local.

## Tests

```bash
t/test
```

## Troubleshooting

Start with:

```bash
t/doctor
```

- **Wrong JDK in IntelliJ:** confirm the Project SDK, Maven runner, and Maven importer all use the same supported JDK from 17 through 25, then reload the Maven project.
- **Java imports are unresolved:** add `backend/pom.xml` as a Maven project and use **Reload All Maven Projects**.
- **JavaScript imports are unresolved:** run `t/setup`, confirm `node_modules` exists, and restart TypeScript services or invalidate IntelliJ's caches.
- **Yarn has the wrong version:** run `corepack enable`, then verify with `corepack yarn --version`.
- **Port 3000 or 8000 is busy:** `t/doctor` reports the conflict. Stop the existing process before starting the sandbox.

