# OJPMS — Manual Setup (do this after unzipping)

## What changed in this zip
- Removed a duplicate `spring-boot-starter-mail` dependency in `pom.xml`.
- Removed the **hardcoded Gmail address/app password** and the **hardcoded Postgres
  password** from `src/main/resources/application.properties`. They're now read from
  environment variables (with `CHANGE_ME` placeholders as fallback) so real secrets
  never sit in the project files or get committed to git.

## 1. Rotate the leaked Gmail credential (do this first, security)
The original file had a real Gmail account (`saurabhpawar0199@gmail.com`) and app
password exposed in plaintext. If this project has ever been shared, pushed to GitHub,
or zipped/sent to anyone:
1. Go to Google Account → Security → App passwords.
2. Revoke the old app password.
3. Generate a new one (used only for this app).

## 2. Install & start PostgreSQL
- Install PostgreSQL locally if you don't have it.
- Create the database:
  ```sql
  CREATE DATABASE ojpms1;
  ```
  Tables are created automatically on first run (`spring.jpa.hibernate.ddl-auto=update`).

## 3. Set your environment variables
Before running the app, set these (replace with your real values):

**macOS/Linux (bash/zsh):**
```bash
export DB_USERNAME=postgres
export DB_PASSWORD=your_actual_postgres_password
export MAIL_USERNAME=your_real_address@gmail.com
export MAIL_PASSWORD=your_new_app_password
```

**Windows (PowerShell):**
```powershell
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="your_actual_postgres_password"
$env:MAIL_USERNAME="your_real_address@gmail.com"
$env:MAIL_PASSWORD="your_new_app_password"
```

If you don't need the "forgot password" email feature working right now, you can skip
the MAIL_* variables — the rest of the app runs fine without them (email sending will
just fail/log an error when that one feature is used).

**In Eclipse/IntelliJ instead:** set these same key/value pairs under
Run Configuration → Environment Variables, rather than exporting them in a terminal.

## 4. Run the app in dev mode (not the packaged jar)
JSPs under `src/main/webapp/WEB-INF/jsp` will not render correctly from a packaged
executable jar (`java -jar target/ojpms-0.0.1-SNAPSHOT.jar`) — that's a known
limitation of JSP + Spring Boot's default jar packaging. Instead:

```bash
./mvnw spring-boot:run
```
(or `mvnw.cmd spring-boot:run` on Windows), or run `OjpmsApplication.java` directly
from your IDE.

## 5. Open it
Visit http://localhost:8080/ once the console shows Tomcat started with no stack trace.

## Still manual / not fixed in this zip
- Passwords are stored and compared in plaintext in the `users` table (no hashing).
  Fine for a learning project; flag this if this is ever meant for real users.
- No Spring Security — auth is hand-rolled via HTTP session.
- If you want to run this as a deployable `.war` file instead of `spring-boot:run`,
  you'd need to add `<packaging>war</packaging>` to `pom.xml` and make
  `OjpmsApplication` extend `SpringBootServletInitializer` — not done here since it
  wasn't clear you needed a production deployment.
