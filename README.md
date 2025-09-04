# Smart Email Reply Generator

A Chrome Extension and accompanying backend that injects an AI-powered "Reply" button directly into Gmail’s compose interface. When clicked, it captures the email content, sends it to a Java Spring Boot API, and inserts a smart, tone-aware reply based on user selection.

---
## 🚀 Features

* **Chrome Extension**

  * Injects an **AI Reply** button into Gmail’s compose toolbar using a content script and `MutationObserver`.
  * Reads current email content via DOM selectors.
  * Allows users to choose a tone (e.g., Professional, Friendly, Casual).
* **Backend API**

  * Built with **Java** and **Spring Boot**.
  * Exposes a `POST /api/email/generate` endpoint that accepts `{ emailContent, tone }`.
  * Integrates with an AI model (or mock logic) to generate replies.

## 🛠️ Tech Stack

* **Frontend (Chrome Extension)**
  * React,Material Ui, Mutation Observer,CSS
  * JavaScript (ES6+)
  * Chrome Extension Content Scripts & Manifest V3
  * DOM Manipulation & `fetch` API
* **Backend**

  * Java 11+
  * Spring Boot, Spring AI
  * Maven for build and dependency management
  *  Integration with OpenAI or another LLMs

## 📂 Repository Structure

```
├── backend
│   ├── src/main/java/...        # Spring Boot application code
│   ├── src/main/resources/...   # application properties, etc.
│   └── pom.xml                  # Maven configuration
├── extension
│   ├── manifest.json            # Chrome Extension manifest (v3)
│   ├── content.js               # Content script for Gmail injection
│   └── icons/                   # Extension icons
└── README.md                    # Project overview (you’re here)
```

## 💻 Installation

### 1. Backend Setup

1. Clone the repo and navigate to `backend`:

   ```bash
   git clone https://github.com/Nikhil-Vardhan1911/SmartEmail-Reply-Generator.git
   cd <repo>/backend
   ```
2. Configure CORS in `application.properties` or via a WebConfig to allow `http://localhost:3000` (if testing with a local frontend).
3. Build and run:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   The API will be available at `http://localhost:8080/api/email/generate`.

### 2. Chrome Extension Setup

1. Navigate to the `extension` folder:

   ```bash
   cd <repo>/extension
   ```
2. Open Chrome and go to `chrome://extensions/`.
3. Enable **Developer mode** (toggle in the top right).
4. Click **Load unpacked** and select the `extension` directory.
5. Ensure the extension appears and is enabled.

## ⚙️ Configuration

* **Backend**: You can switch AI providers or mock logic inside your Spring service class. Update your OpenAI API key or service endpoint in `application.properties`.
* **Extension**: You can adjust the DOM selectors or add tone options right in `content.js`.

## 🚀 Usage

1. Open Gmail and compose or reply to an email.
2. Click the **AI Reply** button in the toolbar.
3. Wait for the button to show **Generating...**, then resume.
4. The generated reply will be inserted into your compose box.

## 🧑‍🏫 Development

* **Backend**: Run your IDE (IntelliJ/Eclipse) against the `backend` module. Use Postman/cURL to test:

  ```bash
  curl -X POST http://localhost:8080/api/email/generate \
    -H "Content-Type: application/json" \
    -d '{ "emailContent": "Hello", "tone": "professional" }'
  ```

* **Extension**: Edit `extension/content.js` and reload the extension in Chrome.

## 🤝 Contributing

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/my-new-feature`.
3. Commit your changes and push: `git push origin feature/my-new-feature`.
4. Open a Pull Request describing your changes.
