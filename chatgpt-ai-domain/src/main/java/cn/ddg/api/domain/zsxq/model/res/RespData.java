package cn.ddg.api.domain.zsxq.model.res;

import cn.ddg.api.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * @program: chatGpt-test
 * @description: 回答的结果数据
 * @author: Ljd
 * @create: 2023~03~09 21:09
 */
public class RespData {
    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
