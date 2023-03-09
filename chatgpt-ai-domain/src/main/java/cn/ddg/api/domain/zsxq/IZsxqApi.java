package cn.ddg.api.domain.zsxq;

import cn.ddg.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * 知识星球API接口
 */
public interface IZsxqApi {
    // 未回答问题
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;
    // 回答问题的答案
    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}
