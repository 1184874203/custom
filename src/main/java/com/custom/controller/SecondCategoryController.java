package com.custom.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.custom.constants.MyException;
import com.custom.dto.NLP.NlpReq;
import com.custom.entity.SecondCategory;
import com.custom.entity.User;
import com.custom.entity.dto.SecondCodeDto;
import com.custom.pojo.NewResp;
import com.custom.pojo.NewsBasicResp;
import com.custom.pojo.NewsSourceReq;
import com.custom.pojo.NewsSourceResp;
import com.custom.service.SecondCategoryService;
import com.custom.utils.MyUrl;
import com.custom.utils.RestUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.slf4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.custom.constants.ExceptionEnum.AGE_EXCEPTION;

/**
 * (SecondCategory)表控制层
 *
 * @author 邵禹寒
 * @since 2021-09-02 17:51:09
 */
@RestController
@RequestMapping("secondCategory")
public class SecondCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private SecondCategoryService secondCategoryService;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyUrl myUrl;

    @Resource
    private RestUtils restUtils;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SecondCategory selectOne(Integer id) {
        return this.secondCategoryService.queryById(id);
    }

    /**
     * 通过一级类目code查询对应二级类目
     *
     * @param code
     * @return
     */
    @GetMapping("secondCode/{code}")
    public List<SecondCodeDto> queryScByFc(@PathVariable("code") String code) {
        return secondCategoryService.queryScByFc(code);
    }

    @GetMapping("tt/{id}/{name}")
    public List<User> tt(@PathVariable String name, @PathVariable int id) {
        List<User> list = Arrays.asList(new User(1, "a", ""), new User(2, "b", ""));
        return list;
    }

    @GetMapping(value = "get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String query() {
        SecondCodeDto build = SecondCodeDto.builder()
                .code("oaa")
                .description("败了")
                .build();
        return JSON.toJSONString(build);
    }

    @GetMapping("rest/{code}")
    public List<SecondCodeDto> rest(@PathVariable("code") String code) {
        String url = myUrl.getUrl() + myUrl.getMethods().get("getTitles") + code;
        return restTemplate.getForObject(url, List.class);
    }

    @PostMapping("post")
    public String post(@RequestBody NlpReq nlpReq) {
        return "post" + nlpReq.getText();
    }

    @Resource
    private HttpHeaders headers;

    @PostMapping("mypost")
    public String myPost(@RequestBody NlpReq nlpReq) {
        String url = myUrl.getUrl() + myUrl.getMethods().get("postTest");
        // MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        // params.add("text", "oaa");
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<NlpReq> entity = new HttpEntity<>(nlpReq, headers);
        return restTemplate.postForObject(url, entity, String.class);
    }

    @Resource
    private Logger log;

    @GetMapping("haha")
    public List<User> haha(@RequestParam String name, @RequestParam int id) {
        User user = new User(id, name, "");
        try {
            ResponseEntity<List<User>> tt = (ResponseEntity<List<User>>) restUtils.getWithParams("", "tt", user, List.class);
            log.info("users: {}", tt.getBody());
            return tt.getBody();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Resource
    private GroupTemplate groupTemplate;

    @GetMapping("ideel")
    public String index(@RequestParam String title, @RequestParam String head1,
                        @RequestParam String body) throws FileNotFoundException {

        Template template = groupTemplate.getTemplate("templates/index.btl");
        template.binding("title", title);
        template.binding("head1", head1);
        template.binding("body", body.replaceAll("\\s", "&nbsp;"));

        File file = new File("C:\\Users\\11848\\Desktop");
        if (!file.exists()) {
            file.mkdirs();
        }

        String fileName = UUID.randomUUID().toString().replace("-", "") + ".html";
        File htmlFile = new File(file, fileName);

        PrintWriter writer = new PrintWriter(htmlFile);

        template.renderTo(writer);
        return "文件名为：" + fileName;
    }

    @GetMapping("laile")
    public List<NewResp> laile() {
        NewsSourceReq build = NewsSourceReq.builder()
                .clientId(102)
                .securityType("1")
                .securityCode("002594.SZ")
                .newsType("1")
                .pageNum(0)
                .pageSize(10)
                .build();
        HttpEntity<NewsSourceReq> httpEntity = new HttpEntity<>(build, headers);
        Object o = restTemplate.postForObject("http://10.189.67.41:8084/api/news/querySecurityNews", httpEntity, Object.class);
        NewsBasicResp newsBasicResp = JSONObject.parseObject(JSONObject.toJSONString(o), NewsBasicResp.class);
        NewsSourceResp data = newsBasicResp.getData();
        return data.getData();
    }

    @GetMapping("gg")
    public String gger(@RequestParam Integer age) throws Exception {
        if (age < 0) {
            throw new MyException(AGE_EXCEPTION);
        }
        return "hello";
    }

    @GetMapping("redis/{id}/{name}")
    public String redis(@PathVariable Integer id, @PathVariable String name) {
        redisTemplate.opsForValue().set(id, name);
        return "hello";
    }


}