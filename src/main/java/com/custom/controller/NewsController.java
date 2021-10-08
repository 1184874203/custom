package com.custom.controller;

import com.custom.entity.News;
import com.custom.service.NewsService;
import com.custom.utils.TemplateUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * (News)表控制层
 *
 * @author 邵禹寒
 * @since 2021-09-16 15:20:35
 */
@RestController
@RequestMapping("news")
public class NewsController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService newsService;

    @Resource
    private TemplateUtils templateUtils;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public News selectOne(Integer id) {
        return this.newsService.queryById(id);
    }


    @GetMapping("news/{id}")
    public String genNews(@PathVariable Integer id) throws FileNotFoundException, IllegalAccessException {
        News news = newsService.queryById(id);
        // Template template = groupTemplate.getTemplate("templates/index.btl");
        // template.binding("title", news.getTitle());
        // template.binding("head1", news.getHead());
        // template.binding("body", news.getBody().replaceAll("[\r\n|\r|\n]{1,2}", "<br/>")
        //         .replaceAll("\\s", "&nbsp;"));
        // File location = new File("C:\\Users\\11848\\Desktop");
        // String fileName = UUID.randomUUID().toString().replace("-", "") + ".html";
        // File file = new File(location, fileName);
        // PrintWriter writer = new PrintWriter(file);
        // template.renderTo(writer);
        // return "文件名为：" + fileName;

        return templateUtils.genHtml("C:\\Users\\11848\\Desktop", news, "templates/index.btl");


    }
}