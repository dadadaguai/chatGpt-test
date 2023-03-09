package cn.ddg.api;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLOutput;

/**
 * @program: chatGpt-test
 * @description:
 * @author: Ljd
 * @create: 2023~03~09 18:16
 */
public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 星球提问地址
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885882485881/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","zsxq_access_token=7528A0B2-811B-93FE-1E17-4827B1CF2FDA_40A150BB70AF1723; zsxqsessionid=a43585607ebf740bd9e581372470d960; abtest_env=product; UM_distinctid=186c61c33c4c72-0e2401bc6a484-26021051-144000-186c61c33c5f15; sensorsdata2015jssdkcross={\"distinct_id\":\"415442412552118\",\"first_id\":\"186b206b52813c-0d43fc590e41e1-26021051-1327104-186b206b5291048\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2YjIwNmI1MjgxM2MtMGQ0M2ZjNTkwZTQxZTEtMjYwMjEwNTEtMTMyNzEwNC0xODZiMjA2YjUyOTEwNDgiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU0NDI0MTI1NTIxMTgifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"415442412552118\"},\"$device_id\":\"186b206b52813c-0d43fc590e41e1-26021051-1327104-186b206b5291048\"}; ajs_user_id=0XgOwjTXb7X97DIjogV9kKo664B3; ajs_anonymous_id=c929cc2e-54a8-4df8-b9bd-7c529e576245");
        get.addHeader("ContentType","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println( response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412815224218228/answer");
        post.addHeader("cookie","zsxq_access_token=7528A0B2-811B-93FE-1E17-4827B1CF2FDA_40A150BB70AF1723; zsxqsessionid=a43585607ebf740bd9e581372470d960; abtest_env=product; UM_distinctid=186c61c33c4c72-0e2401bc6a484-26021051-144000-186c61c33c5f15; sensorsdata2015jssdkcross={\"distinct_id\":\"415442412552118\",\"first_id\":\"186b206b52813c-0d43fc590e41e1-26021051-1327104-186b206b5291048\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2YjIwNmI1MjgxM2MtMGQ0M2ZjNTkwZTQxZTEtMjYwMjEwNTEtMTMyNzEwNC0xODZiMjA2YjUyOTEwNDgiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU0NDI0MTI1NTIxMTgifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"415442412552118\"},\"$device_id\":\"186b206b52813c-0d43fc590e41e1-26021051-1327104-186b206b5291048\"}; ajs_user_id=0XgOwjTXb7X97DIjogV9kKo664B3; ajs_anonymous_id=c929cc2e-54a8-4df8-b9bd-7c529e576245");
        post.addHeader("ContentType","application/json; charset=UTF-8");

        String answerParamJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我才不告诉你，不告诉你。\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";
        StringEntity entity = new StringEntity(answerParamJson, ContentType.create("test/json","UTF-8"));
        post.setEntity(entity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println( response.getStatusLine().getStatusCode());
        }
    }
}
