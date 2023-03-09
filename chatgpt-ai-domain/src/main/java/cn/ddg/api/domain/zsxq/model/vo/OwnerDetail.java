package cn.ddg.api.domain.zsxq.model.vo;

/**
 * @program: chatGpt-test
 * @description:
 * @author: Ljd
 * @create: 2023~03~09 21:01
 */
public class OwnerDetail {

    private int questions_count;

    private String join_time;

    public void setQuestions_count(int questions_count){
        this.questions_count = questions_count;
    }
    public int getQuestions_count(){
        return this.questions_count;
    }
    public void setJoin_time(String join_time){
        this.join_time = join_time;
    }
    public String getJoin_time(){
        return this.join_time;
    }
}
