package cn.ddg.api.domain.zsxq.model.vo;

/**
 * @program: chatGpt-test
 * @description:
 * @author: Ljd
 * @create: 2023~03~09 21:03
 */
public class UserSpecific {
    private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }
}
