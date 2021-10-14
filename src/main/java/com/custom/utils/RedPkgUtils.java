package com.custom.utils;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.custom.constants.RedPkg;
import com.custom.dao.TryxxDao;
import com.custom.entity.Tryxx;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 邵禹寒
 * @date: 2021-10-13 17:32
 */
public class RedPkgUtils {
    @Resource
    private TryxxDao tryxxDao;

    public void screenData(String fileName, String type) throws IOException {
        CsvReader csvReader = new CsvReader(fileName + type, ',', Charset.forName("GBK"));
        csvReader.readHeaders();
        LocalDateTime time = LocalDateTime.now();
        String ymd = time.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        CsvWriter csvWriter = new CsvWriter(fileName + ymd + type, ',', Charset.forName("GBK"));
        int index = 0;
        String[] headers = csvReader.getHeaders();
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(RedPkg.RefState)) {
                index = i;
                break;
            }
        }
        List<String> warnsCode = new ArrayList<>();
        while (csvReader.readRecord()) {
            if (csvReader.get(RedPkg.RefState).equals(RedPkg.UnValid)) {
                warnsCode.add(csvReader.get(RedPkg.RefCode));
            }
        }
        List<Tryxx> users = tryxxDao.codeToUser(warnsCode);

        csvReader.close();
        /**
         * 先取到目前没有离职的人员的证件编号。
         * 没离职的人是一定存在一条zhzt=0的记录的
         * 在职人员
         */
        List<String> onJobPeople = users.stream()
                .filter(e -> e.getZhzt().equals(RedPkg.Valid))
                .map(Tryxx::getZjbh)
                .collect(Collectors.toList());
        /**
         * 再将所有没离职的人员的证件编号下的所有记录的rybh都记录，
         * 这些rybh有可能目前是1但是应该改成0
         * 有效的业务编号
         */
        List<String> validCodes = users.stream()
                .filter(e -> onJobPeople.contains(e.getZjbh()))
                .map(Tryxx::getRybh)
                .collect(Collectors.toList());
        csvReader = new CsvReader(fileName + type, ',', Charset.forName("GBK"));
        //非常关键
        csvReader.readHeaders();
        csvWriter.writeRecord(csvReader.getHeaders());

        /**
         * 再一次遍历红包文件，找到所有营销人员状态为1的数据，
         * 如果此条数据的营销码(rybh)在上述list中，则需要把状态改成0
         */
        while (csvReader.readRecord()) {
            String[] values = csvReader.getValues();
            if (csvReader.get(RedPkg.RefState).equals(RedPkg.UnValid)) {
                if (validCodes.contains(csvReader.get(RedPkg.RefCode))) {
                    values[index] = RedPkg.Valid;
                }
            }
            csvWriter.writeRecord(values);
        }
        csvWriter.close();
        csvReader.close();
    }
}
