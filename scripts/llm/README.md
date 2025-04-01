# LLM Chat Cli

This project uses various tools to execute a command-line interface (CLI) program. It leverages `Jbang` to run Java code without needing to set up a full Java project. Additionally, `picocli` is used for building the CLI, and `langchain4j` is used for working with language models. Finally, `gemini` is used for data processing.

## Tools Used

- **[JBang](https://www.jbang.dev/)**: A tool for running Java scripts without needing to build a full Java project.
- **[Picocli](https://picocli.info/)**: A library for creating command-line interfaces (CLI) in Java.
- **[Langchain4j](https://github.com/hub4j/langchain4j)**: A Java library for working with language models similar to LangChain.
- **[Gemini](https://docs.langchain4j.dev/integrations/language-models/google-ai-gemini)**: A LLM Model from google.

## Installing JBang

To use JBang, you need to install it first. Please follow the instructions at the following link:

[Install JBang](https://www.jbang.dev/download/)

## Running the Code with JBang

Once JBang is installed, you can run your Java code directly with the following command:

```bash
jbang LlmCli.java
```

This command allows you to execute your code without needing to create a full Java project.

## Creating a Native Image with GraalVM

To create a native executable (native image) using GraalVM, first, you need to export the JAR file. Use the following command to export it:

```bash
jbang export portable LlmCli.java
```

This command generates the JAR file with the necessary dependencies.

### Building the Executable with GraalVM

Once the JAR file is generated, you can build the native executable (exe) using the following command:

```bash
native-image -cp .\lib\picocli-4.6.3.jar  -H:ReflectionConfigurationFiles=reflect-config.json -jar .\LlmCli.jar aicli
```

This will generate a native executable that you can run directly on your system.

### Running the Executable

Once you have built the `aicli.exe` executable, you can run it with the following command:

```bash
aicli.exe -p "Tell me a dad joke."
```

This will execute the program and provide a response based on the prompt provided.

```bash
# Example output:
"Why don't scientists trust atoms? 

Because they make up everything!"
```

This is how you can interact with the executable in the command line.

### Adding the Executable to Your PATH

To make it easier to run `aicli.exe` from any location in the terminal, you can add it to your system’s PATH environment variable.

#### On Windows

1. Place the `aicli.exe` file in a folder (e.g., `C:\tools\aicli`).
2. Open **Control Panel** and navigate to **System and Security** > **System** > **Advanced System Settings**.
3. Click on **Environment Variables**.
4. Under **System variables**, find the **Path** variable, select it, and click **Edit**.
5. In the **Edit Environment Variable** window, click **New** and add the path to the folder where `aicli.exe` is located (e.g., `C:\tools\aicli`).
6. Click **OK** to save the changes.
7. Open a new terminal window, and now you can run `aicli.exe` from anywhere by simply typing:

```bash
aicli.exe -p "Tell me a dad joke."
```

By adding it to the PATH, you can easily execute the program from any directory in the terminal without needing to specify the full path to the executable.

---

This is how you can set up the executable for easier access from any terminal window.
