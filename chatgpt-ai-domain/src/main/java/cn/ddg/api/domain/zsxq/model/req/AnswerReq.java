package cn.ddg.api.domain.zsxq.model.req;

/**
 * @program: chatGpt-test
 * @description: 请求问答接口信息
 * @author: Ljd
 * @create: 2023~03~09 21:08
 */
public class AnswerReq {
    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
