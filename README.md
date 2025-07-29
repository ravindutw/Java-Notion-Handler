# Notion API Handler Java

A comprehensive Java library for interacting with the Notion API and handling Notion webhooks. This project simplifies the process of modifying Notion databases, querying data, and extracting values from Notion API responses and webhook requests. Designed for ease of use and extensibility, this library is ideal for developers looking to integrate Notion with their Java applications.

---

## Features

- **Modify Notion Databases:** Easily update, create, or delete entries in your Notion databases.
- **Query Notion Databases:** Perform complex queries and retrieve structured data from Notion.
- **Extract Values:** Effortlessly extract and process values from Notion API responses and webhook payloads.
- **Webhook Handling:** Seamlessly handle incoming Notion webhook requests for real-time integrations.
- **Extensible & Modular:** Clean, modular codebase for easy customization and extension.

---

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Overview](#api-overview)
- [Webhook Handling](#webhook-handling)
- [Examples](#examples)
- [License](#license)

---

## Installation

### Prerequisites
- Java 8 or higher (Java 21 is recommended)
- Maven (for dependency management and building)

### Clone the Repository
```bash
git clone https://github.com/yourusername/Notion-API-Handler-Java.git
cd Notion-API-Handler-Java
```

### Build with Maven
```bash
mvn clean install
```

---

## Usage

Add the built JAR to your project's dependencies.

### Example: Basic Usage
```java
import com.ravinduw.software.notionhandler.NotionAPIHandler;

NotionAPIHandler handler = new NotionAPIHandler("YOUR_NOTION_API_KEY");
// Query a database
String response = handler.queryDatabase("DATABASE_ID");
System.out.println(response);
```

---

## API Overview

### NotionAPIHandler
- `NotionAPIHandler(String apiKey)`: Initialize with your Notion integration API key.
- `String queryDatabase(String databaseId)`: Query a Notion database and get the raw JSON response.
- `String updateDatabase(String databaseId, Map<String, Object> properties)`: Update a database entry.
- `String createDatabase(Map<String, Object> properties)`: Create a new database entry.
- `String deleteDatabase(String databaseId)`: Delete a database entry.

### NotionAttributeBuilder
- Utility class for building Notion property objects for API requests.

### NotionExtractor
- Utility class for extracting values from Notion API responses and webhook payloads.

---

## Webhook Handling

To handle Notion webhooks, set up an HTTP endpoint in your application and use `NotionExtractor` to process incoming requests.

```java
import com.ravinduw.software.notionhandler.NotionExtractor;

// In your HTTP handler:
String webhookPayload = ...; // Get JSON payload from request
Map<String, Object> extracted = NotionExtractor.extractValues(webhookPayload);
```

---

## Examples

### Query a Database
```java
String response = handler.queryDatabase("DATABASE_ID");
```

### Update a Database Entry
```java
Map<String, Object> properties = new HashMap<>();
properties.put("Name", "New Value");
String response = handler.updateDatabase("DATABASE_ID", properties);
```

### Handle a Webhook
```java
String payload = ...; // JSON from webhook
Map<String, Object> data = NotionExtractor.extractValues(payload);
```

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or support, please open an issue on GitHub or contact the maintainer.

---

## Acknowledgements

- [Notion API Documentation](https://developers.notion.com/)
