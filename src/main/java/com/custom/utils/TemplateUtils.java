package com.custom.utils;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.UUID;

/**
 * @author: 邵禹寒
 * @date: 2021-09-16 15:38
 */
@Component
public class TemplateUtils {


    public String genHtml(String location, Object o, String templatePath) throws IllegalAccessException, FileNotFoundException {
        Template template = groupTemplate.getTemplate(templatePath);
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            template.binding(field.getName(),
                    field.get(o).toString()
                            .replaceAll("[\r\n|\r|\n]{1,2}", "<br/>")
                            .replaceAll("\\s", "&nbsp;"));
        }
        File path = new File(location);
        if (!path.exists()) {
            path.mkdirs();
        }
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".html";

        File file = new File(path, fileName);
        PrintWriter writer = new PrintWriter(file);
        template.renderTo(writer);
        return "文件名：" + fileName;
    }


    @Resource
    private GroupTemplate groupTemplate;


    @Bean
    public GroupTemplate groupTemplate() throws IOException {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        org.beetl.core.Configuration cfg = org.beetl.core.Configuration.defaultConfiguration();
        cfg.setDirectByteOutput(true);
        return new GroupTemplate(resourceLoader, cfg);
    }


}
