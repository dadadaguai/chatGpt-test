package cn.ddg.api.domain.chatgpt;

import java.io.IOException;

public interface IOpenAI {
    String doChatGPT(String openAiKey, String question) throws IOException;
}
