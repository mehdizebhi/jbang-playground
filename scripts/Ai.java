///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.3
//DEPS dev.langchain4j:langchain4j-google-ai-gemini:1.0.0-beta2
//DEPS dev.langchain4j:langchain4j:1.0.0-beta2
//DEPS org.apache.logging.log4j:log4j-api:2.24.3
//DEPS org.apache.logging.log4j:log4j-core:2.24.3
//DEPS org.apache.logging.log4j:log4j-slf4j2-impl:2.24.3

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

@Command(name = "Ai", mixinStandardHelpOptions = true, version = "Ai 0.1",
        description = "Ai chat model")
class Ai implements Callable<Integer> {

    @Option(names = {"--prompt", "-p"}, required = true, description = "The user prompt")
    private String prompt;

    public static void main(String... args) {
        int exitCode = new CommandLine(new Ai()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {

        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .modelName("gemini-1.5-flash")
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .build();

        String response = gemini.chat(prompt);
        System.out.println(response);

        return 0;
    }
}
