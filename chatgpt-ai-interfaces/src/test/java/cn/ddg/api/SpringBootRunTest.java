package cn.ddg.api;

import cn.ddg.api.domain.chatgpt.IOpenAI;
import cn.ddg.api.domain.chatgpt.service.OpenAI;
import cn.ddg.api.domain.zsxq.IZsxqApi;
import cn.ddg.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.ddg.api.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @program: chatGpt-test
 * @description:
 * @author: Ljd
 * @create: 2023~03~09 21:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatGpt-test.groupId")
    private String groupId;
    @Value("${chatGpt-test.cookie")
    private String cookie;
    @Value("${chatGpt-test.openAiKey}")
    private String openAiKey;

    @Resource
    private IOpenAI openAI;
    @Resource
    private IZsxqApi zsxqApi;

    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId：{} text：{}", topicId, text);

            // 回答问题
            zsxqApi.answer(groupId, cookie, topicId, openAI.doChatGPT(openAiKey, text), false);
        }
    }

    @Test
    public void test_openAi() throws IOException {
        String response = openAI.doChatGPT(openAiKey, "帮我写一个java冒泡排序");
        logger.info("测试结果：{}", response);
    }
}
